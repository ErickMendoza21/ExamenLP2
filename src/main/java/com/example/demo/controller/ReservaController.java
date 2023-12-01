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

import com.example.demo.entity.ReservaEntity;
import com.example.demo.serviceImpl.ReservaServiceImpl;

import static com.example.demo.commons.GlobalConstans.API_RESERVA;

import java.util.List;
import java.util.Optional;;

@RestController
@RequestMapping(API_RESERVA)
public class ReservaController {

	@Autowired
	private ReservaServiceImpl reservaServiceImpl;
	
	@GetMapping("/all")
	public List<ReservaEntity> listar() {
		return reservaServiceImpl.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ReservaEntity> getAutorById(@PathVariable("id") Long id){
		Optional<ReservaEntity> vuelo = reservaServiceImpl.read(id);
	    if (vuelo.isPresent()) {
	      return new ResponseEntity<ReservaEntity>(vuelo.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@PostMapping("/add")
	public ResponseEntity<ReservaEntity> createAlumno(@Validated @RequestBody ReservaEntity v) {
		try {
			ReservaEntity cliente = reservaServiceImpl .create(v);
			return new ResponseEntity<>(cliente, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<ReservaEntity> updateBus(@PathVariable("id") long id, @Validated @RequestBody ReservaEntity r) {
		Optional<ReservaEntity> res = reservaServiceImpl.read(id);

		if (res.isPresent()) {
			ReservaEntity reserva = res.get();
			reserva.setClase(r.getClase());
			reserva.setVuelo(r.getVuelo());
			reserva.setCliente(r.getCliente());
			reserva.setHotel(r.getHotel());
			reserva.setSucursal(r.getSucursal());
			return new ResponseEntity<ReservaEntity>(reservaServiceImpl.update(reserva), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ReservaEntity> delete(@PathVariable("id") Long id){
		try {
			reservaServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
}