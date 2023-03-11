package com.example.tacos.services;

import com.example.tacos.data.ClientRepository;
import com.example.tacos.models.Client;
import com.example.tacos.models.TacoOrder;
import com.example.tacos.security.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements UserDetailsService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> client = clientRepository.findByUsername(username);
        if(!client.isPresent()) throw new UsernameNotFoundException("User not found");
        return new ClientDetails(client.get());
    }

    public Optional<Client> findByUsername(String username) {
        return clientRepository.findByUsername(username);
    }

    public void processTacoOrder(TacoOrder tacoOrder, String username) {
        findByUsername(username).get().addTacoOrder(tacoOrder);
    }

}
