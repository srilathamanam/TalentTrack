package com.TalentTrack.Backend.Controller;

import com.TalentTrack.Backend.Entity.JobSeeker;
import com.TalentTrack.Backend.service.ApplicantRegisterService;
import com.TalentTrack.Backend.service.JobSeekerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class JobSeekerController {
    @Autowired
    private ApplicantRegisterService applicantRegisterService;
    @Autowired
    private JobSeekerService jobSeekerService;



    @PostMapping("/register")
    public ResponseEntity<String> registerJobSeeker(@Valid @RequestBody JobSeeker jobSeeker) {
        jobSeekerService.registerJobSeeker(jobSeeker);
        return ResponseEntity.ok("Job seeker registered successfully.");
    }
   @GetMapping("/all")
    public List<JobSeeker> getAllJobSeekers()
    {
        return jobSeekerService.getAllApplicants();
    }



}