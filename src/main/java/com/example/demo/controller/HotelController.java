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
import com.example.demo.entity.HotelEntity;
import com.example.demo.entity.SucursalEntity;
import com.example.demo.serviceImpl.ClienteServiceImpl;
import com.example.demo.serviceImpl.HotelServiceImpl;
import com.example.demo.serviceImpl.SucursalServiceImpl;

import static com.example.demo.commons.GlobalConstans.API_HOTEL;

import java.util.List;
import java.util.Optional;;

@RestController
@RequestMapping(API_HOTEL)
public class HotelController {

	@Autowired
	private HotelServiceImpl hotelServiceImpl;

	@GetMapping("/all")
	public List<HotelEntity> listar() {
		return hotelServiceImpl.readAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<HotelEntity> getAutorById(@PathVariable("id") Long id) {
		Optional<HotelEntity> hotel = hotelServiceImpl.read(id);
		if (hotel.isPresent()) {
			return new ResponseEntity<HotelEntity>(hotel.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<HotelEntity> createAlumno(@Validated @RequestBody HotelEntity ho) {
		try {
			HotelEntity hotel = hotelServiceImpl.create(ho);
			return new ResponseEntity<>(hotel, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<HotelEntity> updateBus(@PathVariable("id") long id, @Validated @RequestBody HotelEntity ho) {
		Optional<HotelEntity> hote = hotelServiceImpl.read(id);

		if (hote.isPresent()) {
			HotelEntity hotel = hote.get();
			hotel.setNombres(ho.getNombres());
			hotel.setDireccion(ho.getDireccion());
			hotel.setLocalidad(ho.getLocalidad());
			hotel.setProvincia(ho.getProvincia());
			hotel.setTelefono(ho.getTelefono());
			hotel.setNumero_estrellas(ho.getNumero_estrellas());
			return new ResponseEntity<HotelEntity>(hotelServiceImpl.update(hotel), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HotelEntity> delete(@PathVariable("id") Long id) {
		try {
			hotelServiceImpl.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}