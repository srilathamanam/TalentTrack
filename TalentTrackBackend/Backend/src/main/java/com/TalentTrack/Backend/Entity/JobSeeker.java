package com.TalentTrack.Backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Entity

public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobseekerId;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]{3,19}$",message = "invalid username")
    private String fullname;

    @NotBlank
    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number")
    private String mobile;

    @NotBlank
    @Email(message = "invalid email address")
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "invalid password")
    private String password;

   @OneToOne(targetEntity = Resume.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "resume_id", referencedColumnName = "resumeId")
   @JsonManagedReference
    private Resume resume;
}
