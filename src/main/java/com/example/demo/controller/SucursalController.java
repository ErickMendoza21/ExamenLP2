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
import com.example.demo.entity.SucursalEntity;
import com.example.demo.serviceImpl.ClienteServiceImpl;
import com.example.demo.serviceImpl.SucursalServiceImpl;

import static com.example.demo.commons.GlobalConstans.API_SUCURSAL;

import java.util.List;
import java.util.Optional;;

@RestController
@RequestMapping(API_SUCURSAL)
public class SucursalController {

	@Autowired
	private SucursalServiceImpl sucursalServiceImpl;
	
	@GetMapping("/all")
	public List<SucursalEntity> listar() {
		return sucursalServiceImpl.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<SucursalEntity> getAutorById(@PathVariable("id") Long id){
		Optional<SucursalEntity> sucursal = sucursalServiceImpl.read(id);
	    if (sucursal.isPresent()) {
	      return new ResponseEntity<SucursalEntity>(sucursal.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@PostMapping("/add")
	public ResponseEntity<SucursalEntity> createAlumno(@Validated @RequestBody SucursalEntity s) {
		try {
			SucursalEntity sucursal = sucursalServiceImpl.create(s);
			return new ResponseEntity<>(sucursal, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<SucursalEntity> updateBus(@PathVariable("id") long id, @Validated @RequestBody SucursalEntity s) {
		Optional<SucursalEntity> suc = sucursalServiceImpl.read(id);

		if (suc.isPresent()) {
			SucursalEntity sucursal = suc.get();
			sucursal.setDireccion(s.getDireccion());
			sucursal.setLocalidad(s.getLocalidad());
			sucursal.setProvincia(s.getProvincia());
			sucursal.setTelefono(s.getTelefono());
			return new ResponseEntity<SucursalEntity>(sucursalServiceImpl.update(sucursal), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<SucursalEntity> delete(@PathVariable("id") Long id){
		try {
			sucursalServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
}