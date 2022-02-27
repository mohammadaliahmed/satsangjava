package com.appsinventive.satsangserver.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude(Include.NON_NULL)
@Document(collection = "Root")
public class RootMDB

{
    private String _id;
    private String familyID;
    private String personalId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String password;
    private AddressMDB address;

    private List<FamilyMDB> family;
    private String ritwikID;
    private boolean ritwikStatus;
    private boolean active;
    private String createdOn;
    private String lastUpdatedOn;
    private String userType;
    private String userName;
    private String userRole;
    private String rName;
    private String pprFlag;
    private String pseronalize;
    private String indfamilyCode;
    private boolean migrated;
    private boolean firstLogin;
    private Date lastEdited;
    private List<RootMDB> rootMdbList;
    private boolean approved;
    private String approvedBy;
    private String approvedOn;


    public List<RootMDB> getRootMdbList() {
        return rootMdbList;
    }

    public void setRootMdbList(List<RootMDB> rootMdbList) {
        this.rootMdbList = rootMdbList;
    }

    public String getIndfamilyCode() {
        return indfamilyCode;
    }

    public void setIndfamilyCode(String indfamilyCode) {
        this.indfamilyCode = indfamilyCode;
    }

    public String getPprFlag() {
        return pprFlag;
    }

    public void setPprFlag(String pprFlag) {
        this.pprFlag = pprFlag;
    }



    public void setFamilyID(String familyID) {
        this.familyID = familyID;
    }

    public String getFamilyID() {
        return this.familyID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setAddress(AddressMDB address) {
        this.address = address;
    }

    public AddressMDB getAddress() {
        return this.address;
    }

    public void setFamily(List<FamilyMDB> family) {
        this.family = family;
    }

    public List<FamilyMDB> getFamily() {
        return this.family;
    }

    public void setRitwikID(String ritwikID) {
        this.ritwikID = ritwikID;
    }

    public String getRitwikID() {
        return this.ritwikID;
    }


    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public void setRitwikStatus(boolean ritwikStatus) {
        this.ritwikStatus = ritwikStatus;
    }

    public boolean getRitwikStatus() {
        return this.ritwikStatus;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public void setLastUpdatedOn(String lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public String getLastUpdatedOn() {
        return this.lastUpdatedOn;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return this.userType;
    }

    public String getUserName() {
        return this.firstName + " " + this.lastName;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * @return the migrated
     */
    public boolean isMigrated() {
        return migrated;
    }

    /**
     * @param migrated the migrated to set
     */
    public void setMigrated(boolean migrated) {
        this.migrated = migrated;
    }

    /**
     * @return the firstLogin
     */
    public boolean isFirstLogin() {
        return firstLogin;
    }

    /**
     * @param firstLogin the firstLogin to set
     */
    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the personalize
     */
    public String getPersonalize() {
        return pseronalize;
    }

    /**
     * @param personalize the personalize to set
     */
    public void setPersonalize(String personalize) {
        this.pseronalize = personalize;
    }

    /**
     * @return the lastEdited
     */
    public Date getLastEdited() {
        return lastEdited;
    }

    /**
     * @param lastEdited the lastEdited to set
     */
    public void setLastEdited(Date lastEdited) {
        this.lastEdited = lastEdited;
    }

    /**
     * @return the approved
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * @param approved the approved to set
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    /**
     * @return the approvedBy
     */
    public String getApprovedBy() {
        return approvedBy;
    }

    /**
     * @param approvedBy the approvedBy to set
     */
    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    /**
     * @return the approvedOn
     */
    public String getApprovedOn() {
        return approvedOn;
    }

    /**
     * @param approvedOn the approvedOn to set
     */
    public void setApprovedOn(String approvedOn) {
        this.approvedOn = approvedOn;
    }


}