package com.TalentTrack.Backend.service;

import com.TalentTrack.Backend.Entity.*;
import com.TalentTrack.Backend.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ApplicantProfileService {
    @Autowired
    private ApplicantProfileRepository applicantProfileRepository;

    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private SkillRepository skillRepository;


    @Transactional
    public void registerJobSeeker(ApplicantProfile applicantProfile1) {

            ApplicantProfile applicantProfile2 = new ApplicantProfile();
            applicantProfile2.setFirstname(applicantProfile1.getFirstname());
            applicantProfile2.setLastname(applicantProfile1.getLastname());
            applicantProfile2.setDob(applicantProfile1.getDob());
            applicantProfile2.setAddress(applicantProfile1.getAddress());
            applicantProfile2.setCity(applicantProfile1.getCity());
            applicantProfile2.setState(applicantProfile1.getState());
            applicantProfile2.setPincode(applicantProfile1.getPincode());
            applicantProfile2.setAlternatemobileno(applicantProfile1.getAlternatemobileno());


            Resume resume = new Resume();
            resume.setLocation(applicantProfile1.getResume().getLocation());


            for (Skill skillRequest : applicantProfile1.getResume().getSkillSet()) {
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
            education.setSscBoard(applicantProfile1.getResume().getEducation().getSscBoard());
            education.setSscPercentage(applicantProfile1.getResume().getEducation().getSscPercentage());
            education.setSscYearOfPassing(applicantProfile1.getResume().getEducation().getSscYearOfPassing());
            education.setInterBoard(applicantProfile1.getResume().getEducation().getInterBoard());
            education.setInterPercentage(applicantProfile1.getResume().getEducation().getInterPercentage());
            education.setInterYearOfPassing(applicantProfile1.getResume().getEducation().getInterYearOfPassing());
            education.setGraduationUniversity(applicantProfile1.getResume().getEducation().getGraduationUniversity());
            education.setGraduationPercentage(applicantProfile1.getResume().getEducation().getGraduationPercentage());
            education.setGraduationYearOfPassing(applicantProfile1.getResume().getEducation().getGraduationYearOfPassing());
            // Set other education properties

            educationRepository.save(education);

            resume.setEducation(education);
            applicantProfile2.setResume(resume);

            resumeRepository.save(resume);
            applicantProfileRepository.save(applicantProfile2);
        }

    public List<ApplicantProfile> getAllApplicants() {
        List<ApplicantProfile> js = applicantProfileRepository.findAll();
        return js;
    }


    }


