package com.dev.neo.model;

import java.util.ArrayList;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


@ApiModel
public class ResCompareApp {

	List<MasterDetails> masterDetails;

	/**
	 * @return the masterDetails
	 */
	@ApiModelProperty
	public List<MasterDetails> getMasterDetails() {
		 if(masterDetails==null)
			 return new ArrayList<>();
		return masterDetails;
	}

	/**
	 * @param masterDetails the masterDetails to set
	 */
	public void setMasterDetails(List<MasterDetails> masterDetails) {
		this.masterDetails = masterDetails;
	}
	
	
}
