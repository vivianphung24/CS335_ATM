package designGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class DepositGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositGUI frame = new DepositGUI();
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
	public DepositGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 778);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(241, 195, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter A Deposit Amount");
		lblNewLabel.setBounds(432, 190, 236, 37);
		lblNewLabel.setFont(new Font("Krungthep", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("$");
		lblNewLabel_1.setFont(new Font("Krungthep", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(402, 245, 18, 51);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(432, 239, 236, 57);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton cancelButton = new JButton("Go Back");
		cancelButton.setBounds(400, 308, 137, 62);
		cancelButton.setOpaque(true);
		cancelButton.setBackground(Color.BLACK);
		contentPane.add(cancelButton);
		
		cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu1().setVisible(true);
            }
        });
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(564, 308, 137, 62);
		btnSubmit.setOpaque(true);
		btnSubmit.setBackground(Color.pink);
		contentPane.add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Deposit successful. New balance: ");
                dispose();
                new Menu1().setVisible(true);
            }
        });
	}
}
