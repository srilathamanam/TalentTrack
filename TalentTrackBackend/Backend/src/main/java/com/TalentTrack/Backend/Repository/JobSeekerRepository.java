package com.TalentTrack.Backend.Repository;

import com.TalentTrack.Backend.Entity.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {

}
