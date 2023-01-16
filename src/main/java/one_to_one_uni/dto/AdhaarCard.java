package one_to_one_uni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdhaarCard {
	@Id
	private int id;
	private String name;
	private String address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "AdhaarCard [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
