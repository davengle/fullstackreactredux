package com.dave.engle.fullstackreactredux.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
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

    private String projectName;
    private String projectIdentifier;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    private LocalDateTime created_At;
    private LocalDateTime updated_At;


    public Project() {
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
