package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    String pinNumber;

    JPasswordField pin, repin;
    JButton back, change;
    
    
    public PinChange(String pinNumber){
        this.pinNumber = pinNumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500,30);
        image.add(text);

        JLabel pinText = new JLabel("NEW PIN");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 320, 180, 25);
        image.add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330,320,180,25);
        image.add(pin);


        JLabel rePinText = new JLabel("RE-ENTER NEW PIN:");
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System", Font.BOLD, 16));
        rePinText.setBounds(165, 360, 180, 25);
        image.add(rePinText);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330,360,180,25);
        image.add(repin);


        change = new JButton("CHANGE");
        change.setBounds(355, 485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        try{
            String newPin = pin.getText();
            String rPin = repin.getText();
            if(!newPin.equals(rPin))
            {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
            }
            if(ae.getSource() == change)
            {
                if(pin.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Enter new PIN");
                }
                if(repin.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '" + rPin + "' where pin='" + pinNumber + "'";
                String query2 = "update login set pin = '" + rPin + "' where pin='" + pinNumber + "'";
                String query3 = "update signupthree set pin_number = '" + rPin + "' where pin_number='" + pinNumber + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
            else if(ae.getSource() == back)
            {
                new Transactions(pinNumber).setVisible(true);
                setVisible(false);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
