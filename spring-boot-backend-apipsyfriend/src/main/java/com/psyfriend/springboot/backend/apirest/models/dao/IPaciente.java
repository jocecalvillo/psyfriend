package com.psyfriend.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.psyfriend.springboot.backend.apirest.models.entity.Paciente;

public interface IPaciente extends CrudRepository<Paciente, Long> {

}
