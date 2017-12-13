package com.dev.neo.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqAppDetails {
	

 private String appcode;
 private String osName;
// private String dbVersion;
// private String masterVersion;
 
 
	/**
	 * @return the osName
	 */
 	@ApiModelProperty
	public String getOsName() {
		return osName;
	}
	/**
	 * @param osName the osName to set
	 */
	public void setOsName(String osName) {
		this.osName = osName;
	}
	/**
	 * @return the appcode
	 */
	@ApiModelProperty
	public String getAppcode() {
		return appcode;
	}
	/**
	 * @param appcode the appcode to set
	 */
	public void setAppcode(String appcode) {
		this.appcode = appcode;
	}
	/**
	 * @return the masterVersion
	 */
//	public String getMasterVersion() {
//		return masterVersion;
//	}
	/**
	 * @param masterVersion the masterVersion to set
	 */
//	public void setMasterVersion(String masterVersion) {
//		this.masterVersion = masterVersion;
//	}
	/**
	 * @return the dbVersion
	 */
//	public String getDbVersion() {
//		return dbVersion;
//	}
	/**
	 * @param dbVersion the dbVersion to set
	 */
//	public void setDbVersion(String dbVersion) {
//		this.dbVersion = dbVersion;
//	}
 
}
