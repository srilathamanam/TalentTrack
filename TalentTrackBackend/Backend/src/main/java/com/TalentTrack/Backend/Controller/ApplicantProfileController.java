package com.TalentTrack.Backend.Controller;

import com.TalentTrack.Backend.Entity.ApplicantProfile;
import com.TalentTrack.Backend.service.ApplicantRegisterService;
import com.TalentTrack.Backend.service.ApplicantProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ApplicantProfileController {
    @Autowired
    private ApplicantRegisterService applicantRegisterService;
    @Autowired
    private ApplicantProfileService applicantProfileService;



    @PostMapping("/update")
    public ResponseEntity<String> registerJobSeeker(@Valid @RequestBody ApplicantProfile applicantProfile) {
        applicantProfileService.registerJobSeeker(applicantProfile);
        return ResponseEntity.ok("Job seeker registered successfully.");
    }
   @GetMapping("/all")
    public List<ApplicantProfile> getAllJobSeekers()
    {
        return applicantProfileService.getAllApplicants();
    }



}