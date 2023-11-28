package bank.management.system;


import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField, fNameTextField, emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male, female, both, married, unMarried, other;
    JDateChooser dateChooser;

    public SignupOne()
    {
        setLayout(null);
        Random rn = new Random();
        random = Math.abs((rn.nextLong() % 9000L) + 1000L);
        JLabel formNo = new JLabel("APPLICATION FORM NO. " +  random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);



        JLabel fName = new JLabel("Father's Name:");
        fName.setFont(new Font("Raleway", Font.BOLD, 20));
        fName.setBounds(100,190,200,30);
        add(fName);
        fNameTextField = new JTextField();
        fNameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fNameTextField.setBounds(300, 190, 400, 30);
        add(fNameTextField);

        JLabel DOB = new JLabel("Date Of Birth:");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100,240,200,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        female = new JRadioButton("Female");
        female.setBounds(450,290,80,30);
        female.setBackground(Color.WHITE);
        both = new JRadioButton("Other");
        both.setBounds(600, 290, 60, 30);
        both.setBackground(Color.WHITE);
        add(male);
        add(female);
        add(both);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(both);


        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel status = new JLabel("Marital Status");
        status.setFont(new Font("Raleway", Font.BOLD, 20));
        status.setBounds(100,390,200,30);
        add(status);
        married = new JRadioButton("Married");
        married.setBounds(300,390,80,30);
        married.setBackground(Color.WHITE);
        unMarried = new JRadioButton("Un-Married");
        unMarried.setBounds(450,390,120,30);
        unMarried.setBackground(Color.WHITE);
        other = new JRadioButton("Other");
        other.setBounds(600, 390, 60, 30);
        other.setBackground(Color.WHITE);
        add(married);
        add(unMarried);
        add(other);

        ButtonGroup marriedGroup = new ButtonGroup();
        marriedGroup.add(male);
        marriedGroup.add(female);
        marriedGroup.add(both);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        JLabel pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100,590,200,30);
        add(pin);
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,50);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae)
    {
        String formNo = "" + random;  //long value
        String name = nameTextField.getText();
        String fName = fNameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        else if(both.isSelected())
        {
            gender = "Both";
        }
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected())
        {
            marital = "Married";
        }
        else if(unMarried.isSelected())
        {
            marital = "Un Married";
        }
        else if(other.isSelected())
        {
            marital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin  = pinTextField.getText();

        try{
            if(name.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else if(fName.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Father Name is Required");
            }
            else if(dob.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "DOB is Required");
            }
            else if(gender.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Gender is Required");
            }
            else if(email.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Email is Required");
            }
            else if(pin.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Pin Code is Required");
            }
            Conn c = new Conn();
            //writting my sequel query
            String query = "insert into signup values('" + formNo + "', '" + name + "', '"
                    + fName + "', '" + dob + "'," +
                    " '" + gender + "', '" + email + "', '" + marital + "', " +
                    "'" + address + "', '"
                    + city + "', '" + pin + "', '" + state + "')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignUpTwo(formNo).setVisible(true);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
