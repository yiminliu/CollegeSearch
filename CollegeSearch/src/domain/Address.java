package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long addressId;

	@Column(name = "Street")
	private String streetAddress;

	@Column(name = "City")
	String city;

	@Column(name = "State")
	String state;

	@Column(name = "Zip_Code")
	String zipCode;

	@Column(name = "State")
	String country;

	@Column(name = "State")
	String location;

	public Address() {
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	private long getAddressId() {
		return addressId;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	private void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}
}
