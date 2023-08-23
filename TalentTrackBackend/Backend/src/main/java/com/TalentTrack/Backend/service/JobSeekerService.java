package com.TalentTrack.Backend.service;

import com.TalentTrack.Backend.Entity.*;
import com.TalentTrack.Backend.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobSeekerService {
    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private SkillRepository skillRepository;
    @Transactional
    public void registerJobSeeker(JobSeeker jobSeeker1) {

            JobSeeker jobSeeker2 = new JobSeeker();
            jobSeeker2.setFullname(jobSeeker1.getFullname());
            jobSeeker2.setMobile(jobSeeker1.getMobile());
            jobSeeker2.setEmail(jobSeeker1.getEmail());
            jobSeeker2.setPassword(jobSeeker1.getPassword());


            Resume resume = new Resume();
            resume.setLocation(jobSeeker1.getResume().getLocation());


            for (Skill skillRequest : jobSeeker1.getResume().getSkillSet()) {
                Skill skill = new Skill();
                skill.setSkill_name(skillRequest.getSkill_name());

                Experience experience = new Experience();
                experience.setYears(skillRequest.getExperience().getYears());

                skill.setExperience(experience);
              //  experience.setSkill(skill);
                experienceRepository.save(experience);
                resume.getSkillSet().add(skill);
                skillRepository.save(skill);

            }

            // Create Education
            Education education = new Education();
            education.setSscBoard(jobSeeker1.getResume().getEducation().getSscBoard());
            education.setSscPercentage(jobSeeker1.getResume().getEducation().getSscPercentage());
            education.setSscYearOfPassing(jobSeeker1.getResume().getEducation().getSscYearOfPassing());
            education.setInterBoard(jobSeeker1.getResume().getEducation().getInterBoard());
            education.setInterPercentage(jobSeeker1.getResume().getEducation().getInterPercentage());
            education.setInterYearOfPassing(jobSeeker1.getResume().getEducation().getInterYearOfPassing());
            education.setGraduationUniversity(jobSeeker1.getResume().getEducation().getGraduationUniversity());
            education.setGraduationPercentage(jobSeeker1.getResume().getEducation().getGraduationPercentage());
            education.setGraduationYearOfPassing(jobSeeker1.getResume().getEducation().getGraduationYearOfPassing());
            // Set other education properties

            educationRepository.save(education);

            resume.setEducation(education);
            jobSeeker2.setResume(resume);

            resumeRepository.save(resume);
            jobSeekerRepository.save(jobSeeker2);
        }

    public List<JobSeeker> getAllApplicants() {
        List<JobSeeker> js = jobSeekerRepository.findAll();
        return js;
    }
    }


