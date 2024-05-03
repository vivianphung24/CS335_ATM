package designGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class Window1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;
	private JPasswordField confirmField;
	private Map<String, String> users = new HashMap<>();
    private Set<String> existingUsernames = new HashSet<>();
    private Properties props = new Properties();
    private File ufile = new File("src/designGUI/account.properties");
    private String usern;
    private String pass;
    private int account;
    
    
    public Window1(String usern, String pass, int account) {
        this.usern = usern;
        this.pass = pass;
        this.account = account;
       
    }
   
    
    // user methods to be accessed by ATM file
    private static User user;
    public static void setUser(User newUser) {
    	user=newUser;
    }
    public static User getUser() {
    	return(user);
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window1 frame = new Window1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window1() {
		
		// Load existing usernames from account.properties file
        try (InputStream fileIn = new FileInputStream(ufile)) {
            props.load(fileIn);
            existingUsernames.addAll(props.stringPropertyNames());
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // load all existing users from properties file into users map
        try (InputStream fileIn = new FileInputStream(ufile)) {
            props.load(fileIn);
            for (String uname : props.stringPropertyNames()) {
                String pw = props.getProperty(uname);
                users.put(uname, pw);
            }
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 606);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Username = new JLabel("Create Username");
		Username.setBounds(431, 149, 165, 16);
		Username.setForeground(new Color(255, 158, 232));
		contentPane.add(Username);
		
		userField = new JTextField();
		userField.setBounds(431, 177, 212, 26);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Create Password");
		lblNewLabel.setBounds(431, 228, 142, 16);
		lblNewLabel.setForeground(new Color(255, 158, 232));
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(431, 256, 212, 26);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Confirm Password");
		lblNewLabel_1.setBounds(431, 311, 142, 16);
		lblNewLabel_1.setForeground(new Color(255, 158, 232));
		contentPane.add(lblNewLabel_1);
		
		confirmField = new JPasswordField();
		confirmField.setBounds(431, 339, 212, 26);
		contentPane.add(confirmField);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(483, 399, 117, 29);
		registerButton.setForeground(new Color(255, 158, 232));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(registerButton);
		
		registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmField.getPassword());

                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required.");
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match.");
                    return;
                }

                if (existingUsernames.contains(username)) {
                    JOptionPane.showMessageDialog(null, "Username already exists.");
                    return;
                }

                users.put(username, password);

                try (OutputStream fileOut = new FileOutputStream(ufile)) {
                    props.store(fileOut, null);
                    fileOut.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Registration successful.");
                dispose();
                new Window1();
            }
        });
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to Baddie Banking");
		lblNewLabel_2.setBounds(421, 81, 314, 31);
		lblNewLabel_2.setFont(new Font("Krungthep", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(255, 158, 232));
		contentPane.add(lblNewLabel_2);
		
		JButton existButton = new JButton("Existing User");
		existButton.setBounds(483, 430, 117, 29);
		existButton.setBackground(new Color(0, 0, 0));
		existButton.setForeground(new Color(255, 114, 178));
		contentPane.add(existButton);
		
		existButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // Close the current window
				new Window2().setVisible(true); // Open Window2
			}
			
		
	});
	}
}
