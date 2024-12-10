package com.project.school.management.entity;

import java.time.LocalDate;
import java.util.List;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity @Table(name = "exam_entity")
public class ExamEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NonNull
    @Column(name = "class_name")
    private Long className;

	@NonNull
    @Column(name = "exam_name")
    private Long examName;
	
	@NonNull
    @Column(name = "created_date")
    private LocalDate createdDate;

	@Size(min =1)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_entity_id")
    private List<SubjectWiseExamEntity> subjectWiseExamList;

}
