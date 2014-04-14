package Aplicacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtUser;
	private static Connection conection;
	
	private Boolean loginCorecto = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 349, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(159, 68, 159, 27);
		contentPane.add(txtPassword);
		
		txtUser = new JTextField();
		txtUser.setBounds(159, 20, 159, 27);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(29, 23, 120, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Constrase\u00F1a:");
		lblPassword.setBounds(29, 71, 120, 20);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/imagenes/OK.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginCorecto = false;
				try{
					Class.forName("com.mysql.jdbc.Driver");
					conection = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "");
					JOptionPane.showMessageDialog(contentPane, "Conexión realizada con éxito.");
					JOptionPane.showMessageDialog(contentPane, "Conectando...");
					
					String password = new String(txtPassword.getPassword());
					String consulta2 = "select * from clientes where Usuario='"
							+ txtUser.getText() + "' AND Password='" + password + "'";
					
					try {
						Statement consulta = conection.createStatement();
						ResultSet resultado = consulta.executeQuery(consulta2);
						
						if(resultado.next()){
							JOptionPane.showMessageDialog(contentPane, "¡Correcto!");
							loginCorecto = true;
							dispose();
						}
						else
							JOptionPane.showMessageDialog(contentPane, "Datos incorrectos", "Login incorrecto", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(contentPane, e1.getMessage());
					}
				}
				catch(ClassNotFoundException e1){
					JOptionPane.showMessageDialog(contentPane, e1.getMessage());
				}
				catch(SQLException e1){
					JOptionPane.showMessageDialog(contentPane, e1.getMessage());
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(contentPane, e1.getMessage());
				}
			}
		});
		btnLogin.setBounds(30, 125, 125, 30);
		contentPane.add(btnLogin);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(Login.class.getResource("/imagenes/Close.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(180, 125, 125, 30);
		contentPane.add(btnCancelar);
	}

	public Boolean conexion() {
		if(loginCorecto)
			return true;
		else
			return false;
	}
}
