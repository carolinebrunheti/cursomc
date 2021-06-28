package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repositories.ClienteRepository;
//classe resposavel por fazer a conferencia no repositorio
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {
	
	//essa dependencia vai ser instanciada pelo spring qd digita o auto
@Autowired
	private ClienteRepository repo;

public Cliente find(Integer id) {
	 Optional<Cliente> obj = repo.findById(id); 
	 return obj.orElseThrow(() -> new ObjectNotFoundException(
			 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
			
	 
}
}