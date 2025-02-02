package com.example.gestionjob;

public interface IJobService {
     Job addJob(Job candidate);
      Job updateJob(int id, Job newCandidat);
    String deleteJob(int id);
}
