package br.com.homehelp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.homehelp.model.Cliente;
import br.com.homehelp.service.ClienteService;

@RestController
@RequestMapping("/cli")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	// End points
	@RequestMapping(method = RequestMethod.POST, value = "/novo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {

		Cliente clienteCadastrado = clienteService.cadastrar(cliente);
		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {

		Collection<Cliente> clientesBuscados = clienteService.buscarTodos();

		return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Integer id) {

		Cliente cliente = clienteService.buscarPorId(id);

		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir/{id}" )
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {
		
		Cliente clienteEncontrado = clienteService.buscarPorId(id);
		if (clienteEncontrado==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		clienteService.excluir(clienteEncontrado);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/alterar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {

		Cliente clienteAlterado = clienteService.alterar(cliente);
		return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
	}
}
