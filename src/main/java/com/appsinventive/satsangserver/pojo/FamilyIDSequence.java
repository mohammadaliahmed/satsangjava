package com.appsinventive.satsangserver.pojo;


import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;



public class FamilyIDSequence{
	
	@SerializedName(value = "_id")
	private String seqName;
 
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
