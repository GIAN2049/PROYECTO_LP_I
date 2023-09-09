package com.edu.gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.edu.controlador.MySqlMatriculaDAO;
import com.edu.entidad.Matricula;
import com.edu.utils.GenerarReporte;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

/*
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;*/

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmReportes extends JFrame implements ActionListener {

	
	private MySqlMatriculaDAO matriculaDAO = new MySqlMatriculaDAO();
	ArrayList<Matricula> datos;
	
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable tableReportes;
	private JButton btnReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReportes frame = new FrmReportes();
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
	public FrmReportes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 838, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 822, 498);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Estudiantes Matriculados", null, panel, null);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 797, 371);
		panel.add(scrollPane);
		
		tableReportes = new JTable();
		tableReportes.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null, null},
			},
			new String[] {
				"DNI", "NOMBRE", "CARRERA", "CICLO", "PERIODO"
			}
		));
		scrollPane.setViewportView(tableReportes);
		
		btnReporte = new JButton("GENERAR REPORTE");
		btnReporte.addActionListener(this);
		btnReporte.setIcon(new ImageIcon(FrmReportes.class.getResource("/images_proyect/printer.png")));
		btnReporte.setBounds(258, 394, 283, 65);
		panel.add(btnReporte);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		listarTabla();
	}
	
	
	
	void listarTabla() {
		
		datos = matriculaDAO.listAll();

		DefaultTableModel modeloMatriculas = (DefaultTableModel) tableReportes.getModel();
	
		modeloMatriculas.setRowCount(0);
		
		for (Matricula bean : datos) {
			Object row[] = {bean.getDNI(), bean.getNombreAlumno(), bean.getNombreCarrera(),
					bean.getNombreCiclo(), bean.getFechaInicio(), bean.getFechaFin()};
			modeloMatriculas.addRow(row);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent e) {
		
		FrmVreporte frmVreporte = new FrmVreporte();
		String name;
		name = "reporteAlumnosMatriculados.jasper";
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(datos);
		
		JasperPrint jasper = GenerarReporte.genera(name, dataSource, null);
		JRViewer viewer = new JRViewer(jasper);
		
		frmVreporte.panelReportes.add(viewer);
        frmVreporte.setVisible(true);
	}
}
