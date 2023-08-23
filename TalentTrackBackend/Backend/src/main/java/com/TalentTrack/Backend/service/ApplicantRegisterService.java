package com.TalentTrack.Backend.service;

import com.TalentTrack.Backend.Entity.ApplicantLogin;
import com.TalentTrack.Backend.Entity.ApplicantLoginResponse;
import com.TalentTrack.Backend.Entity.ApplicantRegister;
import com.TalentTrack.Backend.Repository.ApplicantRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;
@Service
public class ApplicantRegisterService {

    @Autowired
    private ApplicantRegisterRepository applicantRegisterRepository;

    public ApplicantRegister registerApplicant(ApplicantRegister applicantRegister) {
        Optional<ApplicantRegister> existingApplicant = applicantRegisterRepository.findByEmail(applicantRegister.getEmail());

        if (existingApplicant.isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        return applicantRegisterRepository.save(applicantRegister);
    }

    public ApplicantLoginResponse loginVerification(ApplicantLogin applicantLogin) {
        ApplicantRegister applicantRegister = applicantRegisterRepository.findByEmail(applicantLogin.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Email not found"));


        if (!(applicantRegister.getPassword()).equals(applicantLogin.getPassword())) {
            throw new IllegalArgumentException("Incorrect password");
        }

        return new ApplicantLoginResponse("Login Successful");
    }

}




