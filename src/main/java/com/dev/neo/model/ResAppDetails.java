package com.dev.neo.model;

import java.util.List;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResAppDetails {
 
  @ApiModelProperty
   public String getAppcode() {
		return appcode;
	}
	public void setAppcode(String appcode) {
		this.appcode = appcode;
	}
	@ApiModelProperty
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}

 /**
	 * @return the dbVersion
	 */
	@ApiModelProperty
	public String getDbVersion() {
		return dbVersion;
	}
	/**
	 * @param dbVersion the dbVersion to set
	 */
	public void setDbVersion(String dbVersion) {
		this.dbVersion = dbVersion;
	}

/**
	 * @return the appVersion
	 */
	@ApiModelProperty
	public Number getAppVersion() {
		return appVersion;
	}
	/**
	 * @param appVersion the appVersion to set
	 */
	public void setAppVersion(Number appVersion) {
		this.appVersion = appVersion;
	}
 
	 
 /**
	 * @return the masterDetails
	 */
	@ApiModelProperty
	public List<MasterDetails> getMasterDetails() {
		return masterDetails;
	}
	/**
	 * @param masterDetails the masterDetails to set
	 */
	public void setMasterDetails(List<MasterDetails> masterDetails) {
		this.masterDetails = masterDetails;
	}

 



 private String appcode;
 private String osName;
 private Number appVersion;
 private  String dbVersion;
 private List<MasterDetails> masterDetails; 
}
