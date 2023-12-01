package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.HotelEntity;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.Operaciones;

@Service
public class HotelServiceImpl implements Operaciones<HotelEntity>{

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public HotelEntity create(HotelEntity t) {
		// TODO Auto-generated method stub
		return hotelRepository.save(t);
	}

	@Override
	public HotelEntity update(HotelEntity t) {
		// TODO Auto-generated method stub
		return hotelRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		hotelRepository.deleteById(id);
	}

	@Override
	public Optional<HotelEntity> read(Long id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id);
	}

	@Override
	public List<HotelEntity> readAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}
	
}
