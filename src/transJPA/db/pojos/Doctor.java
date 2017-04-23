package transJPA.db.pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Doctors")

public class Doctor implements Serializable{

	private static final long serialVersionUID = -1701687912909197672L;
	@Id
	private Integer id;
	private String registrationNumber;
	private String specialization;
	private String nameOfDoctor;
	//no estaba antes el atributo de Hospital ni lista de pacientes
	@ManyToOne(fetch = FetchType.LAZY) //only get the hospital when u ask for it
	@JoinColumn(name = "hospital_id") //the one that is going to be the FK in doctors´table
	private Hospital hospital;
	@ManyToMany(mappedBy = "doctors/patients") //name of the table with both FK
	private List<Patient> patients;
	
	
	//our default constructor
	public Doctor (){
	}
	
	public Doctor(String nameOfDoctor,String registrationNumber, String specialization){
		this.nameOfDoctor=nameOfDoctor;
		this.registrationNumber=registrationNumber;
		this.specialization=specialization;		
	}
	
	public Doctor(Integer id, String nameOfDoctor,String registrationNumber, String specialization){
		this.id=id;
		this.nameOfDoctor=nameOfDoctor;
		this.registrationNumber=registrationNumber;
		this.specialization=specialization;
		
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	//getters and setters of all its atributes
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getNameOfDoctor() {
		return nameOfDoctor;
	}
	public void setNameOfDoctor(String nameOfDoctor) {
		this.nameOfDoctor = nameOfDoctor;
	}

	@Override
	public String toString() {
		return "Doctor [\nregistrationNumber=" + registrationNumber + ", \nspecialization=" + specialization
				+ ", \nnameOfDoctor=" + nameOfDoctor + "]";
	}
	
	
	
	
}

