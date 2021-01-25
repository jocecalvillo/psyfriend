package com.psyfriend.springboot.backend.apirest.models.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psyfriend.springboot.backend.apirest.models.entity.Paciente;
import com.psyfriend.springboot.backend.apirest.models.service.IPacienteService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PacienteRestController {

	@Autowired
	private IPacienteService pacienteService;

	@GetMapping("/pacientes")
	public List<Paciente> index() {
		return pacienteService.findAll();
	}

	@GetMapping("/pacientes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Paciente paciente = null;
		Map<String, Object> response = new HashMap<>();

		try {
			paciente = pacienteService.findById(id);
		} catch (DataAccessException e) {

			response.put("mensaje:", "Error al realizar la consulta en la base de datos");
			response.put("error:", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (paciente == null) {
			response.put("mensaje:", "El paciente ID: ".concat(id.toString().concat(" no existe en la DB! ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
	}

	@PostMapping("/pacientes")
	public ResponseEntity<?> create(@Valid @RequestBody Paciente paciente, BindingResult result) {

		Paciente pacienteNuevo = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			/*
			 * List<String>errors=new ArrayList<>();
			 * 
			 * for(FieldError err: result.getFieldErrors()) {
			 * errors.add("El campo '"+err.getField() +"' "+ err.getDefaultMessage() ); }
			 */

			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El campo '" + err.getField() + "' " + err.getDefaultMessage();
			}).collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			pacienteNuevo = pacienteService.save(paciente);
		} catch (DataAccessException e) {
			response.put("mensaje:", "Error al realizar un insert  en la base de datos");
			response.put("error:", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El paciente ha sido creado con exito!");
		response.put("cliente", pacienteNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		// return new ResponseEntity<Paciente>(pacienteNuevo, HttpStatus.CREATED);
	}

	@PutMapping("/pacientes/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Paciente paciente, BindingResult result, @PathVariable Long id) {

		Paciente pacienteActual = pacienteService.findById(id);
		Paciente pacienteUpdate = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El campo '" + err.getField() + "' " + err.getDefaultMessage();
			}).collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (pacienteActual == null) {
			response.put("mensaje:", "Error: no se puede editar, el paciente ID: "
					.concat(id.toString().concat(" no existe en la DB! ")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			pacienteActual.setApellido(paciente.getApellido());
			pacienteActual.setNombre(paciente.getNombre());
			pacienteActual.setEmail(paciente.getEmail());
			pacienteActual.setCreateAt(new Date());

			pacienteUpdate = pacienteService.save(pacienteActual);

		} catch (DataAccessException e) {
			response.put("mensaje:", "Error al actualizar el cliente  en la base de datos");
			response.put("error:", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El paciente ha sido actualizado con exito!");
		response.put("cliente", pacienteUpdate);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		// return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/pacientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		try {
			pacienteService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje:", "Error al eliminar el cliente  en la base de datos");
			response.put("error:", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El paciente ha sido eliminado con exito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
