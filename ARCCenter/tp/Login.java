package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;

import com.mdlConnection;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;


public class Login {

	public JFrame frmLogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	static Login window=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window= new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(new Color(0, 153, 255));
		
		frmLogin.setBounds(100, 100, 505, 240);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(10, 24, 469, 107);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 15));
		lblUserName.setBounds(69, 33, 126, 14);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 15));
		lblPassword.setBounds(69, 65, 126, 14);
		panel.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 15));
		txtUsername.setBounds(205, 29, 193, 22);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 15));
		txtPassword.setBounds(205, 62, 193, 20);
		panel.add(txtPassword);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setBounds(20, 34, 6, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setBounds(20, 66, 6, 14);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(10, 142, 469, 35);
		frmLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				if(mdlConnection.validateLogin(txtUsername.getText(), txtPassword.getText())==1)
				{
							String orignal_pass=mdlConnection.generateRandomPassword();
							System.out.println("password is: "+orignal_pass);
							//new mdlConnection().sendEmail("2 Step Verification Password.", "Your 2 step verification password is: "+orignal_pass, txtUsername.getText());
							String pass=JOptionPane.showInputDialog("Enter 2 step Verification password.");
							if(orignal_pass.equals(pass))
							{
								JOptionPane.showMessageDialog(null, "Login Successfull..", "Information", JOptionPane.INFORMATION_MESSAGE);
								new MDI().frmFileSecure.setVisible(true);
								window.frmLogin.dispose();
							}
							else
							{
								txtUsername.setText("");
								txtPassword.setText("");
								JOptionPane.showMessageDialog(null, "Your 2 step verification password is invalid", "Information", JOptionPane.INFORMATION_MESSAGE);
							}
							
				}
				else
				{
					txtUsername.setText("");
					txtPassword.setText("");
					JOptionPane.showMessageDialog(null, "username and password invalid", "Information", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnLogin.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 15));
		btnLogin.setBounds(73, 7, 89, 23);
		panel_1.add(btnLogin);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLogin.dispose();
			}
		});
		btnCancel.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 15));
		btnCancel.setBounds(271, 7, 102, 23);
		panel_1.add(btnCancel);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 19));
		lblLogin.setBounds(197, 0, 80, 21);
		frmLogin.getContentPane().add(lblLogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new sign_up().frmSignUp.setVisible(true);
			}
		});
		btnSignUp.setBounds(188, 183, 89, 14);
		frmLogin.getContentPane().add(btnSignUp);
		btnSignUp.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 10));
	}
}
