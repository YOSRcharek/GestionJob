package com.example.gestionjob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobRestAPI {
    @Autowired
    private JobRepo repository;
    @Autowired
    private JobService jobService;
    @GetMapping("/Job/search/JobByService")
    public Page<Job> searchJobByService(
            @RequestParam("service") String Service,
            Pageable pageable) {
        return repository.JobByService("%" + Service + "%", pageable);
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Job> createJob(@RequestBody Job job) { return new ResponseEntity<>(jobService.addJob(job), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Job> updateCandidat(@PathVariable(value = "id") int id,
                                                   @RequestBody Job job){ return new ResponseEntity<>(jobService.updateJob(id,job),HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id){ return new ResponseEntity<>(jobService.deleteJob(id), HttpStatus.OK);
    }

}
