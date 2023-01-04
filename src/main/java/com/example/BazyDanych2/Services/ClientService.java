package com.example.BazyDanych2.Services;

import com.example.BazyDanych2.Model.Client;
import com.example.BazyDanych2.Model.Worker;
import com.example.BazyDanych2.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private static final String CLIENT_NOT_FOUND = "Client with this email doesn't exist!!!";
    private ClientRepository clientRepository;
    @Autowired
    public ClientService(@Qualifier("clientRepository") ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(Long id){
        Optional<Client> foundClient = clientRepository.findById(id);
        return foundClient.orElseThrow();
    }

    public Client getClientByEmail(String email){
        return clientRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(CLIENT_NOT_FOUND)));
    }

    public Client saveClient(Client client){
        return clientRepository.saveAndFlush(client);
    }

    public String deleteClient(Long id){
        Client clientToDelete = getClientById(id);
        clientRepository.delete(clientToDelete);
        return "Client with id: " + id + " was deleted!";
    }
}
