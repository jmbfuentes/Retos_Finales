package com.mintic.usa.Retos.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.usa.Retos.Model.Client;
import com.mintic.usa.Retos.Service.ClientService;



@RestController
@RequestMapping("/api/Client")
@CrossOrigin (origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})

public class ClientController {
    
    @Autowired
    private ClientService clientService;   

    @GetMapping("/all")
    public List<Client> obtenerClient(){
        return clientService.obtenerClient();
    }

    @GetMapping("/{id}")
    public Optional<Client> obtenerClientId(@PathVariable("id")Integer identificador){
        return clientService.obtenerClientId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client salvarClient(@RequestBody Client client){
        return clientService.salvarClient(client);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client actualizarClient(@RequestBody Client client){
        return clientService.actualizarClient(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrarClient(@PathVariable("id") int clientId){
        return clientService.borrarClient(clientId);

    }
}

