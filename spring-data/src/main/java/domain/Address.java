package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="address_id")
    private Long addressId;

	@Column(name = "city")
    private String city;   

	@Column(name = "state")
    private String state;   

	@Column(name = "pinCode")
    private Long pinCode;

	public Long getAddressId() {
		return addressId;
	}

	public Address() {
	}
	
	public Address(String city, String state, Long pinCode) {
		super();
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", state=" + state + ", pincode=" + pinCode + "]";
	}
}
