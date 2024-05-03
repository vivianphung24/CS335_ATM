package designGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Menu1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu1 frame = new Menu1();
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
	public Menu1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 767);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 251, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton balance = new JButton("Check Balance");
		balance.setBounds(187, 79, 283, 161);
		balance.setForeground(new Color(255, 158, 232));
		contentPane.add(balance);
		
		balance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new BalanceGUI().setVisible(true);
            }
        });
		
		JButton withdraw = new JButton("Withdraw");
		withdraw.setBounds(187, 289, 283, 161);
		withdraw.setForeground(new Color(255, 158, 232));
		contentPane.add(withdraw);
		
		withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new WithdrawGUI().setVisible(true);
            }
        });
		
		JButton deposit = new JButton("Deposit");
		deposit.setBounds(533, 79, 283, 161);
		contentPane.add(deposit);
		
		deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DepositGUI().setVisible(true);
            }
        });
		
		JButton transfer = new JButton("Transfer");
		transfer.setBounds(533, 289, 283, 161);
		contentPane.add(transfer);
		
		deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TransferGUI().setVisible(true);
            }
        });
		
		JButton history = new JButton("View Transaction History");
		history.setBounds(187, 513, 283, 161);
		history.setForeground(new Color(255, 158, 232));
		contentPane.add(history);
		
		JButton quit = new JButton("Quit");
		quit.setBounds(533, 513, 283, 161);
		contentPane.add(quit);
		
		JLabel MenuLabel = new JLabel("What Would You Like To Do Today?");
		MenuLabel.setFont(new Font("Krungthep", Font.PLAIN, 18));
		MenuLabel.setBounds(375, 19, 361, 48);
		contentPane.add(MenuLabel);
	}
}
