package com.example.demo.menu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "Study")
@Table(name = "Study")
@SequenceGenerator(
		name = "STUDY_SEQ_GENERATOR",
		sequenceName = "SEQ_STUDY_CODE",
		initialValue = 1,
		allocationSize = 1
)
@Data
public class Study {

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "STUDY_SEQ_GENERATOR"
	)
	@Column(name = "STUDY_ID")
	private int studyId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	
	
}
