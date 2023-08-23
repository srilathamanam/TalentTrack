package com.TalentTrack.Backend.Repository;

import com.TalentTrack.Backend.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long > {
}
