package com.soluva.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.soluva.dao.ClienteDAO;
import com.soluva.model.Cliente;

@ManagedBean (name="clienteBean")
@RequestScoped
@SessionScoped
public class ClienteBean {

	public List<Cliente> getClientes(){
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.readClientes();
	}
	public String nuevo() {
		Cliente c= new Cliente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return  "/faces/nuevo.xhtml";
	}
	
	public String save (Cliente cliente) {
		//guarda la fecha de registro
		Date fechaActual= new Date();
		cliente.setCreatedAt(new java.sql.Date(fechaActual.getTime()));
		
		ClienteDAO clienteDAO= new ClienteDAO();
		clienteDAO.create(cliente);
		return  "/faces/index.xhtml";
	}

	public String edit(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente();
		c = clienteDAO.search(id);
		System.out.println("******************************************");
		System.out.println(c);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/faces/editar.xhtml";
	}

	public String update(Cliente cliente) {
		//guarda la fecha de actualizacion
		Date fechaActual= new Date();
		cliente.setUpdatedAt(new java.sql.Date(fechaActual.getTime()));
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.edit(cliente);
		return "/faces/index.xhtml";
	}

	// eliminar un cliente
	public String delete(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.delete(id);
		System.out.println("Cliente eliminado..");
		return "/faces/index.xhtml";
	}
}
