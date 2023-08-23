package com.TalentTrack.Backend.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="ApplicantRegister")
public class ApplicantRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registerId;
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
}
