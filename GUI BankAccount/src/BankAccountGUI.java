import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BankAccountGUI extends JFrame
{
	public BankAccountGUI()
	{
	
		ArrayList <BankAccount>accounts=new ArrayList<BankAccount>();
		
		setTitle("BankAccount");
		setBounds(100,100,600,400);
		setLayout(null);
		
		JLabel name=new JLabel("Name: ");
		name.setBounds(20,20,100,30);
		add(name);
		
		JTextField nameText = new JTextField();
		nameText.setBounds(80,20,200,30);
		add(nameText);
		
		JLabel typeLabel=new JLabel("Account Type: ");
		typeLabel.setBounds(20,60,100,30);
		add(typeLabel);
		
		String[] options = { "", "Checking", "Savings"};
		JComboBox optionBox = new JComboBox(options);
		optionBox.setBounds(120,60,100,30);
		add(optionBox);
	
		
		JLabel balanceLabel=new JLabel("Initial Balance: ");
		balanceLabel.setBounds(20,100,100,30);
		add(balanceLabel);
		
		JTextField balanceText = new JTextField("");
		balanceText.setBounds(120,100,200,30);
		add(balanceText);
		
	
		
		JButton button1 = new JButton("Create Account");
		button1.setBounds(20,140,200,30);
		add(button1);
		button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				String selected = (String)optionBox.getSelectedItem();
				if(selected.equals("Checking"))
				{
					String nameForAccount = nameText.getText();
					String balance = balanceText.getText();
					accounts.add(new CheckingAccount(nameForAccount,Double.parseDouble(balance),0,0,0));
				}
				
				else if(selected.equals("Savings"))
				{
					String nameForAccount = nameText.getText();
					String balance = balanceText.getText();
					accounts.add(new SavingsAccount(nameForAccount,Double.parseDouble(balance),0,0,0));
				}
			}
		});
		
		JButton button2 = new JButton("Display All Accounts");
		button2.setBounds(250,140,200,30);
		add(button2);
		button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e);
			{
				int yPos = 180;
				for (BankAccount x:accounts)
				{
					
					JLabel display=new JLabel(accounts.getName(), accounts.getBalance());
					display.setBounds(20,yPos,100,30);
					add(display);
					yPos=yPos+50;
				}
			}
			
		});
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[]args)
	{
		new BankAccountGUI();
	}
}



