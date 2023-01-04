package com.example.BazyDanych2.Services;

import com.example.BazyDanych2.Model.Worker;
import com.example.BazyDanych2.Repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
    private static final String WORKER_NOT_FOUND = "Worker with this workName doesn't exist!!!";
    private WorkerRepository workerRepository;
    @Autowired
    public WorkerService(@Qualifier("workerRepository") WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> getAllWorkers(){
        return workerRepository.findAll();
    }

    public Worker getWorkerById(Long id){
        Optional<Worker> foundWorker = workerRepository.findById(id);
        return foundWorker.orElseThrow();
    }

    public Worker getWorkerByWorkName(String workName){
        return workerRepository.findByWorkName(workName)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(WORKER_NOT_FOUND)));
    }

    public Worker saveWorker(Worker worker){
        return workerRepository.saveAndFlush(worker);
    }

    public String deleteWorker(Long id){
        Worker workerToDelete = getWorkerById(id);
        workerRepository.delete(workerToDelete);
        return "Worker with id: " + id + " was deleted!";
    }
}
