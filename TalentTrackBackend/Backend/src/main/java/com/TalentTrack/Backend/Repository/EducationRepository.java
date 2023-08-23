package com.TalentTrack.Backend.Repository;

import com.TalentTrack.Backend.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EducationRepository extends JpaRepository<Education,Long> {

}
