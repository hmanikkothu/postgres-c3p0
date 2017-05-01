package com.hari.program;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "program_detail", catalog = "postgres", schema="public")
public class ProgramDetail implements Serializable {

	private Integer programId;
	private Program program;
	private String casts;
	private int year;

	public ProgramDetail() {
	}

	@GenericGenerator(name = "generator", strategy = "foreign", 
	parameters = @Parameter(name = "property", value = "program"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "program_id", unique = true, nullable = false)
	public Integer getProgramId() {
		return this.programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Program getProgram() {
		return this.program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	@Column(name = "casts", length = 200)
	public String getCasts() {
		return this.casts;
	}

	public void setCasts(String casts) {
		this.casts = casts;
	}

	@Column(name = "year", nullable = false)
	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}