package com.example.gestionjob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobService implements IJobService{
    @Autowired
    private JobRepo JobRepository;

    @Override
    public Job addJob(Job job) {
        return JobRepository.save(job);
    }

    @Override
    public Job updateJob(int id, Job newJob) {
        if (JobRepository.findById(id).isPresent()) {

           Job existingJob = JobRepository.findById(id).get(); existingJob.setService(newJob.getService()); existingJob.setEtat(newJob.getEtat());

            return JobRepository.save(existingJob);
        } else
            return null;

    }

    @Override
    public String deleteJob(int id) {
        if (JobRepository.findById(id).isPresent()) { JobRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";

    }
}
