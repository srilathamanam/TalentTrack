package com.TalentTrack.Backend.Repository;

import com.TalentTrack.Backend.Entity.ApplicantRegister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicantRegisterRepository extends JpaRepository<ApplicantRegister, Integer> {
Optional<ApplicantRegister> findByEmail(String email);
}
