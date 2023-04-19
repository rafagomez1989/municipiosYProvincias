package com.softwareCompany.municipiosYProvincias.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.softwareCompany.municipiosYProvincias.model.Municipio;
import com.softwareCompany.municipiosYProvincias.model.Provincia;

public class MunicipioController {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("municipiosyprovincias");

	/**
	 * 
	 * @param descripcion
	 * @return
	 */
	public static List<Municipio> findByLikeDescripcion (String descripcion) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM municipio where lower(nombre) like ?", Municipio.class);
		q.setParameter(1, "%" + descripcion.toLowerCase() + "%");	
		List<Municipio> list = (List<Municipio>) q.getResultList();
		
		em.close();
		return list;
	}
	
	
	/**
	 * 
	 */
	public static void modificar (Municipio m) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		em.close();
	}
}
