package dz.com.naftal.petrocard.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the EMPLOYEDEMANDEURS database table.
 * 
 */
@Entity
@Table(name="EMPLOYEDEMANDEURS")
@NamedQueries({
@NamedQuery(name = "Employedemandeur.findAll", query = "SELECT emp FROM Employedemandeur emp ")
})
public class Employedemandeur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLOYEDEMANDEURS_EMPLOYEID_GENERATOR", sequenceName="SEQ_EMPLOYE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEDEMANDEURS_EMPLOYEID_GENERATOR")
	
	private Integer employeid;

	
	private String adresse;

	@Temporal(TemporalType.DATE)
	private Date datenaissance;

	
	private String email;
	
	private String nomemp;

	
	private String prenomemp;

    @ManyToOne
	@JoinColumn(name="STRUCTUREID",
            insertable=false, updatable=false,
            nullable=false)
	private Structure structure;

	@Column(name="\"Tel\"", length=20)
	private String tel;
	


	public Employedemandeur() {
	}

	

	public Integer getEmployeid() {
		return employeid;
	}



	public void setEmployeid(Integer employeid) {
		this.employeid = employeid;
	}



	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDatenaissance() {
		return this.datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomemp() {
		return this.nomemp;
	}

	public void setNomemp(String nomemp) {
		this.nomemp = nomemp;
	}

	public String getPrenomemp() {
		return this.prenomemp;
	}

	public void setPrenomemp(String prenomemp) {
		this.prenomemp = prenomemp;
	}


	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}



	

}