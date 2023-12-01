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

import com.example.demo.entity.VueloEntity;
import com.example.demo.serviceImpl.VueloServiceImpl;

import static com.example.demo.commons.GlobalConstans.API_VUELO;

import java.util.List;
import java.util.Optional;;

@RestController
@RequestMapping(API_VUELO)
public class VueloController {

	@Autowired
	private VueloServiceImpl vueloServiceImpl;

	@GetMapping("/all")
	public List<VueloEntity> listar() {
		return vueloServiceImpl.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<VueloEntity> getAutorById(@PathVariable("id") Long id) {
		Optional<VueloEntity> vuelo = vueloServiceImpl.read(id);
		if (vuelo.isPresent()) {
			return new ResponseEntity<VueloEntity>(vuelo.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<VueloEntity> createAlumno(@Validated @RequestBody VueloEntity v) {
		try {
			VueloEntity vuelo = vueloServiceImpl.create(v);
			return new ResponseEntity<>(vuelo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<VueloEntity> updateBus(@PathVariable("id") long id, @Validated @RequestBody VueloEntity v) {
		Optional<VueloEntity> vue = vueloServiceImpl.read(id);

		if (vue.isPresent()) {
			VueloEntity vuelo = vue.get();
			vuelo.setDestino(v.getDestino());
			vuelo.setFecha_llegada(v.getFecha_llegada());
			vuelo.setFecha_salida(v.getFecha_salida());
			vuelo.setHora_llegada(v.getHora_llegada());
			vuelo.setHora_salida(v.getHora_salida());
			vuelo.setNumero_plazas_totales(v.getNumero_plazas_totales());
			vuelo.setOrigen(v.getOrigen());
			return new ResponseEntity<VueloEntity>(vueloServiceImpl.update(vuelo), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<VueloEntity> delete(@PathVariable("id") Long id) {
		try {
			vueloServiceImpl.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}