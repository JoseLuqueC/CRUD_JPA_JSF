package com.soluva.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.soluva.model.Cliente;
import com.soluva.model.JPAUtil;

public class ClienteDAO {

	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	// Guardar nuevo cliente JPA
	public void create(Cliente cliente) {
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
		JPAUtil.shutdown();
	}

	// Buscar cliente JPA
	public Cliente search(Long id) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, id);
		JPAUtil.shutdown();
		return c;
	}

	// Editar cliente JPA
	public void edit(Cliente cliente) {
		entity.getTransaction().begin();
		entity.merge(cliente);
		entity.getTransaction().commit();
		JPAUtil.shutdown();
	}

	// Leer clientes JPA
	public List<Cliente> readClientes() {
		List<Cliente> listaClientes = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Cliente c");
		listaClientes = q.getResultList();
		return listaClientes;
	}
	
	/// Eliminar cliente
		public void delete(Long id) {
			Cliente c = new Cliente();
			c = entity.find(Cliente.class, id);
			entity.getTransaction().begin();
			entity.remove(c);
			entity.getTransaction().commit();
		}
}
