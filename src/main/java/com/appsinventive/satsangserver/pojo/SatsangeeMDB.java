package com.appsinventive.satsangserver.pojo;

import com.appsinventive.satsangserver.Utils.CustomDateDeSerializer;
import com.appsinventive.satsangserver.Utils.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



public class SatsangeeMDB {

	private BigDecimal _id;
	@JsonProperty("IND_FAMILY_CODE")
	private String indiaFamilyCode;

	private String saID;

	private String firstName;
	
	
	private String middleName;
	
	private String lastName;
	
	private String address;
	@JsonProperty("PANJA_DATE")
	private String panjaDate;
	@JsonProperty("PANJA_RENEWAL")
	private String panjaRenewal;
	@JsonProperty("LIVING_STATUS")
    private String status;
	private String fullName;
	private List<SatsangeeMDB> ritvikList;
	
	private String emailId;
	private String phoneNo;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private boolean swastayani;
	 @JsonSerialize(using= CustomDateSerializer.class)
    @JsonDeserialize(using= CustomDateDeSerializer.class)
    private Date initDate;
	 private String initBy;
	 private Date submittedOn;
	 private String submittedBy;
	 
    public List<SatsangeeMDB> getRitvikList() {
		return ritvikList;
	}
	public void setRitvikList(List<SatsangeeMDB> ritvikList) {
		this.ritvikList = ritvikList;
	}
	public BigDecimal get_id() {
		return _id;
	}
	public void set_id(BigDecimal _id) {
		this._id = _id;
	}
	public String getIndiaFamilyCode() {
		return indiaFamilyCode;
	}
	public void setIndiaFamilyCode(String indiaFamilyCode) {
		this.indiaFamilyCode = indiaFamilyCode;
	}
	public String getSaID() {
		return saID;
	}
	@JsonProperty("SA_SPR_ID")
	public void setSaID(String saID) {
		this.saID = saID;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPanjaDate() {
		return panjaDate;
	}
	public void setPanjaDate(String panjaDate) {
		this.panjaDate = panjaDate;
	}
	public String getPanjaRenewal() {
		return panjaRenewal;
	}
	public void setPanjaRenewal(String panjaRenewal) {
		this.panjaRenewal = panjaRenewal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getFullName() {
		return this.firstName+" "+ this.lastName;
	}
	public void setFullName() {
		this.fullName = this.firstName+" "+ this.lastName;
		
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the swastayani
	 */
	public boolean isSwastayani() {
		return swastayani;
	}
	/**
	 * @param swastayani the swastayani to set
	 */
	public void setSwastayani(boolean swastayani) {
		this.swastayani = swastayani;
	}
	/**
	 * @return the initDate
	 */
	public Date getInitDate() {
		return initDate;
	}
	/**
	 * @param initDate the initDate to set
	 */
	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}
	/**
	 * @return the submittedOn
	 */
	public Date getSubmittedOn() {
		return submittedOn;
	}
	/**
	 * @param submittedOn the submittedOn to set
	 */
	public void setSubmittedOn(Date submittedOn) {
		this.submittedOn = submittedOn;
	}
	/**
	 * @return the submittedBy
	 */
	public String getSubmittedBy() {
		return submittedBy;
	}
	/**
	 * @param submittedBy the submittedBy to set
	 */
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
	/**
	 * @return the initBy
	 */
	public String getInitBy() {
		return initBy;
	}
	/**
	 * @param initBy the initBy to set
	 */
	public void setInitBy(String initBy) {
		this.initBy = initBy;
	}

	
	
    
}