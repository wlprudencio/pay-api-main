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

import com.escola.pay.dtos.AlunoPDTO;
import com.escola.pay.dtos.AlunoRDTO;
import com.escola.pay.dtos.AlunoUDTO;
import com.escola.pay.exception.handler.ApiErrorResponse;
import com.escola.pay.service.AlunoService;
import com.escola.pay.utils.Response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AlunoController {

	private final AlunoService service;

	@Operation(summary = "Cadastrar Aluno", responses = {
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Operação concluída com Sucesso.", useReturnTypeSchema = true),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Requisição Inválida.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class))) }),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Erro interno ao realizar operação.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class))) }), })
	@PostMapping
	public ResponseEntity<Response<AlunoRDTO>> create(@RequestBody @Valid AlunoPDTO alunoPDTO) {
		Response<AlunoRDTO> response = new Response<>();
		AlunoRDTO alunoRDTO = this.service.create(alunoPDTO);
		response.setData(alunoRDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Operation(summary = "Busca Aluno Pelo ID", responses = {
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operação concluída com Sucesso.", useReturnTypeSchema = true),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Requisição Inválida.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class))) }),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Erro interno ao realizar operação.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class))) }), })

	@GetMapping("/{id}")
	public ResponseEntity<Response<AlunoRDTO>> findById(@PathVariable Long id) {
		Response<AlunoRDTO> response = new Response<>();
		AlunoRDTO alunoRDTO = this.service.findById(id);
		response.setData(alunoRDTO);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@Operation(summary = "Busca Todos os Aluno", responses = {
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operação concluída com Sucesso.", useReturnTypeSchema = true),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Requisição Inválida.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class))) }),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Erro interno ao realizar operação.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class))) }), })
	@GetMapping
	public ResponseEntity<Response<List<AlunoRDTO>>> findAll() {
		Response<List<AlunoRDTO>> response = new Response<>();
		List<AlunoRDTO> rdtos = this.service.findAll();
		response.setData(rdtos);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@Operation(summary = "Atualizar Dados do Aluno", responses = {
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operação concluída com Sucesso.", useReturnTypeSchema = true),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Requisição Inválida.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class))) }),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Erro interno ao realizar operação.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class))) }), })
	@PutMapping
	public ResponseEntity<Response<AlunoRDTO>> update(@RequestBody AlunoUDTO alunoUDTO) {
		Response<AlunoRDTO> response = new Response<>();
		AlunoRDTO rdto = this.service.update(alunoUDTO);
		response.setData(rdto);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@Operation(summary = "Deletar Aluno Pelo ID", responses = {
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operação concluída com Sucesso.", useReturnTypeSchema = true),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Requisição Inválida.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class))) }),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Erro interno ao realizar operação.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ApiErrorResponse.class))) }), })
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<Void>> delete(@PathVariable Long id) {
		Response<Void> response = new Response<>();
		this.service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
