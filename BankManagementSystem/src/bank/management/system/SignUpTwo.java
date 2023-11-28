package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpTwo extends JFrame implements ActionListener {
    JTextField religionTextField, categoryTextField, educationTextField, incomeTextField, occupationTextField,aadharTextField,panTextField;
    JButton next;
    JRadioButton cYes, cNo, aYes, aNo;
    JComboBox religionList, categoryList, occupationList, educationList, incomeList;
    String formNo;

    public SignUpTwo(String formNo)
    {
        this.formNo = formNo;
        setLayout(null);

        JLabel personalDetails = new JLabel("Page 2: Additional Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100,140,100,30);
        add(religion);

        String[] valReligion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionList = new JComboBox(valReligion);
        religionList.setBackground(Color.WHITE);
        religionList.setBounds(300, 140, 400, 30);
        add(religionList);

        religionTextField = new JTextField();
        religionTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        religionTextField.setBounds(300, 140, 400, 30);
        add(religionTextField);



        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100,190,200,30);
        add(category);
        String[] categoryNames = {"General", "OBC", "SC", "ST", "Other"};
        categoryList = new JComboBox(categoryNames);
        categoryList.setBackground(Color.WHITE);
        categoryList.setBounds(300, 190, 400, 30);
        add(categoryList);

        categoryTextField = new JTextField();
        categoryTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        categoryTextField.setBounds(300, 190, 400, 30);
        add(categoryTextField);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100,240,200,30);
        add(income);

        String[] incomeValues = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000"};
        incomeList = new JComboBox(incomeValues);
        incomeList.setBackground(Color.WHITE);
        incomeList.setBounds(300, 240, 400, 30);
        add(incomeList);

        incomeTextField = new JTextField();
        incomeTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeTextField.setBounds(300,240,400,30);
//        dateChooser.setForeground(new Color(105,105,105));
        add(incomeTextField);




        JLabel education = new JLabel("Educational Qual:");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100,290,200,30);
        add(education);

        String[] educationValues = {"Non-Graduate", "Graduate", "Post Grad", "Doctorate", "Others"};
        educationList = new JComboBox(educationValues);
        educationList.setBackground(Color.WHITE);
        educationList.setBounds(300, 290, 400, 30);
        add(educationList);

        educationTextField = new JTextField();
        educationTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        educationTextField.setBounds(300, 290, 400, 30);
        add(educationTextField);





        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100,340,200,30);
        add(occupation);

        String[] occupationValues = {"Salaried", "Self-Employed", "Business", "Student","Retired", "Others"};
        occupationList = new JComboBox(occupationValues);
        occupationList.setBackground(Color.WHITE);
        occupationList.setBounds(300, 340, 400, 30);
        add(occupationList);

        occupationTextField = new JTextField();
        occupationTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        occupationTextField.setBounds(300, 340, 400, 30);
        add(occupationTextField);

        JLabel pan = new JLabel("Pan Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100,390,200,30);
        add(pan);
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 390, 400, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100,440,200,30);
        add(aadhar);
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 440, 400, 30);
        add(aadharTextField);

        JLabel citizen = new JLabel("Senior Citezen:");
        citizen.setFont(new Font("Raleway", Font.BOLD, 20));
        citizen.setBounds(100,490,200,30);
        add(citizen);

        cYes = new JRadioButton("Yes");
        cYes.setBounds(300,490,60,30);
        cYes.setBackground(Color.WHITE);
        cNo = new JRadioButton("No");
        cNo.setBounds(550,490,80,30);
        cNo.setBackground(Color.WHITE);

        add(cYes);
        add(cNo);


        ButtonGroup citizenGroup = new ButtonGroup();
        citizenGroup.add(cYes);
        citizenGroup.add(cNo);

        JLabel account = new JLabel("Existing Account:");
        account.setFont(new Font("Raleway", Font.BOLD, 20));
        account.setBounds(100,540,200,30);
        add(account);

        aYes = new JRadioButton("Yes");
        aYes.setBounds(300,540,60,30);
        aYes.setBackground(Color.WHITE);
        aNo = new JRadioButton("No");
        aNo.setBounds(550,540,80,30);
        aNo.setBackground(Color.WHITE);
        add(aYes);
        add(aNo);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(aYes);
        accountGroup.add(aNo);



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
//        String formNo = "" + random;  //long value
        String religion = (String) religionList.getSelectedItem();
        String category = (String) categoryList.getSelectedItem();

        String income = (String) incomeList.getSelectedItem();
        String citizen = null;
       if(cYes.isSelected()){
            citizen = "Yes";
        }
        else if(cNo.isSelected()){
            citizen = "No";
        }
        String education = (String) educationList.getSelectedItem();
        String occupation =(String) occupationList.getSelectedItem();
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        String account = null;
        if(aYes.isSelected())
        {
            account = "Yes";
        }
        else if(aNo.isSelected())
        {
            account = "No";
        }


        try{
            assert religion != null;
            if(religion.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else if(category.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Category Name is Required");
            }
            else if(income.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Income is Required");
            }
            else if(education.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Education is Required");
            }
            else if(occupation.isEmpty())

            {
                JOptionPane.showMessageDialog(null, "Occupation Required if Not write NA");
            }
            else if(pan.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Pan Number is Required");
            }
            else if(aadhar.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Aadhaar Number is Required");
            }
            else if(citizen.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Select Senior Citizen");
            }
            else if(account.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please select you have already account or not");
            }


            Conn c = new Conn();
            //writting my sequel query
            String query = "insert into signuptwo values('" + formNo + "', '" + religion + "', '" + category + "', '" + income + "'," +
                    " '" + education + "', '" + occupation + "', '" + pan + "', '" + aadhar + "', '"
                    + citizen + "', '" +account +"')";
            c.s.executeUpdate(query);
            //signup 3 object
            setVisible(false);
            new SignUpThree(formNo).setVisible(true);
            //create object for sign up 3
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
