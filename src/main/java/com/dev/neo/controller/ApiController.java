package com.dev.neo.controller;

import javax.ws.rs.core.MediaType;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.neo.model.CommonDetails;
import com.dev.neo.model.ReqCommonMaster;
import com.dev.neo.model.ReqAppDetails;
import com.dev.neo.model.ReqCompareApp;
import com.dev.neo.model.ResAppDetails;
import com.dev.neo.model.ServiceResponse;
import com.dev.neo.repository.AppRepos;
import com.dev.neo.service.AppService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;


@Api(basePath = "/almapi", value = "ALMAPI", description = "Operations with API", produces = "application/json")
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON)
public class ApiController {

// @Autowired 
// private AppRepos appDAO; 
// 
 @Autowired 
 private AppService appService; 
	
  public ApiController() {
		// TODO Auto-generated constructor stub
		
	}

	
	@ApiOperation(value = "Check Status")
	@RequestMapping(value = "/status", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String home(@PathVariable("id") int id){
	 String  result = "{ \"employees\" : [" +
				"{ \"firstName\":\"John\" , \"lastName\":\"Doe\" }," +
				"{ \"firstName\":\"Anna\" , \"lastName\":\"Smith\" }," +
				"{ \"firstName\":\"Peter\" , \"lastName\":\"Jones\" } ]}";
	   System.out.println(result);
	   return result;
	}
	
	
	
	@ApiOperation(value = "APP Version")
	@RequestMapping(value = "/compare/{id}", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody ServiceResponse compareAPPDetails(@PathVariable("id") int id ,@RequestBody ReqCompareApp requestApp ){
		
		  //Receive APK Details
		   ServiceResponse srvResponse=new ServiceResponse();
		   
		   System.out.println(requestApp.getAppcode());
		   System.out.println(requestApp.getAppcode());
		 
		   try {
			 
			   srvResponse=appService.compareAppDetails(requestApp);
			} catch (Exception e) {
				// TODO: handle exception
				srvResponse.setServiceStatus("Error"+e.getMessage());
				e.printStackTrace();
			}
		
		return srvResponse;
	
	}
	
	@ApiOperation(value = "APP Version")
	@RequestMapping(value = "/apkversion/{id}", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody ServiceResponse getAppVersion(@PathVariable("id") int id ,@RequestBody ReqAppDetails requestApp ){//@RequestBody RequestAppDetails requestApp 
	   String  result = "{ \"employees\" : [" +
				"{ \"firstName\":\"John\" , \"lastName\":\"Doe\" }," +
				"{ \"firstName\":\"Anna\" , \"lastName\":\"Smith\" }," +
				"{ \"firstName\":\"Peter\" , \"lastName\":\"Jones\" } ]}";
	   System.out.println(result);
	 
	   ServiceResponse srvResponse=new ServiceResponse();

	   try {
		   //res= appDAO.getAppConfig(requestApp);
		   srvResponse=appService.getAppConfig(requestApp);
		} catch (Exception e) {
			// TODO: handle exception
			srvResponse.setServiceStatus("Error"+e.getMessage());
			e.printStackTrace();
		}
	  
	    
	   /*
	    * // 	   ResAppDetails res=new ResAppDetails();

	    * RequestAppDetails requestAppDetails=new RequestAppDetails();
   		requestAppDetails.setOsName("ANDROID");
   		requestAppDetails.setAppcode("ALMTOOL");
	   ResAppDetails resAppDetails=new ResAppDetails();
	   resAppDetails.setAppcode("ANDROID");
	   resAppDetails.setOsName("ANDROID");
	   resAppDetails.setVersionNumber(1);
	   srvResponse.setServiceResponse(resAppDetails);
	   */
	   return srvResponse;
	}
	
	
	@ApiOperation(value = "Check Response")
	@RequestMapping(value = "/masterversion/{id}", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	
	public @ResponseBody String getMasterVersion(@PathVariable("id") int id){
	 String  result = "{ \"employees\" : [" +
				"{ \"firstName\":\"John\" , \"lastName\":\"Doe\" }," +
				"{ \"firstName\":\"Anna\" , \"lastName\":\"Smith\" }," +
				"{ \"firstName\":\"Peter\" , \"lastName\":\"Jones\" } ]}";
	   System.out.println(result);
	   return result;
	}
	
	@ApiOperation(value = "Check Response")
	@RequestMapping(value = "/savestaticistic/{id}", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	
	public @ResponseBody String getMasterAppVersion(@PathVariable("id") int id){
	 String  result = "{ \"employees\" : [" +
				"{ \"firstName\":\"John\" , \"lastName\":\"Doe\" }," +
				"{ \"firstName\":\"Anna\" , \"lastName\":\"Smith\" }," +
				"{ \"firstName\":\"Peter\" , \"lastName\":\"Jones\" } ]}";
	   System.out.println(result);
	   return result;
	}
	
	
	
	/*  
	 * 
	 * mouli
	 * 
	 */
	@ApiOperation(value = "Common Version")
	@RequestMapping(value = "/health", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	public @ResponseBody ServiceResponse getCommonVersion( ){

	   ServiceResponse srvResponse=new ServiceResponse();
	   

	   try {
		   srvResponse =appService.getCommonConfig();
		} catch (Exception e) {
			srvResponse.setServiceStatus("Error"+e.getMessage());
			e.printStackTrace();
		}
	   return srvResponse;
	}
	
	/*
	 * 
	 * Get master details
            inpute mastercode
       
        output List Master key -value
	 */
	@ApiOperation(value = "Check Master Details")
	@RequestMapping(value = "/checkmaster/{id}", method = RequestMethod.POST,produces = "application/json")
	public @ResponseBody ServiceResponse getMasterDetails(@PathVariable("id") int id ,@RequestBody ReqCommonMaster reqCommonMaster){
	  
		ServiceResponse srvResponse=new ServiceResponse();
         System.out.println("----------------->>>>>>"+reqCommonMaster.getMcategory());

		 try {
		 
			 srvResponse=appService.getCommonMDetails(reqCommonMaster);
			} catch (Exception e) {
				srvResponse.setServiceStatus("Error"+e.getMessage());
				e.printStackTrace();
			}
		  
	   return srvResponse;
	}
	
}
