package com.example.demo.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClientDto;
import com.example.demo.entity.Client;
import com.example.demo.exceptionHandler.ApiResponse;
import com.example.demo.service.ClientService;
import com.example.demo.service.impl.ClientServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/clients")
	public ResponseEntity<Collection <ClientDto>> fetchAllClient(){
		List<ClientDto> fetchAllClients = clientService.fetchAllClients();
		System.out.println(fetchAllClients);
		return ResponseEntity.ok(fetchAllClients);
	}
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<ClientDto> fetchClient(@PathVariable Integer id){
		return ResponseEntity.ok(clientService.fetchClient(id));
	}
	
	@PostMapping("/clients")
	public ResponseEntity<ClientDto> createClient(@Valid @RequestBody ClientDto client){
		ClientDto c=clientService.createClient(client);
		return ResponseEntity.ok(c);
	}
	
	@PutMapping("/clients/{id}")
	public ResponseEntity<ClientDto> updateClient( @RequestBody ClientDto client, @PathVariable Integer id){
		ClientDto c=clientService.updateClient(client, id);
		return ResponseEntity.status(201).body(c);
	}
	
	@DeleteMapping("/clients/{id}")
	public ResponseEntity<ApiResponse> deleteClient(@PathVariable Integer id){
		ApiResponse a=new ApiResponse("Deletion Successful", true);
		clientService.deleteClient(id);
		return ResponseEntity.status(204).body(a);
	}
}
