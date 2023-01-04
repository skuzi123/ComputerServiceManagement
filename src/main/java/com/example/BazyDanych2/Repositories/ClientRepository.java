package com.example.BazyDanych2.Repositories;

import com.example.BazyDanych2.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client,Long> {

    public Optional<Client> findById(Long id);
    public Optional<Client> findByEmail(String email);
}
