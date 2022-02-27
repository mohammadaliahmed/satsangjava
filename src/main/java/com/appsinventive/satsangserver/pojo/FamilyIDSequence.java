package com.appsinventive.satsangserver.pojo;


import com.google.gson.annotations.SerializedName;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Document(collection = "FamilyIDSequence")
public class FamilyIDSequence{
	
	@SerializedName(value = "_id")
	private String seqName;
	private String familyID;
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyID() {
		return familyID;
	}

	public void setFamilyID(String familyID) {
		this.familyID = familyID;
	}

	private BigDecimal seqValue;
	
	private BigDecimal cache;

	public String getSeqName() {
		return seqName;
	}

	public void setSeqName(String seqName) {
		this.seqName = seqName;
	}

	public BigDecimal getSeqValue() {
		return seqValue;
	}

	public void setSeqValue(BigDecimal seqValue) {
		this.seqValue = seqValue;
	}
	
	public BigDecimal getCache() {
		return cache;
	}

	public void setCache(BigDecimal cache) {
		this.cache = cache;
	}

	
		
}
