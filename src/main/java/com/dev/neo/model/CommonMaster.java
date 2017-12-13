package com.dev.neo.model;

import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel
public class CommonMaster {
	
	private String mcategory;
	private String mkey;
	private String mkvalue;


	@ApiModelProperty
	public String getMcategory() {
		return mcategory;
	}
	public void setMcategory(String mcategory) {
		this.mcategory = mcategory;
	}
	
	@ApiModelProperty
	public String getMkey() {
		return mkey;
	}
	public void setMkey(String mkey) {
		this.mkey = mkey;
	}
	
	@ApiModelProperty
	public String getMkvalue() {
		return mkvalue;
	}
	public void setMkvalue(String mkvalue) {
		this.mkvalue = mkvalue;
	}
	
	


	
	

}
