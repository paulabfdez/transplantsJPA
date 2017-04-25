package transJPA.db.pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Donors")
public class Donor extends Person{
	//que pasa con el id?
	private static final long serialVersionUID = 6705263044123670258L;
	private String deadOrAlive;
    //same questions as Patient
	@OneToMany(mappedBy="donor") 
	private List<Organ> organs;
	
	public Donor() {
	}
	
	public Donor (String name, LocalDate birthDate, Float weight, Float height, String gender, 
			      String deadOrAlive, String bloodType){
		super(name, birthDate, weight, height, gender, bloodType);
		this.deadOrAlive=deadOrAlive;
		super.setLocalDateDob(birthDate);
		
	}
	
	public Donor (Integer id, String name, LocalDate birthDate, Float weight, Float height, String gender, 
		      String deadOrAlive, String bloodType){
		super(id, name, birthDate, weight, height, gender, bloodType);
		this.deadOrAlive=deadOrAlive;
		super.setLocalDateDob(birthDate);
    }

	public String getDeadOrAlive() {
		return deadOrAlive;
	}

	public void setDeadOrAlive(String deadOrAlive) {
		this.deadOrAlive = deadOrAlive;
	}

	public List<Organ> getOrgans(){
		return organs;
	}
	
	public void setOrgans(List<Organ> organs){
		this.organs=organs;
	}
	public boolean addOrgan(Organ organ) {
		if (!organs.contains(organ)) {
			 return this.organs.add(organ);
		}
		else return false;
	}

	// Additional method to remove from a list
	public boolean removeOrgan(Organ organ) {
		if (organs.contains(organ)) {
			return this.organs.remove(organ);
		}
		else return false;
	}

	@Override
	public String toString() {
		return "Donor [id=" + id + ", name=" + name + ", birthDate=" + birthDate
				+ ", weight=" + weight + ", height=" + height + ", gender=" + gender + ","
				+ " bloodType=" + bloodType + ", deadOrAlive=" + deadOrAlive + "]";
	}
	
	
	
}

