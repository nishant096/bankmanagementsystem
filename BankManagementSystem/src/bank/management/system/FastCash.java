package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    String pinNumber;
    JButton one, two, three, four, five, six, exit;
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));

        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 900,900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        one = new JButton("RS 100");
        one.setBounds(170,415,150,30);
        one.addActionListener(this);
        image.add(one);

        two = new JButton("RS 500");
        two.setBounds(355,415,150,30);
        two.addActionListener(this);
        image.add(two);

        three = new JButton("RS 1000");
        three.setBounds(170,450,150,30);
        three.addActionListener(this);
        image.add(three);

        four = new JButton("RS 2000");
        four.setBounds(355,450,150,30);
        four.addActionListener(this);
        image.add(four);

        five = new JButton("RS 5000");
        five.setBounds(170,485,150,30);
        five.addActionListener(this);
        image.add(five);

        six = new JButton("RS 1000");
        six.setBounds(355,485,150,30);
        six.addActionListener(this);
        image.add(six);


        exit = new JButton("BACK");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        try{
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "' ");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance = Math.abs(balance);
            String num = "17";
            if(ae.getSource() != exit && balance < Integer.parseInt(amount))
            {
                JOptionPane.showMessageDialog(null, "Insufficient balance");
                return;
            }
            if(ae.getSource() == exit) {
                this.setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
            else {
                Date date = new Date();
                c.s.executeUpdate("insert into  bank values('" + pinNumber + "', '" + date + "', ' withdrawl', '" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        new FastCash("");
    }
}
