package com.edu.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import java.awt.Dimension;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class FrmArchivo extends JPanel implements ActionListener {
	private JPanel panel;
	private JButton menuAlumno;
	private JButton MenuCarrera;
	private JButton MenuCiclos;
	private JButton MenuPeriodos;
	private JButton MenuAsignaturas;
	private JPanel panelContAlumnos;
	private JButton MenuDocentes;
	

	/**
	 * Create the panel.
	 */
	public FrmArchivo() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 871, 40);
		panel.setBackground(new Color(255, 255, 255));
		panel.setPreferredSize(new Dimension(10, 40));
		add(panel);
		
		menuAlumno = new JButton("ALUMNOS");
		menuAlumno.setBounds(0, 0, 145, 41);
		menuAlumno.addActionListener(this);
		panel.setLayout(null);
		menuAlumno.setFocusable(false);
		menuAlumno.setIcon(new ImageIcon(FrmArchivo.class.getResource("/images_proyect/student.png")));
		menuAlumno.setFont(new Font("Roboto", Font.BOLD, 13));
		menuAlumno.setForeground(new Color(255, 255, 255));
		menuAlumno.setBackground(new Color(0, 0, 0));
		menuAlumno.setBorder(null);
		panel.add(menuAlumno);
		
		MenuCarrera = new JButton("CARRERAS");
		MenuCarrera.setIcon(new ImageIcon(FrmArchivo.class.getResource("/images_proyect/carreras.png")));
		MenuCarrera.addActionListener(this);
		MenuCarrera.setBounds(145, 0, 145, 41);
		MenuCarrera.setFocusable(false);
		MenuCarrera.setFont(new Font("Roboto", Font.BOLD, 13));
		MenuCarrera.setForeground(new Color(255, 255, 255));
		MenuCarrera.setBackground(new Color(0, 0, 0));
		MenuCarrera.setBorder(null);
		panel.add(MenuCarrera);
		
		MenuCiclos = new JButton("CICLOS");
		MenuCiclos.setIcon(new ImageIcon(FrmArchivo.class.getResource("/images_proyect/ciclos.png")));
		MenuCiclos.addActionListener(this);
		MenuCiclos.setBounds(290, 0, 145, 41);
		MenuCiclos.setFocusable(false);
		MenuCiclos.setFont(new Font("Roboto", Font.BOLD, 13));
		MenuCiclos.setForeground(new Color(255, 255, 255));
		MenuCiclos.setBackground(new Color(0, 0, 0));
		MenuCiclos.setBorder(null);
		panel.add(MenuCiclos);
		
		MenuPeriodos = new JButton("PERIODOS");
		MenuPeriodos.addActionListener(this);
		MenuPeriodos.setIcon(new ImageIcon(FrmArchivo.class.getResource("/images_proyect/fechas.png")));
		MenuPeriodos.setBounds(435, 0, 145, 41);
		MenuPeriodos.setFocusable(false);
		MenuPeriodos.setFont(new Font("Roboto", Font.BOLD, 13));
		MenuPeriodos.setForeground(new Color(255, 255, 255));
		MenuPeriodos.setBackground(new Color(0, 0, 0));
		MenuPeriodos.setBorder(null);
		panel.add(MenuPeriodos);
		
		MenuDocentes = new JButton("DOCENTES");
		MenuDocentes.addActionListener(this);
		MenuDocentes.setIcon(new ImageIcon(FrmArchivo.class.getResource("/images_proyect/teacher.png")));
		MenuDocentes.setForeground(Color.WHITE);
		MenuDocentes.setFont(new Font("Roboto", Font.BOLD, 13));
		MenuDocentes.setFocusable(false);
		MenuDocentes.setBorder(null);
		MenuDocentes.setBackground(Color.BLACK);
		MenuDocentes.setBounds(580, 0, 145, 41);
		panel.add(MenuDocentes);
		
		MenuAsignaturas = new JButton("ASIGNATURAS");
		MenuAsignaturas.addActionListener(this);
		MenuAsignaturas.setBounds(725, 0, 145, 41);
		panel.add(MenuAsignaturas);
		MenuAsignaturas.setFocusable(false);
		MenuAsignaturas.setIcon(new ImageIcon(FrmArchivo.class.getResource("/images_proyect/online-course.png")));
		MenuAsignaturas.setFont(new Font("Roboto", Font.BOLD, 13));
		MenuAsignaturas.setForeground(new Color(255, 255, 255));
		MenuAsignaturas.setBackground(new Color(0, 0, 0));
		MenuAsignaturas.setBorder(null);
		
		panelContAlumnos = new JPanel() {
			private Image imagen;

			{
				imagen = new ImageIcon(getClass().getResource("/images_proyect/logoCibertec.jpg")).getImage();
			}
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelContAlumnos.setBounds(0, 40, 871, 536);
		add(panelContAlumnos);
		
		

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuAsignaturas) {
			actionPerformedMenuAsignaturas(e);
		}
		if (e.getSource() == MenuDocentes) {
			actionPerformedMenuDocentes(e);
		}
		if (e.getSource() == MenuPeriodos) {
			actionPerformedMenuPeriodos(e);
		}
		if (e.getSource() == MenuCiclos) {
			actionPerformedMenuCiclos(e);
		}
		if (e.getSource() == MenuCarrera) {
			actionPerformedMenuCarrera(e);
		}
		if (e.getSource() == menuAlumno) {
			actionPerformedMenuAlumno(e);
		}
	}
	protected void actionPerformedMenuAlumno(ActionEvent e) {
		MenuAlumnos ma = new MenuAlumnos();
		ma.setLocationRelativeTo(this);
		ma.setVisible(true);
		
	}
	protected void actionPerformedMenuCarrera(ActionEvent e) {
		MenuCarreras mc = new MenuCarreras();
		mc.setLocationRelativeTo(this);
		mc.setVisible(true);
		
	}
	protected void actionPerformedMenuCiclos(ActionEvent e) {
		MenuCiclos mci = new MenuCiclos();
		mci.setLocationRelativeTo(this);
		mci.setVisible(true);
	}
	protected void actionPerformedMenuPeriodos(ActionEvent e) {
		MenuPeriodos mp = new MenuPeriodos();
		mp.setLocationRelativeTo(this);
		mp.setVisible(true);
		
	}
	protected void actionPerformedMenuDocentes(ActionEvent e) {
		MenuDocentes md = new MenuDocentes();
		md.setLocationRelativeTo(this);
		md.setVisible(true);
	}
	protected void actionPerformedMenuAsignaturas(ActionEvent e) {
		MenuAsignaturas mas = new MenuAsignaturas();
		mas.setLocationRelativeTo(this);
		mas.setVisible(true);
	}
}
