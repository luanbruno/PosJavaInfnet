package br.inf.AppProVenda.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inf.AppProVenda.model.domain.Cliente;
import br.inf.AppProVenda.model.domain.Usuario;
import br.inf.AppProVenda.model.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> obterLista(){

		return (List<Cliente>) clienteRepository.findAll();
	}
	
	public List<Cliente> obterLista(Usuario usuario){

		return (List<Cliente>) clienteRepository.findAll(usuario.getId());
	}

	public void incluir(Cliente cliente) {

		clienteRepository.save(cliente);
	}
	
	public void excluir(Integer id) {

		clienteRepository.deleteById(id);
	}
	
	public Cliente obterPorId(Integer id) {

		return clienteRepository.findById(id).orElse(null);
	}
}