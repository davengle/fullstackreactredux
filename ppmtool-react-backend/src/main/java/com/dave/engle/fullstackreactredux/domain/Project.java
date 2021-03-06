package com.dave.engle.fullstackreactredux.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Project name is required")
    private String projectName;
    @Setter(AccessLevel.NONE)
    @NotBlank(message = "Project identifier is required")
    @Size(min=4, max=5, message = "Please use 4 to 5 characters")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;
    @NotBlank(message = "Project description is required")
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @Column(updatable = false)
    private LocalDateTime created_At;
    private LocalDateTime updated_At;


    public Project() {
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier.toUpperCase();
    }

    @PrePersist
    protected void onCreate(){
        this.created_At = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_At = LocalDateTime.now();
    }
}
