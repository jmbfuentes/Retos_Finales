package com.mintic.usa.Retos.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mintic.usa.Retos.Model.Client;
import com.mintic.usa.Retos.Repository.CRUD.ClientCrudRepoInterfaz;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepoInterfaz clientCrudRepoInterfaz;

    public List<Client> obtenerClient() {
        return (List<Client>) clientCrudRepoInterfaz.findAll();

    }

    public Client salvarClient(Client client) {
        return clientCrudRepoInterfaz.save(client);
    }

    public Optional<Client> obtenerClientId(Integer id) {
        return clientCrudRepoInterfaz.findById(id);
    }

    public void delete(Client client) {
        clientCrudRepoInterfaz.delete(client);
        
    }
    
}
