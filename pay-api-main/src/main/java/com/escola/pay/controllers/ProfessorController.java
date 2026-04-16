package com.escola.pay.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.pay.dtos.ProfessorPDTO;
import com.escola.pay.dtos.ProfessorRDTO;
import com.escola.pay.dtos.ProfessorUDTO;
import com.escola.pay.exception.handler.ApiErrorResponse;
import com.escola.pay.service.ProfessorService;
import com.escola.pay.utils.Response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProfessorController {

	private ProfessorService service;
	
	@Operation(summary = "Cadastrar Professor", responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description =
            "Operação concluída com Sucesso.", useReturnTypeSchema = true), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode =
            "400", description = "Requisição Inválida.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
    @Schema(implementation = ApiErrorResponse.class)))}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description =
            "Erro interno ao realizar operação.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
    @Schema(implementation = ApiErrorResponse.class)))}),})
	@PostMapping
	public ResponseEntity<Response<ProfessorRDTO>> create(@RequestBody @Valid ProfessorPDTO professorPDTO) {
		Response<ProfessorRDTO> response = new Response<>();
		ProfessorRDTO professorRDTO = this.service.create(professorPDTO);
		response.setData(professorRDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@Operation(summary = "Busca Professor Pelo ID", responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description =
            "Operação concluída com Sucesso.", useReturnTypeSchema = true), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode =
            "400", description = "Requisição Inválida.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
    @Schema(implementation = ApiErrorResponse.class)))}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description =
            "Erro interno ao realizar operação.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
    @Schema(implementation = ApiErrorResponse.class)))}),})
	@GetMapping("/{id}")
	public ResponseEntity<Response<ProfessorRDTO>> findById(@PathVariable Long id) {
		Response<ProfessorRDTO> response = new Response<>();
		ProfessorRDTO alunoRDTO = this.service.findById(id);
		response.setData(alunoRDTO);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@Operation(summary = "Busca Todos os Professor", responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description =
            "Operação concluída com Sucesso.", useReturnTypeSchema = true), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode =
            "400", description = "Requisição Inválida.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
    @Schema(implementation = ApiErrorResponse.class)))}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description =
            "Erro interno ao realizar operação.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
    @Schema(implementation = ApiErrorResponse.class)))}),})
	@GetMapping
	public ResponseEntity<Response<List<ProfessorRDTO>>> findAll() {
		Response<List<ProfessorRDTO>> response = new Response<>();
		List<ProfessorRDTO> rdtos = this.service.findAll();
		response.setData(rdtos);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}
	
	@Operation(summary = "Deletar Professor Pelo ID", responses = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description =
            "Operação concluída com Sucesso.", useReturnTypeSchema = true), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode =
            "400", description = "Requisição Inválida.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
    @Schema(implementation = ApiErrorResponse.class)))}), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description =
            "Erro interno ao realizar operação.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema =
    @Schema(implementation = ApiErrorResponse.class)))}),})
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<Void>> delete(@PathVariable Long id) {
		Response<Void> response = new Response<>();
		this.service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	
	@PutMapping
	public ResponseEntity<Response<ProfessorRDTO>> update(@RequestBody ProfessorUDTO professorUDTO) {
		Response<ProfessorRDTO> response = new Response<>();
		ProfessorRDTO rdto = this.service.update(professorUDTO);
		response.setData(rdto);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

}
