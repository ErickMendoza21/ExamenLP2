package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ClienteEntity;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.Operaciones;

@Service
public class ClienteServiceImpl implements Operaciones<ClienteEntity>{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public ClienteEntity create(ClienteEntity t) {
		// TODO Auto-generated method stub
		return clienteRepository.save(t);
	}

	@Override
	public ClienteEntity update(ClienteEntity t) {
		// TODO Auto-generated method stub
		return clienteRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

	@Override
	public Optional<ClienteEntity> read(Long id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	public List<ClienteEntity> readAll() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

}
