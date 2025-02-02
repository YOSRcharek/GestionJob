package com.example.gestionjob;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepo extends JpaRepository<Job,Integer> {
    @Query("select c from Job c where c.service like :name")
    Page<Job> JobByService(@Param("service") String n, Pageable pageable);
}
