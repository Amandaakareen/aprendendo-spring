package com.example.aprendendospring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    public ClienteRepository clienteRepository;

    @GetMapping
    public List <Cliente> getCliente(){
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente addCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @PutMapping("{id}")
    public Cliente editarCliente(@PathVariable("id") Long id,@RequestBody Cliente body){
        Optional <Cliente> clienteId = clienteRepository.findById(id);

        Cliente cliente = clienteId.get();
        cliente.setNome(body.getNome());

        clienteRepository.save(cliente);
        return cliente;
    }
    @DeleteMapping ("{id}")
    public void excluir(@PathVariable("id") Long id) {
      clienteRepository.deleteById(id);
    }

}
