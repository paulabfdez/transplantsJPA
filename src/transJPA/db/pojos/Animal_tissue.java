package transJPA.db.pojos;

import java.io.Serializable;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Animal_tissue")

public class Animal_tissue implements Serializable {

	private static final long serialVersionUID = -7167881940806327162L;
	@Id 
	@GeneratedValue(generator="Animal_tissue")
	@TableGenerator(name="Animal_tissue", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="Animal_tissue")
	private Integer id;
	private String name;
	private String typeOfTissue;
	private String pathology;
	private Integer timeItLasts;
	
	@ManyToMany(mappedBy = "Requested_organs/animals") //name of the table with both FK
	private List<Requested_organ> requested_organs;
	
	
	public Animal_tissue() {
		super();
	}
	
		
	public Animal_tissue(Integer id, String name, String typeOfTissue, String pathology, int time) {
		super();
		this.id = id;
		this.name = name;
		this.typeOfTissue = typeOfTissue;
		this.pathology = pathology;
		this.timeItLasts = time;
	}
	
	public Animal_tissue(String name, String typeOfTissue, String pathology, int time) {
		super();
		this.name = name;
		this.typeOfTissue = typeOfTissue;
		this.pathology = pathology;
		this.timeItLasts = time;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Animal_tissue other = (Animal_tissue) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Animal_tissue [\nname=" + name + ", \ntype_of_tissue=" + typeOfTissue + ", \npathology="
				+ pathology + ", \ntime=" + timeItLasts + "]";
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeOfTissue() {
		return typeOfTissue;
	}
	public void setTypeOfTissue(String typeOfTissue) {
		this.typeOfTissue = typeOfTissue;
	}
	public String getPathology() {
		return pathology;
	}
	public void setPathology(String pathology) {
		this.pathology = pathology;
	}
	public int getTimeItLasts() {
		return timeItLasts;
	}
	public void setTimeItLasts(int timeItLasts) {
		this.timeItLasts = timeItLasts;
	}
	public List<Requested_organ> getRequested_organs(){
		return requested_organs;
	}
	
	public void setRequested_organs(List<Requested_organ> requested_organs){
		this.requested_organs=requested_organs;
	}

	
	public void addRequestedOrgan(Requested_organ requested_organ) {
		if (!requested_organs.contains(requested_organ)) {
			this.requested_organs.add(requested_organ);
		}
	}

	// Additional method to remove from a list
	public void removeRequestedOrgan(Requested_organ requested_organ) {
		if (requested_organs.contains(requested_organ)) {
			this.requested_organs.remove(requested_organ);
		}
	}
}

