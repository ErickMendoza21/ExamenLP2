package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SucursalEntity;
import com.example.demo.repository.SucursalRepository;
import com.example.demo.service.Operaciones;

@Service
public class SucursalServiceImpl implements Operaciones<SucursalEntity>{

	@Autowired
	private SucursalRepository sucursalRepository;

	@Override
	public SucursalEntity create(SucursalEntity t) {
		// TODO Auto-generated method stub
		return sucursalRepository.save(t);
	}

	@Override
	public SucursalEntity update(SucursalEntity t) {
		// TODO Auto-generated method stub
		return sucursalRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		sucursalRepository.deleteById(id);
	}

	@Override
	public Optional<SucursalEntity> read(Long id) {
		// TODO Auto-generated method stub
		return sucursalRepository.findById(id);
	}

	@Override
	public List<SucursalEntity> readAll() {
		// TODO Auto-generated method stub
		return sucursalRepository.findAll();
	}
	
	
}
