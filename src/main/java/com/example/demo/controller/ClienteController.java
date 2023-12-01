package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ClienteEntity;
import com.example.demo.serviceImpl.ClienteServiceImpl;



import static com.example.demo.commons.GlobalConstans.API_CLIENTE;

import java.util.List;
import java.util.Optional;;

@RestController
@RequestMapping(API_CLIENTE)
public class ClienteController {

	@Autowired
	private ClienteServiceImpl clienteServiceImpl;
	
	@GetMapping("/all")
	public List<ClienteEntity> listar() {
		return clienteServiceImpl.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteEntity> getAutorById(@PathVariable("id") Long id){
		Optional<ClienteEntity> cliente = clienteServiceImpl.read(id);
	    if (cliente.isPresent()) {
	      return new ResponseEntity<ClienteEntity>(cliente.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@PostMapping("/add")
	public ResponseEntity<ClienteEntity> createAlumno(@Validated @RequestBody ClienteEntity c) {
		try {
			ClienteEntity cliente = clienteServiceImpl .create(c);
			return new ResponseEntity<>(cliente, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<ClienteEntity> updateBus(@PathVariable("id") long id, @Validated @RequestBody ClienteEntity c) {
		Optional<ClienteEntity> clie = clienteServiceImpl.read(id);

		if (clie.isPresent()) {
			ClienteEntity cliente = clie.get();
			cliente.setApellidos(c.getApellidos());
			cliente.setNif(c.getNif());
			cliente.setNombres(c.getNombres());
			cliente.setTelefono(c.getTelefono());
			cliente.setEmail(c.getEmail());
			return new ResponseEntity<ClienteEntity>(clienteServiceImpl.update(cliente), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteEntity> delete(@PathVariable("id") Long id){
		try {
			clienteServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
}