package Aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JMenu mnInicio;
	private JMenu mnVer;
	private JMenu mnFunciones;
	private JMenuItem mntmLogin;
	private JMenuItem mntmLogout;
	private JMenuItem mntmExit;
	private Login login;
	private JMenuItem mntmBorrar;
	private JMenuItem mntmActualizar;
	private JMenuItem mntmInsertar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(login != null)
					if(login.conexion()){
						mnFunciones.setEnabled(true);
						mntmInsertar.setEnabled(false);
						mntmBorrar.setEnabled(false);
						mntmActualizar.setEnabled(false);
					}
			}
		});
		setTitle("Organiza tus clases");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnInicio = new JMenu("Inicio");

		mnInicio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(login != null){
					if(login.conexion() == true){
						mntmLogin.setEnabled(false);
						mntmLogout.setEnabled(true);
					}
				}
			}
		});

		menuBar.add(mnInicio);
		
		mntmLogin = new JMenuItem("Login");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login = new Login();
				login.setVisible(true);
			}
		});
		mnInicio.add(mntmLogin);
		
		mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login = null;
				mntmLogin.setEnabled(true);
				mntmLogout.setEnabled(false);
				mnFunciones.setEnabled(false);
			}
		});
		mnInicio.add(mntmLogout);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(-1);
			}
		});
		mnInicio.add(mntmExit);
		
		mnVer = new JMenu("Ver");
		menuBar.add(mnVer);
		
		mnFunciones = new JMenu("Funciones");
		mnFunciones.setEnabled(false);
		menuBar.add(mnFunciones);
		
		mntmInsertar = new JMenuItem("Insertar");
		mnFunciones.add(mntmInsertar);
		
		mntmActualizar = new JMenuItem("Actualizar");
		mnFunciones.add(mntmActualizar);
		
		mntmBorrar = new JMenuItem("Borrar");
		mnFunciones.add(mntmBorrar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		if(login != null){
			if(login.conexion())
				mnFunciones.setEnabled(true);
		}
		else
			mntmLogout.setEnabled(false);
	}

	public JMenu getMnInicio() {
		return mnInicio;
	}
	public JMenu getMnVer() {
		return mnVer;
	}
	public JMenu getMnFunciones() {
		return mnFunciones;
	}
	public JMenuItem getMntmLogin() {
		return mntmLogin;
	}
	public JMenuItem getMntmLogout() {
		return mntmLogout;
	}
	public JMenuItem getMntmExit() {
		return mntmExit;
	}
	public JMenuItem getMntmBorrar() {
		return mntmBorrar;
	}
	public JMenuItem getMntmActualizar() {
		return mntmActualizar;
	}
	public JMenuItem getMntmInsertar() {
		return mntmInsertar;
	}
}
