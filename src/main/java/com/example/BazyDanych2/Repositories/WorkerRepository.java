package com.example.BazyDanych2.Repositories;

import com.example.BazyDanych2.Model.PersonalData;
import com.example.BazyDanych2.Model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("workerRepository")
public interface WorkerRepository extends JpaRepository<Worker,Long> {
    public Optional<Worker> findById(Long id);
    public Optional<Worker> findByWorkName(String workName);
}
