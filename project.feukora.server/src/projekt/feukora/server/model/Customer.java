package projekt.feukora.server.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import projekt.feukora.server.business.CustomerheaterManager;
import projekt.feukora.server.business.CustomerheaterManagerImpl;

/**
 * This class refers to a customer.
 * 
 * @version 1.4
 * @author Pascal
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Customer.findByCustomerid", query = "SELECT c FROM Customer c WHERE c.customerid=:customerid"),
	@NamedQuery(name = "Customer.findByCompanyname", query = "SELECT c FROM Customer c WHERE c.companyname=:companyname"),
	@NamedQuery(name = "Customer.findByLastname", query = "SELECT c FROM Customer c WHERE c.lastname=:lastname"),
	@NamedQuery(name = "Customer.findByFirstname", query = "SELECT c FROM Customer c WHERE c.firstname=:firstname"),
	@NamedQuery(name = "Customer.findByLastnameAndFirstname", query = "SELECT c FROM Customer c WHERE c.lastname=:lastname AND c.firstname=:firstname")})
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue
	private int customerid;
	@ManyToOne
	private Customerfunction customerfunctionid;
	private String companyname;
	private String firstname;
	private String lastname;
	private String adress;
	private String phone;
	private String email;
	@ManyToOne
	private Town zip;
	@OneToMany
	private List<Customerheater> customerHeaters;
	 
	/**
	 * Default constructor
	 */
	public Customer() {
		
	}
	
	/**
	 * Customer constructor
	 * 
	 * @param companyname
	 * @param firstname
	 * @param lastname
	 * @param adress
	 * @param phone
	 * @param email
	 * @param customerfunctionid
	 * @param zip
	 */
	public Customer (String companyname, String firstname, String lastname, String adress, String phone, String email, Customerfunction customerfunctionid, Town zip) {
		this.companyname = companyname;
		this.firstname = firstname;
		this.lastname = lastname;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.customerfunctionid = customerfunctionid;
		this.zip = zip;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}


	public String getCustomerfunction() {
		return customerfunctionid.toString();
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTown(){
		return zip.toString();
	}
	
	public List<Customerheater> getCustomerHeaters()
	{
		return customerHeaters;
	}
}
