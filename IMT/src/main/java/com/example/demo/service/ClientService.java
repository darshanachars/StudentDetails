package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.ClientDto;

public interface ClientService {
	public List<ClientDto> fetchAllClients();
	public ClientDto fetchClient(int id);
	public 	ClientDto createClient(ClientDto client);
	public ClientDto updateClient(ClientDto client, int id);
	public void deleteClient(int id);
}
