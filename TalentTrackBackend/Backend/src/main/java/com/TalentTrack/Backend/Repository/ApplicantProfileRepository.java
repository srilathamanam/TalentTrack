package com.TalentTrack.Backend.Repository;

import com.TalentTrack.Backend.Entity.ApplicantProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantProfileRepository extends JpaRepository<ApplicantProfile, Long> {

}
