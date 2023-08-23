package com.TalentTrack.Backend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
      private Long educationId;
    private String sscBoard;
    private double sscPercentage;
    private Integer sscYearOfPassing;
    private String interBoard;
   private double interPercentage;
    private Integer interYearOfPassing;
    private String graduationUniversity;
    private double graduationPercentage;
    private Integer graduationYearOfPassing;

    @OneToOne( cascade = CascadeType.ALL)
    @JsonBackReference
    private Resume resume;
}
