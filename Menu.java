package ATM;

import javax.swing.*;  

import java.awt.*;  
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
	
	Menu() {
	
		JLabel title = new JLabel("Welcome to Baddie Banking! What would you like to do today?", SwingConstants.CENTER);
		//frame.getContentPane().add(title,BorderLayout)
	
		JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
	
		// add buttons
		JButton btnCheckBalance = new JButton("Check Balance");
		JButton btnWithdraw = new JButton("Withdraw");
		JButton btnDeposit = new JButton("Deposit");
		JButton btnTransfer = new JButton("Transfer");
		JButton btnViewTransactions = new JButton("View Transactions History");
		JButton btnQuit = new JButton("Quit");
		
		// action listeners
        btnCheckBalance.addActionListener(this);
        btnWithdraw.addActionListener(this);
        btnDeposit.addActionListener(this);
        btnTransfer.addActionListener(this);
        btnViewTransactions.addActionListener(this);
        btnQuit.addActionListener(this);
		
		panel.add(btnCheckBalance);
		panel.add(btnWithdraw);
		panel.add(btnDeposit);
		panel.add(btnTransfer);
		panel.add(btnViewTransactions);
		panel.add(btnQuit);
		
		add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
		setVisible(true);	
	}

	@Override    
	public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        switch (command) {
            case "Check Balance":
                // Implement action for Check Balance button
                break;
            case "Withdraw":
                // Implement action for Withdraw button
                break;
            case "Deposit":
                // Implement action for Deposit button
                break;
            case "Transfer":
                // Implement action for Transfer button
                break;
            case "View Transactions History":
                // Implement action for View Transactions History button
                break;
            case "Quit":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid action");
        }
    }
	
	public static void main(String[] args) {
		Menu menuscreen = new Menu();
	}
}
