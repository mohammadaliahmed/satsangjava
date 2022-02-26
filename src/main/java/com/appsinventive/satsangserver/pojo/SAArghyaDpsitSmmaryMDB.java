
package com.appsinventive.satsangserver.pojo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(Include.NON_NULL)
public class SAArghyaDpsitSmmaryMDB {

	private BigDecimal id;
   
    private Date transactionDate;
    
    @JsonProperty("amount")
    private Double amount;
    
    @JsonInclude(Include.NON_EMPTY)
    private String amountDesc;
    
   
    @JsonProperty("headType")
    private String headType;
    
    @JsonProperty("headCodeName")
    private String headCode;
    

    @JsonProperty("headCodeDesc")
    private String headCodeDesc;
    
  
    @JsonProperty("headSubCodeName")
    private String headSubCode;
    
  
    @JsonProperty("headSubCodeDesc")
    private String headSubCodeDesc;
    
   
    @JsonProperty("headSubCatCode")
    private String headSubCatCode;
    
    
    @JsonProperty("headSubCatCodeDesc")
    private String headSubCatCodeDesc;
    
    @JsonProperty("submittedOn")
    private String submittedOn;
    
    @JsonProperty("balance")
    private Double balance= new Double(0);
    
    
    private String subCatName;
    
    private String subCatDesc;
    
    private Date createdDt;
    
    private String createdBy;
    
    private Date updatedDt;
    
    private String updatedBy;
    
    
    private String familyId;
    private String familyName;
    private String receiptNo;


	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the amountDesc
	 */
	public String getAmountDesc() {
		return amountDesc;
	}

	/**
	 * @param amountDesc the amountDesc to set
	 */
	public void setAmountDesc(String amountDesc) {
		this.amountDesc = amountDesc;
	}

	/**
	 * @return the headType
	 */
	public String getHeadType() {
		return headType;
	}

	/**
	 * @param headType the headType to set
	 */
	public void setHeadType(String headType) {
		this.headType = headType;
	}

	/**
	 * @return the createdDt
	 */
	public Date getCreatedDt() {
		return createdDt;
	}

	/**
	 * @param createdDt the createdDt to set
	 */
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedDt
	 */
	public Date getUpdatedDt() {
		return updatedDt;
	}

	/**
	 * @param updatedDt the updatedDt to set
	 */
	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}

	/**
	 * @return the headCode
	 */
	public String getHeadCode() {
		return headCode;
	}

	/**
	 * @param headCode the headCode to set
	 */
	public void setHeadCode(String headCode) {
		this.headCode = headCode;
	}

	/**
	 * @return the headCodeDesc
	 */
	public String getHeadCodeDesc() {
		return headCodeDesc;
	}

	/**
	 * @param headCodeDesc the headCodeDesc to set
	 */
	public void setHeadCodeDesc(String headCodeDesc) {
		this.headCodeDesc = headCodeDesc;
	}

	/**
	 * @return the headSubCode
	 */
	public String getHeadSubCode() {
		return headSubCode;
	}

	/**
	 * @param headSubCode the headSubCode to set
	 */
	public void setHeadSubCode(String headSubCode) {
		this.headSubCode = headSubCode;
	}

	/**
	 * @return the headSubCodeDesc
	 */
	public String getHeadSubCodeDesc() {
		return headSubCodeDesc;
	}

	/**
	 * @param headSubCodeDesc the headSubCodeDesc to set
	 */
	public void setHeadSubCodeDesc(String headSubCodeDesc) {
		this.headSubCodeDesc = headSubCodeDesc;
	}

	/**
	 * @return the submittedOn
	 */
	public String getSubmittedOn() {
		return submittedOn;
	}

	/**
	 * @param submittedOn the submittedOn to set
	 */
	public void setSubmittedOn(String submittedOn) {
		this.submittedOn = submittedOn;
	}

	/**
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * @return the headSubCatCode
	 */
	public String getHeadSubCatCode() {
		return headSubCatCode;
	}

	/**
	 * @param headSubCatCode the headSubCatCode to set
	 */
	public void setHeadSubCatCode(String headSubCatCode) {
		this.headSubCatCode = headSubCatCode;
	}

	/**
	 * @return the headSubCatCodeDesc
	 */
	public String getHeadSubCatCodeDesc() {
		return headSubCatCodeDesc;
	}

	/**
	 * @param headSubCatCodeDesc the headSubCatCodeDesc to set
	 */
	public void setHeadSubCatCodeDesc(String headSubCatCodeDesc) {
		this.headSubCatCodeDesc = headSubCatCodeDesc;
	}

	/**
	 * @return the subCatName
	 */
	public String getSubCatName() {
		return subCatName;
	}

	/**
	 * @param subCatName the subCatName to set
	 */
	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	/**
	 * @return the subCatDesc
	 */
	public String getSubCatDesc() {
		return subCatDesc;
	}

	/**
	 * @param subCatDesc the subCatDesc to set
	 */
	public void setSubCatDesc(String subCatDesc) {
		this.subCatDesc = subCatDesc;
	}

	/**
	 * @return the familyId
	 */
	public String getFamilyId() {
		return familyId;
	}

	/**
	 * @param familyId the familyId to set
	 */
	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}

	/**
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * @return the receiptNo
	 */
	public String getReceiptNo() {
		return receiptNo;
	}

	/**
	 * @param receiptNo the receiptNo to set
	 */
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}


	

    
    
    

   
}
