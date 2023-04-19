package com.softwareCompany.municipiosYProvincias.test;

import com.softwareCompany.municipiosYProvincias.controller.MunicipioController;
import com.softwareCompany.municipiosYProvincias.controller.ProvinciaController;
import com.softwareCompany.municipiosYProvincias.model.Municipio;
import com.softwareCompany.municipiosYProvincias.model.Provincia;


public class Principal {

	/**
	 * 
	 */
	public static void mostrarTodasLasProvincias() {
		//Sacar una lista de los elementos que contengan el texto indicado
		System.out.println("Lista:\n");
		for (Provincia p: ProvinciaController.findAll()) {
			System.out.println("Provincia: " + p.getProvincia());
		}
	}

	/**
	 * 
	 */
	public static void obtenerListaConLike() {
		//Sacar una lista de los elementos que contengan el texto indicado
		System.out.println("Lista:\n");
		for (Municipio m: MunicipioController.findByLikeDescripcion("A")) {
			System.out.println("Municipio: " + m.getNombre());
		}
	}
	
	
	
	public static void main(String[] args) {

//		mostrarTodasLasProvincias();
		obtenerListaConLike();
		
	}

}
