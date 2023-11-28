package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pinNumber;
    public MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;

        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        JLabel bank = new JLabel("Bank OF Maharashtra");
        bank.setBounds(130,20,150,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pinNumber + "'");
            while (rs.next())
            {

                card.setText("Card Number: " + rs.getString("card_number").substring(0,4) + " XXXX XXXX " + rs.getString("card_number").substring(12));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");
            int bal = 0;
            while (rs.next())
            {
                mini.setText(mini.getText() + "<html>"+ rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");

                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            bal = Math.abs(bal);
            balance.setText("Your current account balance is Rs + " + bal);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        mini.setBounds(20,140,400,200);


        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }



    public static void main(String[] args) {
        new MiniStatement("");
    }
}
