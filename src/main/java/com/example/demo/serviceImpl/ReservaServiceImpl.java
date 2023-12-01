package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ReservaEntity;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.service.Operaciones;

@Service
public class ReservaServiceImpl implements Operaciones<ReservaEntity>{

	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public ReservaEntity create(ReservaEntity t) {
		// TODO Auto-generated method stub
		return reservaRepository.save(t);
	}

	@Override
	public ReservaEntity update(ReservaEntity t) {
		// TODO Auto-generated method stub
		return reservaRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		reservaRepository.deleteById(id);
	}

	@Override
	public Optional<ReservaEntity> read(Long id) {
		// TODO Auto-generated method stub
		return reservaRepository.findById(id);
	}

	@Override
	public List<ReservaEntity> readAll() {
		// TODO Auto-generated method stub
		return reservaRepository.findAll();
	}
	
	
	
}
