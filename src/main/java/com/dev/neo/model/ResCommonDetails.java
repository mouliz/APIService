package com.dev.neo.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResCommonDetails {
	
   
	private java.util.List<CommonMaster> reqCommonMaster;

	
	@ApiModelProperty
	public java.util.List<CommonMaster> getReqCommonMaster() {
		return reqCommonMaster;
	}

	public void setReqCommonMaster(java.util.List<CommonMaster> reqCommonMaster) {
		this.reqCommonMaster = reqCommonMaster;
	}



	

}
