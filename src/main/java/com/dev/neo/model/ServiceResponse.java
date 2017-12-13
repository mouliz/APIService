package com.dev.neo.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel
public class ServiceResponse {

	private Object serviceResponse;
	private String serviceStatus;
	private String serviceError;
	/**
	 * @return the serviceResponse
	 */
	public Object getServiceResponse() {
		return serviceResponse;
	}
	/**
	 * @param serviceResponse the serviceResponse to set
	 */
	public void setServiceResponse(Object serviceResponse) {
		this.serviceResponse = serviceResponse;
	}
	/**
	 * @return the serviceStatus
	 */
	 @ApiModelProperty
	public String getServiceStatus() {
		if(serviceStatus==null)
			return "";
		return serviceStatus;
	}
	/**
	 * @param serviceStatus the serviceStatus to set
	 */
	public void setServiceStatus(String serviceStatus) {
	 
		this.serviceStatus = serviceStatus;
	}
	/**
	 * @return the serviceError
	 */
	 @ApiModelProperty
	public String getServiceError() {
		if(serviceError==null)
			return "";
		return serviceError;
	}
	/**
	 * @param serviceError the serviceError to set
	 */
	public void setServiceError(String serviceError) {
		this.serviceError = serviceError;
	}
	
	 @ApiModelProperty
	public static String gerEmptyObj()
	{
		ServiceResponse srvRes=new ServiceResponse();
		srvRes.serviceError="";
		srvRes.serviceResponse="";
		srvRes.serviceStatus="";
		String result="";
		 
  	  try {
  		  result="";
		} catch (Exception e) {
			// TODO: handle exception
		 e.printStackTrace();
		}
		return result;
	}
	 
	 



	 
	
}
