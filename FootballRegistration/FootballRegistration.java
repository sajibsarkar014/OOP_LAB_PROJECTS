import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileWriter;
import java.io.IOException;

public class FootballRegistration {

    public FootballRegistration(){
        JFrame frame = new JFrame();
        frame.setSize(600,950);
        frame.setLayout(null);
        frame.setBackground(Color.GREEN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //title
        JLabel titleLabel = new JLabel("IITDU FOOTBALL TEAM REGISTRATION");
        titleLabel.setBounds(50,20,500,50);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD , 25));
        frame.add(titleLabel);

        //name
        JLabel nameLabel = new JLabel("• Name: ");
        nameLabel.setBounds(60,90,300,25);
        nameLabel.setFont(new Font("Segoe UI",Font.BOLD,14));

        JTextField nameField = new JTextField();
        nameField.setBounds(60,120,300,30);

        frame.add(nameLabel);
        frame.add(nameField);

        //gmail
        JLabel mailLabel = new JLabel("• Email Address: ");
        mailLabel.setBounds(60,170,300,25);
        mailLabel.setFont(new Font("Segoe UI",Font.BOLD,14));

        JTextField mailField = new JTextField();
        mailField.setBounds(60,200,300,30);

        frame.add(mailField);
        frame.add(mailLabel);

        //number
        JLabel phoneLabel = new JLabel("• Contact No: ");
        phoneLabel.setBounds(60,250,300,25);
        phoneLabel.setFont(new Font("Segoe UI",Font.BOLD,14));

        JTextField phoneField = new JTextField();
        phoneField.setBounds(60,280,300,30);

        frame.add(phoneField);
        frame.add(phoneLabel);

        //address
        JLabel addressLabel = new JLabel("• Current Address: ");
        addressLabel.setBounds(60,330,300,25);
        addressLabel.setFont(new Font("Segoe UI",Font.BOLD,14));

        JTextField addressField = new JTextField();
        addressField.setBounds(60,360,300,30);

        frame.add(addressLabel);
        frame.add(addressField);

        //gender
        JLabel genderLabel = new JLabel("• Gender: ");
        genderLabel.setBounds(60,410,300,25);
        genderLabel.setFont(new Font("Segoe UI",Font.BOLD,14));

        //male
        JRadioButton maleButton = new JRadioButton("Male");
        maleButton.setBounds(125,410,70,25);
        //feamle
        JRadioButton femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(200,410,90,25);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        frame.add(maleButton);
        frame.add(femaleButton);
        frame.add(genderLabel);

        //posiition
        JLabel positionLabel = new JLabel("• Select your preferred position: ");
        positionLabel.setBounds(60,450,300,25);
        positionLabel.setFont(new Font("Segoe UI",Font.BOLD,14));
        frame.add(positionLabel);

        String[] positionNames ={
                "Pick Your Position",
                "Centre Forward",
                "Left Winger",
                "Right Winger",
                "Attacking Midfielder",
                "Central Midfielder",
                "Right Midfielder",
                "Left Midfielder",
                "Defensive Midfielder",
                "Left Back",
                "Right Back",
                "Centre Back",
                "Goalkeeper"
        };

        JComboBox <String> positionBox = new JComboBox<>(positionNames);
        positionBox.setBounds(60,480,250,30);
        frame.add(positionBox);

        // Degree
        JLabel degreeLabel = new JLabel("• Choose your current degree: ");
        degreeLabel.setFont(new Font("Segoe UI",Font.BOLD,14));
        degreeLabel.setBounds(60,530,250,25);

        JRadioButton bsseDegree = new JRadioButton("BSSE");
        JRadioButton msseDegree = new JRadioButton("MSSE");
        JRadioButton mitDegree = new JRadioButton("MIT");

        bsseDegree.setBounds(60,560,80,25);
        msseDegree.setBounds(160,560,80,25);
        mitDegree.setBounds(260,560,80,25);

        ButtonGroup degreeGroup = new ButtonGroup();
        degreeGroup.add(bsseDegree);
        degreeGroup.add(msseDegree);
        degreeGroup.add(mitDegree);

        frame.add(bsseDegree);
        frame.add(msseDegree);
        frame.add(mitDegree);
        frame.add(degreeLabel);

        // partitcipation
        JLabel prevLabel = new JLabel("• Did you participate previously? :");
        prevLabel.setFont(new Font("Segoe UI",Font.BOLD,14));
        prevLabel.setBounds(60,590,250,25);
        frame.add(prevLabel);

        JRadioButton yes = new JRadioButton("Yes");
        JRadioButton no = new JRadioButton("No");
        yes.setBounds(65,620,50,25);
        no.setBounds(115,620,50,25);
        ButtonGroup prevPar = new ButtonGroup();
        prevPar.add(yes);
        prevPar.add(no);
        frame.add(yes);
        frame.add(no);

        // Date of birth
        JLabel dobLabel = new JLabel("• Date of Birth:");
        dobLabel.setFont(new Font("Segoe UI",Font.BOLD,14));
        dobLabel.setBounds(60,650,250,25);
        frame.add(dobLabel);

        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        String[] days = new String[31];
        String[] years = new String[50];
        for(int i = 0; i < 50; i++){
            years[i] = String.valueOf(2025 - i);
        }
        for(int i = 1; i <= 31; i++){
            days[i-1] = String.valueOf(i);
        }

        // date of birth
        JComboBox<String> dayBox = new JComboBox<>(days);
        dayBox.setBounds(60,680,60,30);
        JComboBox<String> monthBox = new JComboBox<>(months);
        monthBox.setBounds(130,680,100,30);
        JComboBox<String> yearBox = new JComboBox<>(years);
        yearBox.setBounds(240,680,70,30);

        frame.add(dayBox);
        frame.add(monthBox);
        frame.add(yearBox);

        // experience
        JLabel experienceLabel = new JLabel("• Do you have any previous experience? ");
        experienceLabel.setBounds(60,730,300,25);
        experienceLabel.setFont(new Font("Segoe UI",Font.BOLD,14));

        JTextField experienceField = new JTextField();
        experienceField.setBounds(60,760,300,30);

        frame.add(experienceLabel);
        frame.add(experienceField);

        // button
        JButton registerButton = new JButton("REGISTER");
        registerButton.setBounds(250,795,100,30);
        registerButton.setFont(new Font("Arial",Font.PLAIN,12));
        registerButton.setHorizontalAlignment(SwingConstants.CENTER);

        // action listener
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter your name!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (mailField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter your email!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (phoneField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter your phone number!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (addressField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter your address!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!maleButton.isSelected() && !femaleButton.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Please select your gender!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (positionBox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(frame, "Please select your position!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!bsseDegree.isSelected() && !msseDegree.isSelected() && !mitDegree.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Please select your degree!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!yes.isSelected() && !no.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Please select if you participated previously!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (experienceField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter your experience!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // try to handle exception
                try {
                    String name = nameField.getText().trim();
                    String email = mailField.getText().trim();
                    String phone = phoneField.getText().trim();
                    String address = addressField.getText().trim();
                    String gender = maleButton.isSelected() ? "Male" : "Female";
                    String position = (String) positionBox.getSelectedItem();
                    String degree = bsseDegree.isSelected() ? "BSSE" : (msseDegree.isSelected() ? "MSSE" : "MIT");
                    String previousParticipation = yes.isSelected() ? "Yes" : "No";
                    String day = (String) dayBox.getSelectedItem();
                    String month = (String) monthBox.getSelectedItem();
                    String year = (String) yearBox.getSelectedItem();
                    String experience = experienceField.getText().trim();

                    // Create data string
                    String data = "    FOOTBALL TEAM REGISTRATION    \n" +
                            "Name: " + name + "\n" +
                            "Email: " + email + "\n" +
                            "Phone: " + phone + "\n" +
                            "Address: " + address + "\n" +
                            "Gender: " + gender + "\n" +
                            "Position: " + position + "\n" +
                            "Degree: " + degree + "\n" +
                            "Previous Participation: " + previousParticipation + "\n" +
                            "Date of Birth: " + day + " " + month + " " + year + "\n" +
                            "Experience: " + experience + "\n" +
                            "Registration Date: " + new java.util.Date() + "\n" +
                            " \n\n\n\n\n";

                    FileWriter fileWriter = new FileWriter("data.txt", true);
                    fileWriter.write(data);
                    fileWriter.close();

                    JOptionPane.showMessageDialog(frame, "Registration data saved to data.txt successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    //clear
                    nameField.setText("");
                    mailField.setText("");
                    phoneField.setText("");
                    addressField.setText("");
                    genderGroup.clearSelection();
                    positionBox.setSelectedIndex(0);
                    degreeGroup.clearSelection();
                    prevPar.clearSelection();
                    dayBox.setSelectedIndex(0);
                    monthBox.setSelectedIndex(0);
                    yearBox.setSelectedIndex(0);
                    experienceField.setText("");

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(registerButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FootballRegistration();
    }
}