package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    String pinNumber;
    JButton deposit, withdrawl, fastcash, statement, pin, balance, exit;
    Transactions(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));

        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 900,900);
        add(image);

        JLabel text = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        text.setBounds(180, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("CASH WITHDRAWL");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("FAST CASH");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        statement = new JButton("MINI STATEMENT");
        statement.setBounds(355,450,150,30);
        statement.addActionListener(this);
        image.add(statement);

        pin = new JButton("CHANGE PIN");
        pin.setBounds(170,485,150,30);
        pin.addActionListener(this);
        image.add(pin);

        balance = new JButton("CHECK BALANCE");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        image.add(balance);


        exit = new JButton("EXIT");
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
        if(ae.getSource() == exit) {
            dispose();
        }
        else if(ae.getSource() ==  deposit)
        {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        } else if (ae.getSource() == pin) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == balance)
        {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == statement)
        {
            new MiniStatement(pinNumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Transactions("");
    }
}
