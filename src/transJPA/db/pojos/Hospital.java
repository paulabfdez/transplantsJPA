package transJPA.db.pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import transJPA.db.pojos.Doctor;

@Entity
@Table(name = "Hospitals")


public class Hospital implements Serializable{

	private static final long serialVersionUID = -2900229453507535621L;
	@Id
	private Integer id;
	private String name;
	private String phone_number;
	private String address;
	private String city;
	private String postcode;
	private String country;
	//estas dos lineas de abajo no se si habria que ponerlas porque antes no habia lista de doctores
	@OneToMany(mappedBy="hospital")
	private List<Doctor> doctors;
	@OneToMany(mappedBy="hospital")
	private List<Patient> patients;
	
	public Hospital (){
		}
	
	public Hospital(String name, String phone_number, String address, String city, String postcode,
			String country) {
		this.name = name;
		this.phone_number = phone_number;
		this.address = address;
		this.city = city;
		this.postcode = postcode;
		this.country = country;
	}	
	
	public Hospital (String name){
		this.name=name;
	}
	
	public Hospital(int id, String name, String phone_number, String address, String city, String postcode,
			String country) {
		this.id=id;
		this.name = name;
		this.phone_number = phone_number;
		this.address = address;
		this.city = city;
		this.postcode = postcode;
		this.country = country;
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
		Hospital other = (Hospital) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
	
		return "Hospital: \nname=" + name + ", \nphone_number=" + phone_number + ", \naddress=" + address + ", \ncity=" + city
				+ ", \npostcode=" + postcode + ", \ncountry=" + country + "]\n";
	}
	
	
}
