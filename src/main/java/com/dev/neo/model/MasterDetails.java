package com.dev.neo.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel
public class MasterDetails {

	private String masterCode;
	private Number masterVersion;
	
	
	/**
	 * @return the masterCode
	 */
	@ApiModelProperty
	public String getMasterCode() {
		return masterCode;
	}
	/**
	 * @param masterCode the masterCode to set
	 */
	
	public void setMasterCode(String masterCode) {
		this.masterCode = masterCode;
	}
	/**
	 * @return the masterVersion
	 */
	@ApiModelProperty
	public Number getMasterVersion() {
		return masterVersion;
	}
	/**
	 * @param masterVersion the masterVersion to set
	 */
	public void setMasterVersion(Number masterVersion) {
		this.masterVersion = masterVersion;
	}
}
