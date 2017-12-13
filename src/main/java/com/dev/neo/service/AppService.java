package com.dev.neo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.neo.model.CommonDetails;
import com.dev.neo.model.CommonMaster;
import com.dev.neo.model.MasterDetails;
import com.dev.neo.model.ReqAppDetails;
import com.dev.neo.model.ReqCommonMaster;
import com.dev.neo.model.ReqCompareApp;
import com.dev.neo.model.ResAppDetails;
import com.dev.neo.model.ResCommonDetails;
import com.dev.neo.model.ResCompareApp;
import com.dev.neo.model.ServiceResponse;
import com.dev.neo.repository.AppRepos;
import com.dev.neo.util.AppConstant;

import scala.collection.immutable.HashMap;

@Service
public class AppService {

	private AppRepos appRepositry;
	
	@Autowired
	public void setAppReposity(AppRepos appRepositry)
	{
		this.appRepositry=appRepositry;
		
	}
	
	/**
	 * Get Apk details
	 * @param reqAppDetails
	 * @throws Exception
	 */
	
	public ServiceResponse getAppConfig(ReqAppDetails reqAppDetails) throws Exception
	{
		ResAppDetails resAppDetails=null;
		ServiceResponse srvResponse=new ServiceResponse();
		srvResponse.setServiceStatus("Success");
		   
		try 
		{
			resAppDetails=appRepositry.getAppConfig(reqAppDetails);
            srvResponse.setServiceResponse(resAppDetails);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			srvResponse.setServiceError("ERROR :"+e.getMessage());
			srvResponse.setServiceResponse(null);
			throw e;
		}
		return srvResponse;
	}
	
	/***
	 * 
	 * @param reqAppDetails
	 * @throws Exception
	 */
	public ServiceResponse compareAppDetails(ReqCompareApp reqCompareApp) throws Exception
	{
		ResAppDetails resAppDetails=null;
		ReqAppDetails reqAppDetails=null;
		ResCompareApp resCompareApp=null;
		
		Map<String,String> resultMap=null;
		List masterList=new ArrayList<>();
		
		
		ServiceResponse srvResponse=new ServiceResponse();
		srvResponse.setServiceStatus("Success");
		try 
		{
			reqAppDetails=new ReqAppDetails();
			
			reqAppDetails.setAppcode(reqCompareApp.getAppcode());
			reqAppDetails.setOsName(reqCompareApp.getOsName());
			
			
			resAppDetails=appRepositry.getAppConfig(reqAppDetails);
			
			resultMap=new java.util.HashMap<>();
			resCompareApp=new ResCompareApp();
			
			//Compare App version
			if(reqCompareApp.getAppVersion().doubleValue()<resAppDetails.getAppVersion().doubleValue())
			{
				//resultMap.put(AppConstant.APPVERSION, resAppDetails.getAppVersion()+"");
				MasterDetails appObj=new MasterDetails();
				appObj.setMasterCode("APP");
				//APPFORCEUPDATE
				appObj.setMasterVersion(resAppDetails.getAppVersion());
				
				masterList.add(appObj);
				
				resCompareApp.setMasterDetails(masterList);
				
				srvResponse.setServiceResponse(resCompareApp);
				return srvResponse;
			}
		     
			//Compare Master version
			
			for(int i=0;i<reqCompareApp.getMasterDetails().size();i++)
			{
					MasterDetails appObj=reqCompareApp.getMasterDetails().get(i); 
					for(int j=0;j<resAppDetails.getMasterDetails().size();j++)
					{
						MasterDetails serviceObj=resAppDetails.getMasterDetails().get(j); 
				    
				        if(!appObj.getMasterCode().equals(serviceObj.getMasterCode()))
				        	continue;
				        
				        if(appObj.getMasterVersion().doubleValue()<serviceObj.getMasterVersion().doubleValue())
				        {
				        	masterList.add(serviceObj);
				        	break;
				        }
					}
			}
			resCompareApp.setMasterDetails(masterList);
			srvResponse.setServiceResponse(resCompareApp); 
			
		} catch (Exception e) {
			// TODO: handle exception
			srvResponse.setServiceError("ERROR :"+e.getMessage());
			srvResponse.setServiceResponse(null);
			throw e;
		}
		return srvResponse;
		
	}


	
	
	public ServiceResponse getCommonConfig() throws Exception
	{
		
		ServiceResponse srvResponse=new ServiceResponse();
		srvResponse.setServiceStatus("Success");
		   
		try 
		{
			srvResponse=appRepositry.getCommonConfig();
            srvResponse.setServiceResponse(srvResponse);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			srvResponse.setServiceError("ERROR :"+e.getMessage());
			srvResponse.setServiceResponse(null);
			throw e;
		}
		return srvResponse;
	}
	
	/*
	 * Master Details
	 * 
	 * 
	 */
	
	public ServiceResponse getCommonMDetails(ReqCommonMaster reqcommonMaster) throws Exception
	{
		
		List<ResCommonDetails> resp= new ArrayList<>();
		ResCommonDetails ress=null;
		CommonMaster commonMaster=null;
		ServiceResponse srvResponse=new ServiceResponse();
		srvResponse.setServiceStatus("Success");
		   
		try 
		{
			resp=appRepositry.getCommonMDetails(reqcommonMaster);
            srvResponse.setServiceResponse(resp);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			srvResponse.setServiceError("ERROR :"+e.getMessage());
			srvResponse.setServiceResponse(null);
			throw e;
		}
		return srvResponse;
	}
}
