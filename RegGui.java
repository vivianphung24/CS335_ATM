package banking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegistrationDemo extends JFrame implements ActionListener {
   JPanel panel;
   JLabel logo_label, user_label, password_label, confirm_label, message;
   JTextField userName_text;
   JPasswordField password_text, confirm_text;
   JButton submit, cancel;
   
   RegistrationDemo() {
      // Logo Label
      logo_label = new JLabel();
      ImageIcon logo = new ImageIcon("/Users/maleehahafricawala/Desktop/BBLogo.png"); // Replace "logo.png" with the path to your logo image
      logo_label.setIcon(logo);
     
      
      // Username Label
      user_label = new JLabel();
      user_label.setText("Create Username:");
      user_label.setForeground(Color.PINK);
      userName_text = new JTextField();
      
      // Password Label
      password_label = new JLabel();
      password_label.setText("Create Password:");
      password_label.setForeground(Color.PINK);
      password_text = new JPasswordField();
      
      // Confirm Password Label
      confirm_label = new JLabel();
      confirm_label.setText("Confirm Password:");
      confirm_label.setForeground(Color.PINK);
      confirm_text = new JPasswordField();
      
      // Submit
      JButton submit = new JButton("SUBMIT");
      submit.setBackground(Color.PINK);
      submit.setForeground(Color.BLACK);
  
      
      panel = new JPanel(new GridLayout(10, 1));
      panel.setBackground(Color.BLACK);
      panel.add(logo_label);
      panel.add(user_label);
      panel.add(userName_text);
      panel.add(password_label);
      panel.add(password_text);
      panel.add(confirm_label);
      panel.add(confirm_text);
      
      message = new JLabel();
      message.setForeground(Color.PINK);
      panel.add(message);
      panel.add(submit);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Adding the listeners to components
      submit.addActionListener(this);
      
      add(panel, BorderLayout.CENTER);
      setTitle("Registration Page");
      setSize(300, 300);
      setVisible(true);
   }
   
   public static void main(String[] args) {
      new RegistrationDemo();
   }
   
   @Override
   public void actionPerformed(ActionEvent ae) {
      String userName = userName_text.getText();
      String password = password_text.getText();
      String confirm = confirm_text.getText();
      
      if (password.equals(confirm)) {
         message.setText("Registration Successful!");
      } else {
         message.setText("Passwords do not match.");
      }
   }
}
