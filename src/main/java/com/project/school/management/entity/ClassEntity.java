package com.project.school.management.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "class")
public class ClassEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "section_id", referencedColumnName = "id")
//	Section section;

	@Column(name = "section", nullable = false)
	private String section;

	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	List<Subject> subject = new ArrayList<>();

}
