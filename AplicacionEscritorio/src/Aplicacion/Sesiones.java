package Aplicacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sesiones extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sesiones frame = new Sesiones();
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
	public Sesiones() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDa = new JLabel("D\u00EDa");
		lblDa.setBounds(93, 29, 46, 14);
		contentPane.add(lblDa);
		
		JLabel lblNHoras = new JLabel("N\u00BA horas");
		lblNHoras.setBounds(160, 29, 61, 14);
		contentPane.add(lblNHoras);
		
		JLabel lblEvaluacion = new JLabel("Evaluacion");
		lblEvaluacion.setBounds(10, 29, 73, 14);
		contentPane.add(lblEvaluacion);
		
		JLabel lblTareas = new JLabel("Tareas");
		lblTareas.setBounds(289, 29, 46, 14);
		contentPane.add(lblTareas);
		
		table = new JTable();
		table.setBounds(160, 144, 186, 129);
		contentPane.add(table);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(231, 29, 46, 14);
		contentPane.add(lblTipo);
		
		textField = new JTextField();
		textField.setBounds(10, 60, 39, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(89, 60, 39, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(160, 60, 46, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(216, 60, 51, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Aplicar");
		btnNewButton.setIcon(new ImageIcon(Sesiones.class.getResource("/imagenes/OK.png")));
		btnNewButton.setBounds(467, 204, 123, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Sesiones.class.getResource("/imagenes/Close.png")));
		btnNewButton_1.setBounds(467, 250, 123, 23);
		contentPane.add(btnNewButton_1);
	}
}

