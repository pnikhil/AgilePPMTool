package io.fullstackexp.ppm.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Backlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer PTSequence = 0;
    private String projectIdentifier;

    // 1-1 Mapping with Project (One project one backlog)

    // 1 - Many (A backlog ca n have one or more project task.  A project task can belong to only one backlog)
}
