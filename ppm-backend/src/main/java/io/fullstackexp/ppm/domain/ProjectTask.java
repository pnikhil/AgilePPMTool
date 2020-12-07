package io.fullstackexp.ppm.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class ProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    private String projectSequence;
    @NotBlank(message = "Please include a project summary")
    private String summary;
    private String acceptanceCriteria;
    private String status;
    private Integer priority;
    private Date dueDate;

    // Many to One with backlog (many tasks in one BL)
    @Column(updatable = false)
    private String projectIdentifier;

    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;

    @PrePersist
    protected void onCreate(){
        this.setCreatedDateTime(LocalDateTime.now());
    }

    @PreUpdate
    protected void onUpdate(){
        this.setUpdatedDateTime(LocalDateTime.now());
    }
}
