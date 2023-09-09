package com.edu.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import com.edu.controlador.MySqlPeridoDAO;
import com.edu.entidad.Alumno;
import com.edu.entidad.Periodo;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class MenuPeriodos extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JDateChooser txtFecInicio;
	private JLabel lblFechaDeFin;
	private JDateChooser txtFecFin;
	private JScrollPane scrollPane;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JLabel lblNewLabel_1;
	private JTextField txtCodigo;

	private MySqlPeridoDAO peridoDAO = new MySqlPeridoDAO();
	private JTable tablePeriodo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPeriodos frame = new MenuPeriodos();
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
	public MenuPeriodos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 635, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("FECHA DE INICIO");
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 13));
		lblNewLabel.setBounds(39, 50, 115, 14);
		contentPane.add(lblNewLabel);

		txtFecInicio = new JDateChooser();
		txtFecInicio.setBounds(153, 47, 105, 22);
		contentPane.add(txtFecInicio);

		lblFechaDeFin = new JLabel("FECHA DE FIN");
		lblFechaDeFin.setFont(new Font("Roboto", Font.PLAIN, 13));
		lblFechaDeFin.setBounds(39, 80, 115, 14);
		contentPane.add(lblFechaDeFin);

		txtFecFin = new JDateChooser();
		txtFecFin.setBounds(153, 75, 105, 22);
		contentPane.add(txtFecFin);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 121, 530, 197);
		contentPane.add(scrollPane);

		tablePeriodo = new JTable();
		tablePeriodo.addMouseListener(this);
		tablePeriodo.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "CODIGO", "FECHA DE INICIO", "FECHA DE FIN" }));
		scrollPane.setViewportView(tablePeriodo);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setIconTextGap(20);
		btnRegistrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistrar.setIcon(new ImageIcon(MenuPeriodos.class.getResource("/images_proyect/guardar.png")));
		btnRegistrar.setBorder(new MatteBorder(1, 20, 1, 1, (Color) null));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setBackground(new Color(0, 0, 0));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(129, 344, 159, 41);
		contentPane.add(btnRegistrar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIconTextGap(20);
		btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminar.setIcon(new ImageIcon(MenuPeriodos.class.getResource("/images_proyect/delete2.png")));
		btnEliminar.setBorder(new MatteBorder(1, 20, 1, 1, (Color) null));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(0, 0, 0));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(314, 344, 159, 41);
		contentPane.add(btnEliminar);

		btnNuevo = new JButton("NUEVO");
		btnNuevo.setForeground(new Color(255, 255, 255));
		btnNuevo.setBorder(new MatteBorder(1, 15, 1, 1, (Color) null));
		btnNuevo.setFocusable(false);
		btnNuevo.setBackground(new Color(0, 0, 0));
		btnNuevo.setHorizontalAlignment(SwingConstants.LEFT);
		btnNuevo.setIconTextGap(25);
		btnNuevo.setIcon(new ImageIcon(MenuPeriodos.class.getResource("/images_proyect/nuevo.png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(410, 19, 159, 41);
		contentPane.add(btnNuevo);

		lblNewLabel_1 = new JLabel("CODIGO");
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(39, 20, 115, 14);
		contentPane.add(lblNewLabel_1);

		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(153, 17, 105, 22);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		listado();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		String codigo = String.valueOf(peridoDAO.obtenerCodigo());
		txtCodigo.setText(codigo);

	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		String codigo, fecInicio, fecFin;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		codigo = txtCodigo.getText();
		fecInicio = sdf.format(txtFecInicio.getDate());
		fecFin = sdf.format(txtFecFin.getDate());

		Periodo bean = new Periodo();
		bean.setCodigo(Integer.parseInt(codigo));
		bean.setFechaInicio(fecInicio);
		bean.setFechaFin(fecFin);

		int salida = peridoDAO.registrar(bean);

		if (salida > 0) {
			mensaje("PERIODO REGISTRADO CORRECTAMENTE");
			listado();
			clean();
		} else {
			mensaje("ERROR AL REGISTRAR PERIODO");
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int cod, boton;

		cod = Integer.parseInt(txtCodigo.getText());

		boton = JOptionPane.showConfirmDialog(this, "Sistema", "¿Seguro de eliminar?", JOptionPane.YES_NO_OPTION);

		if (boton == 0) {
			int salida;
			Periodo bean = new Periodo();
			bean.setCodigo(cod);
			salida = peridoDAO.eliminar(cod);

			if (salida == 1) {
				mensaje("PERIODO ELIMINADO");
				listado();
				clean();
			} else {
				mensaje("ERROR AL ELIMINAR PERIODO");
			}
		}

	}

	void listado() {
		ArrayList<Periodo> datos = peridoDAO.listAll();
		DefaultTableModel modeloPeriodo = (DefaultTableModel) tablePeriodo.getModel();

		modeloPeriodo.setRowCount(0);

		for (Periodo bean : datos) {
			Object row[] = { bean.getCodigo(), bean.getFechaInicio(), bean.getFechaFin() };
			modeloPeriodo.addRow(row);
		}
	}

	void clean() {
		txtCodigo.setText("");
		txtFecInicio.setDate(null);
		txtFecFin.setDate(null);
	}

	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tablePeriodo) {
			mouseClickedTablePeriodo(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedTablePeriodo(MouseEvent e) {
		SimpleDateFormat sdf = new SimpleDateFormat("d MMM. yyyy");

		String codigo, fecInicio, fecFin;
		int pos;

		pos = tablePeriodo.getSelectedRow();

		codigo = tablePeriodo.getValueAt(pos, 0).toString();
		fecInicio = tablePeriodo.getValueAt(pos, 1).toString();
		fecFin = tablePeriodo.getValueAt(pos, 2).toString();

		try {
			Date fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse(fecInicio);
			Date fechaFin = new SimpleDateFormat("yyyy-MM-dd").parse(fecFin);

			String fechaFormI = sdf.format(fechaInicio);
			String fechaFormF = sdf.format(fechaFin);

			txtCodigo.setText(codigo);
			txtFecInicio.setDate(fechaInicio);
			txtFecFin.setDate(fechaFin);

			txtFecInicio.setDateFormatString(fechaFormI);
			txtFecFin.setDateFormatString(fechaFormF);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

	}
}
