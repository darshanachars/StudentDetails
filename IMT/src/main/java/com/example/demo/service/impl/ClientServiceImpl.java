package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClientDto;

import com.example.demo.entity.Client;
import com.example.demo.exceptionHandler.AllObjectsException;
import com.example.demo.exceptionHandler.ResourceNotFound;
import com.example.demo.repo.ClientRepo;
import com.example.demo.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepo clientRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ClientDto> fetchAllClients() {
		List<ClientDto> userDto=null;
		try {
			List<Client> li = clientRepo.findAll();
			System.out.println(li);
			
			if(li!=null) {
				userDto = li.stream().map(client -> modelMapper.map(client, ClientDto.class))
						.collect(Collectors.toList());
				System.out.println("inside try");

				
			}
			else {
				System.out.println("got null resource");
				throw new AllObjectsException("Client");
			}

		}
		catch(AllObjectsException e){
			System.out.println("inside catch");
		}
		System.out.println("just before method close");
		
		return userDto;
	}

	@Override
	public ClientDto fetchClient(int id) {
		Client c=clientRepo.findById(id).orElseThrow(()->new ResourceNotFound("client", "id", id));
		return modelMapper.map(	c, ClientDto.class);
	}

	@Override
	public ClientDto createClient(ClientDto client) {
		Client c=modelMapper.map(client, Client.class);
		Client c1=clientRepo.save(c);
		return modelMapper.map(c1, ClientDto.class);
	}

	@Override
	public ClientDto updateClient(ClientDto client, int id) {
		
		Client c=clientRepo.findById(id).orElseThrow(()->new ResourceNotFound("Client", "id", id));
		c.setName(client.getName());
		c.setDateOfBirth(client.getDateOfBirth());
		c.setContactInformation(client.getContactInformation());
		c.setAddress(client.getAddress());
		Client newClient=clientRepo.save(c);
		return modelMapper.map(newClient, ClientDto.class);
	}

	@Override
	public void deleteClient(int id) {
		Client c=clientRepo.findById(id).orElseThrow(()->new ResourceNotFound("Client", "id", id));
		clientRepo.delete(c);

	}

}
