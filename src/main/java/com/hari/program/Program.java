package com.hari.program;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "program", catalog = "postgres", schema="public", uniqueConstraints = {
		@UniqueConstraint(columnNames = "program_code")})
public class Program implements Serializable {

	private Integer programId;
	private String programCode;
	private String programDescription;
	private ProgramDetail programDetail;

	public Program() {
	}

	public Program(String programCode, String programDescription) {
		this.programCode = programCode;
		this.programDescription = programDescription;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "program_id", unique = true, nullable = false)
	public Integer getProgramId() {
		return this.programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	@Column(name = "program_code", unique = true, nullable = false, length = 25)
	public String getProgramCode() {
		return this.programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	@Column(name = "program_description", length = 255)
	public String getProgramDescription() {
		return this.programDescription;
	}

	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "program", cascade = CascadeType.ALL)
	public ProgramDetail getProgramDetail() {
		return this.programDetail;
	}

	public void setProgramDetail(ProgramDetail programDetail) {
		this.programDetail = programDetail;
	}

}