package com.psyfriend.springboot.backend.apirest.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psyfriend.springboot.backend.apirest.models.dao.IPaciente;
import com.psyfriend.springboot.backend.apirest.models.entity.Paciente;
import com.psyfriend.springboot.backend.apirest.models.service.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService{

	
	
	@Autowired
	private IPaciente pacienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Paciente> findAll() {
		return (List<Paciente>) pacienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Paciente findById(Long id) {
		return pacienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Paciente save(Paciente paciente) {
		return pacienteDao.save(paciente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		pacienteDao.deleteById(id);
		
	}

}
