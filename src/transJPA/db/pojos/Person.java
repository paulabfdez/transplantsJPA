package transJPA.db.pojos;


import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)


public abstract class Person {
	
	private static final long serialVersionUID = 6256446381306555938L;
	//aun asi deberia indicar que id es una PK?-->porque luego heredan patient and donor
	//Cuando comprobemos que las que no son de inheritance funcionan, tenemos que comprobar si inheritance 
	//funciona definiendo el id en person (la padre), doctor y patient, y si no, borramos id de person y lo ponemos en las hijas
	@Id
	protected Integer id;
	protected String name;
	protected Date birthDate;
	protected Float weight;
	protected Float height;
	protected String gender;
	protected String bloodType;
	//faltan las FK
	
	public Person (){
	}
	
	public Person(String name, LocalDate birthDate, Float weight, Float height, String gender, String bloodType) {
		super();
		this.name=name;
		this.setLocalDateDob(birthDate);
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.bloodType = bloodType;
	}
	
	public Person(Integer id, String name, LocalDate birthDate, Float weight, Float height, String gender, String bloodType) {
		super();
		this.id = id;
		this.name=name;
		this.setLocalDateDob(birthDate);
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.bloodType = bloodType;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	// Additional method to use LocalDate objects
	public void setLocalDateDob(LocalDate ldate) {
		this.birthDate = Date.valueOf(ldate);
	}

	// Additional method to use LocalDate objects
	public LocalDate getLocalDateDob() {
		return this.birthDate.toLocalDate();
	}

	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
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
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	//Should we put a method of compatibility test??
	
	
}
