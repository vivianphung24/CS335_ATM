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

public class Window2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;
	private Map<String, String> users = new HashMap<>();
    private Set<String> existingUsernames = new HashSet<>();
    private Properties props = new Properties();
    private File ufile = new File("src/designGUI/account.properties");
    private String usern;
    private String pass;
    private int account;
    
    
    public Window2(String usern, String pass, int account) {
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
	public Window2() {
		
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
		
		JLabel Username = new JLabel("Username");
		Username.setBounds(431, 149, 165, 16);
		Username.setForeground(new Color(255, 158, 232));
		contentPane.add(Username);
		
		userField = new JTextField();
		userField.setBounds(431, 177, 212, 26);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(431, 228, 142, 16);
		lblNewLabel.setForeground(new Color(255, 158, 232));
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(431, 256, 212, 26);
		contentPane.add(passwordField);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.setBounds(483, 311, 117, 29);
		LoginButton.setForeground(new Color(255, 158, 232));
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(LoginButton);
		
		LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Registration successful.");
                dispose();
                new Menu1().setVisible(true);
            }
        });
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to Baddie Banking");
		lblNewLabel_2.setBounds(414, 48, 314, 31);
		lblNewLabel_2.setFont(new Font("Krungthep", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(255, 158, 232));
		contentPane.add(lblNewLabel_2);
	}
}
