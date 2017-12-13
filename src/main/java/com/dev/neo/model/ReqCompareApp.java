package com.dev.neo.model;

import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReqCompareApp {

	 private String appcode;
	 private String osName;
	 private Number  appVersion;
	 private  Number dbVersion;
	 private List<MasterDetails> masterDetails;
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
	 * @return the dbVersion
	 */
	@ApiModelProperty
	public Number getDbVersion() {
		return dbVersion;
	}
	/**
	 * @param dbVersion the dbVersion to set
	 */
	public void setDbVersion(Number dbVersion) {
		this.dbVersion = dbVersion;
	}
	/**
	 * @return the forceUpdate
	 */
	
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
}
