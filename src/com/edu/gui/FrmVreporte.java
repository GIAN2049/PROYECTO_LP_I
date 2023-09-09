package com.edu.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class FrmVreporte extends JFrame {

	private JPanel contentPane;
	public static JPanel panelReportes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVreporte frame = new FrmVreporte();
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
	public FrmVreporte() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelReportes = new JPanel();
		contentPane.add(panelReportes);
		panelReportes.setLayout(new GridLayout(1, 0, 0, 0));
	}
	
	
	  public void mostrarReporte(JasperPrint print) {
	        JRViewer viewer = new JRViewer(print);
	        viewer.setOpaque(true);
	        viewer.setVisible(true);

	        panelReportes.removeAll();
	        panelReportes.setLayout(new BorderLayout());
	        panelReportes.add(viewer, BorderLayout.CENTER);
	        panelReportes.revalidate();
	        panelReportes.repaint();
	    }

}
