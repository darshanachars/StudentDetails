package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.example.demo.dto.ClientDto;
import com.example.demo.entity.Client;

import com.example.demo.repo.ClientRepo;
import com.example.demo.service.impl.ClientServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ClientTest {
	@Mock
	private ClientRepo clientRepo;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	private ClientServiceImpl clientService;

	@Test
	public void getAllClients() {
		List<Client> list = new ArrayList<>();
		Client c1 = new Client();

		c1.setAddress("Kadur");
		c1.setContactInformation("257");
		c1.setDateOfBirth("1998-02-02");
		c1.setId(1);
		c1.setName("Darshan");

		Client c2 = new Client();
		c2.setAddress("Kadur");
		c2.setContactInformation("257");
		c2.setDateOfBirth("1998-02-02");
		c2.setId(1);
		c2.setName("Darshan");

		list.add(c1);
		list.add(c2);

		when(clientRepo.findAll()).thenReturn(list);
		List<ClientDto> clientList = clientService.fetchAllClients();
		assertEquals(2, clientList.size());
		verify(clientRepo, times(1)).findAll();
	}

	@Test
	public void fetchClient() {
		Client c1 = new Client();
		int id = 1;
		c1.setAddress("Kadur");
		c1.setContactInformation("257");
		c1.setDateOfBirth("1998-02-02");
		c1.setId(id);
		c1.setName("Darshan");
		Optional<Client> client = clientRepo.findById(1);
		assertTrue(client != null);

	}

}
