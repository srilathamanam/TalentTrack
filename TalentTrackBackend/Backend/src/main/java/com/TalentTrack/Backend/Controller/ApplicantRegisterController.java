package com.TalentTrack.Backend.Controller;

import com.TalentTrack.Backend.Entity.ApplicantLogin;
import com.TalentTrack.Backend.Entity.ApplicantLoginResponse;
import com.TalentTrack.Backend.Entity.ApplicantRegister;
import com.TalentTrack.Backend.service.ApplicantRegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/registration")
public class ApplicantRegisterController {
    @Autowired
    private ApplicantRegisterService applicantRegisterService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody ApplicantRegister applicantRegister)
    {

        try {
            applicantRegisterService.registerApplicant(applicantRegister);
            return ResponseEntity.ok("Registration successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<ApplicantLoginResponse> login(@RequestBody ApplicantLogin applicantLogin) {
        try {
            ApplicantLoginResponse response = applicantRegisterService.loginVerification(applicantLogin);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApplicantLoginResponse(e.getMessage()));
        }
    }
}
