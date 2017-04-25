package transJPA.db.pojos;

import java.util.List;


import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Patients")
public class Patient extends Person{


	private static final long serialVersionUID = 5283904286714952072L;
	//should this one implement Serializable? Should person? Or both?
	//EL ID ESTA EN LA CLASE PERSONA
	
	private Integer lifeExpectancy;
	private String pathology;
	private LocalDate additionDate;
	@ManyToMany
	//the attribute above joins both tables creating doctors/patients
	@JoinTable(name="doctors/patients",
		joinColumns={@JoinColumn(name="patient_id", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="doctor_ID", referencedColumnName="id")})
	//joincolumn makes reference to the class Patient.
	//inversejoincolumns makes reference to the opposite class-->doctor
	//Patient has a list of doctors
	//Doctor has a list of patients
	private List<Doctor> doctors;
	@ManyToOne(fetch = FetchType.LAZY)//only get the hospital when u ask for it (with gethospital)
	@JoinColumn(name = "hospital_id") // the FK
	private Hospital hospital;
	//el donor tambien tiene un hospital?o solo el paciente?
	@ManyToOne
	@JoinColumn(name = "Requested_organ_id")
	private Requested_organ requested_organ;
	public Patient(){
		
	}
	

	public Patient(String name, LocalDate birthDate,Float weight, Float height, String gender, String pathology, String bloodType, 
			Integer lifeExpectancy, LocalDate additionDate){
		super(name, birthDate,weight,height,gender, bloodType);
		this.pathology = pathology;
		this.lifeExpectancy=lifeExpectancy;
		this.additionDate=additionDate;
	}
	
	public Patient(Integer id, String name, LocalDate birthDate,Float weight, Float height, String gender, String pathology, 
			String bloodType, Integer lifeExpectancy, LocalDate additionDate){
		super(id, name, birthDate,weight,height,gender, bloodType);
		this.lifeExpectancy=lifeExpectancy;
		this.additionDate=additionDate;
	}
	
	//what about the parent class?? Do we create them in the parent class??
	public Integer getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(Integer lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public LocalDate getAdditionDate() {
		return additionDate;
	}

	public void setAdditionDate(LocalDate additionDate) {
		this.additionDate = additionDate;
	}
	
	public String getPathology() {
		return pathology;
	}

	public void setPathology(String pathology) {
		this.pathology = pathology;
	}
	
	public Requested_organ getRequested_organ(){
		return requested_organ;
	}
	public void setRequested_organ (Requested_organ requested_organ){
		this.requested_organ= requested_organ;
	}
	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	// Additional method to add to a list
		public boolean addDoctor(Doctor doctor) {
			if (!doctors.contains(doctor)) {
				 return this.doctors.add(doctor);
			}
			else return false;
		}

		// Additional method to remove from a list
		public boolean removeDoctor(Doctor doctor) {
			if (doctors.contains(doctor)) {
				return this.doctors.remove(doctor);
			}
			else return false;
		}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", weight=" + weight + 
				", height=" + height + ", gender=" + gender + "lifeExpectancy=" + lifeExpectancy + 
				", additionDate=" + additionDate + ", bloodType=" + bloodType + "]";
	}
	
	
	
}
