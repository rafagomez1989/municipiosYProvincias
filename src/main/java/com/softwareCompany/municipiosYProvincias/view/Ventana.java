package com.softwareCompany.municipiosYProvincias.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.kohsuke.rngom.util.Localizer;

import com.softwareCompany.municipiosYProvincias.controller.MunicipioController;
import com.softwareCompany.municipiosYProvincias.controller.ProvinciaController;
import com.softwareCompany.municipiosYProvincias.model.Municipio;
import com.softwareCompany.municipiosYProvincias.model.Provincia;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField jtfFiltrar;
	private JTextField jtfNombre;
	private JComboBox<Municipio> jcbSeleccionar;
	private JComboBox<Provincia> jcbProvincia;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 30, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		jtfFiltrar = new JTextField();
		GridBagConstraints gbc_jtfFiltrar = new GridBagConstraints();
		gbc_jtfFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFiltrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFiltrar.gridx = 0;
		gbc_jtfFiltrar.gridy = 0;
		contentPane.add(jtfFiltrar, gbc_jtfFiltrar);
		jtfFiltrar.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMunicipiosEnJCombo();
			}
		});
		btnFiltrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnFiltrar.gridx = 1;
		gbc_btnFiltrar.gridy = 0;
		contentPane.add(btnFiltrar, gbc_btnFiltrar);
		
		jcbSeleccionar = new JComboBox();
		GridBagConstraints gbc_jcbSeleccionar = new GridBagConstraints();
		gbc_jcbSeleccionar.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSeleccionar.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSeleccionar.gridx = 0;
		gbc_jcbSeleccionar.gridy = 1;
		contentPane.add(jcbSeleccionar, gbc_jcbSeleccionar);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarMunicipios();
			}
		});
		btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnSeleccionar = new GridBagConstraints();
		gbc_btnSeleccionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSeleccionar.gridx = 1;
		gbc_btnSeleccionar.gridy = 1;
		contentPane.add(btnSeleccionar, gbc_btnSeleccionar);
		
		JLabel lblNewLabel = new JLabel("Municipio Seleccionado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 41, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del municipio:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 0;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Provincia del municipio:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 1;
		panel.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		jcbProvincia = new JComboBox();
		GridBagConstraints gbc_jcbProvincia = new GridBagConstraints();
		gbc_jcbProvincia.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProvincia.gridx = 1;
		gbc_jcbProvincia.gridy = 1;
		panel.add(jcbProvincia, gbc_jcbProvincia);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificacion();
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 2;
		panel.add(btnGuardar, gbc_btnGuardar);
		
		cargarProvinciasEnJCombo();
	}
	
//	/**
//	 * 
//	 */
//	private void cargarMunicipiosEnJCombo() {	
//		String str = this.jtfFiltrar.getText();
//		
//		this.jcbSeleccionar.removeAllItems();
//		List<Municipio> list = MunicipioController.findByLikeDescripcion(str);
//		for (Municipio m : list) {
//			this.jcbSeleccionar.addItem(m);
//		}
//	}
	
	/**
	 * 
	 */
	private void cargarMunicipiosEnJCombo() {			
		this.jcbSeleccionar.removeAllItems();
		for (Municipio m : MunicipioController.findByLikeDescripcion(this.jtfFiltrar.getText())) {
			this.jcbSeleccionar.addItem(m);
		}
	}
	
	
	
	/**
	 * 
	 */
	private void mostrarMunicipios( ) {
		Municipio m = (Municipio) jcbSeleccionar.getSelectedItem();
		this.jtfNombre.setText(m.getNombre());
		this.jcbProvincia.setSelectedItem(m.getProvincia());
		
	}
	
	/**
	 * 
	 */
	private void cargarProvinciasEnJCombo() {
		List<Provincia> list = ProvinciaController.findAll();
		for (Provincia p : list) {
			this.jcbProvincia.addItem(p);
		}
	}
	
	/**
	 * 
	 */
	private void modificacion() {		
		Municipio m = (Municipio)(this.jcbSeleccionar.getSelectedItem());
		Provincia p = (Provincia)(this.jcbProvincia.getSelectedItem());
		m.setNombre(this.jtfNombre.getText());
		m.setProvincia(p);
		MunicipioController.modificar(m);
	}
	
}
