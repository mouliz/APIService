package com.dev.neo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.neo.model.CommonDetails;
import com.dev.neo.model.CommonMaster;
import com.dev.neo.model.MasterDetails;
import com.dev.neo.model.ReqAppDetails;
import com.dev.neo.model.ReqCommonMaster;
import com.dev.neo.model.ResAppDetails;
import com.dev.neo.model.ResCommonDetails;
import com.dev.neo.model.ServiceResponse;
import com.dev.neo.util.AppConstant; 

@Repository
public class AppRepos {

	@Autowired
	private DataSource  datasource;
	//private JdbcTemplate jdbcTemplate;

	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.datasource=dataSource;
    }

	
	
	/**
	 * Retrieve APK version basis OS Version and PAK Version
	 * @param requestAppDetails
	 * @return
	 */
	public ResAppDetails getAppConfig(ReqAppDetails requestAppDetails) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        System.out.println("DAO Implementation get called");
        ResAppDetails res = new ResAppDetails();
		try {
			 con=datasource.getConnection();
			 ps = con.prepareStatement(AppConstant.Q_APPDETAILS);
			 ps.setString(1,requestAppDetails.getOsName());
			 ps.setString(2,requestAppDetails.getAppcode());
	    	System.out.println("getAppcode="+requestAppDetails.getAppcode());
        	System.out.println("getAppVersion="+requestAppDetails.getOsName());
		 
	         rs = ps.executeQuery();
	         int appId=0;
	        
	         
	         while (rs.next()) {
	        	 	System.out.println("Result Obtained"); 
	             	appId=rs.getInt("ID");
	             	res.setAppcode(rs.getString("APP_CODE"));
	            	res.setOsName(rs.getString("OS_NAME"));
	            	res.setAppVersion(rs.getInt("APP_VERSION"));
	            	res.setDbVersion(rs.getString("DB_VERSION"));
	            	System.out.println("getAppcode="+res.getAppcode());
	            	System.out.println("getAppVersion="+res.getAppVersion());
	         }
	         
	         //Get Master Version
	         List masterList=new ArrayList<>();
	         
	         if(appId!=0)
	        	 masterList= getMasterVersion(appId); 
	         
	             res.setMasterDetails(masterList);
			}
			catch(SQLException e){
	            e.printStackTrace();
	        }finally{
			            try {
			                rs.close();
			                ps.close();
			                con.close();
			            } catch (SQLException e) {
			                e.printStackTrace();
			                
			                throw e;
			            }
	        }
		return res;
	}

	/**
	 * Get master version of the data
	 * @param appId
	 * @return
	 */
	
	public List<Map<String, String>> getMasterVersion(int appId ) throws Exception{
		// TODO Auto-generated method stub
		
		List result=new ArrayList<>();
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
       MasterDetails masterDetails=null;
		try {
			 con=datasource.getConnection();
			 ps = con.prepareStatement(AppConstant.Q_APPDB);
			 ps.setInt(1, appId);
			 rs= ps.executeQuery();
			 while (rs.next()) {
				 masterDetails=new MasterDetails();
				 masterDetails.setMasterCode(rs.getString("CATEGORY"));
				 masterDetails.setMasterVersion(rs.getInt("MASTERVERSION"));

				// mapObj.put("CATEGORY", rs.getString("CATEGORY"));
				// mapObj.put("MASTERVERSION", rs.getString("MASTERVERSION"));
				result.add(masterDetails);
			}
			 
		}
		catch(SQLException e){
            e.printStackTrace();
        }finally{
		            try {
		                rs.close();
		                ps.close();
		                con.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		                
		                throw e;
		            }
        }
		
		
		
		return result;
	}

	
	
	public ServiceResponse getCommonConfig() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 

     ServiceResponse comm = new ServiceResponse();
     CommonDetails commn= new CommonDetails();
		try {
			 con=datasource.getConnection();
			 ps = con.prepareStatement(AppConstant.Q_COMMON_DETAILS);
		//	 ps.setBoolean(1, commonDetails.isIsup());
		//	 ps.setString(1,commonDetails.getStatus());
			 ps.setString(1, "HEALTH");
	    	//System.out.println("getAppcode="+commonDetails.getStatus());
		 
	         rs = ps.executeQuery();
	         String mkvalue = null;
	        
	         
	         while (rs.next()) {
	        	 	 System.out.println("Result Obtained"); 
	             	 mkvalue=rs.getString("MKVALUE");
                     commn.setIsup(rs.getBoolean("MKVALUE"));
                     commn.setStatus(rs.getString("MCATEGORY"));

	         }
	         
	         
	         if(mkvalue.equals("TRUE"))System.out.println("asdf");
	         
			}
		
			catch(SQLException e){
	            e.printStackTrace();
	        }finally{
			            try {
			                rs.close();
			                ps.close();
			                con.close();
			            } catch (SQLException e) {
			                e.printStackTrace();
			                
			                throw e;
			            }
	        }
		return comm;
	}
	
	
	
	
	public List<ResCommonDetails>  getCommonMDetails(ReqCommonMaster req) throws Exception {
		
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        
        System.out.println("DAO Implementation get called");
        List  result=new ArrayList<>();
        List<ResCommonDetails> list= new ArrayList<ResCommonDetails>();
        CommonMaster common = new CommonMaster();
        ResCommonDetails resposne= new ResCommonDetails();
        
		try {
			 con=datasource.getConnection();
			 ps = con.prepareStatement(AppConstant.Q_COMMON_DETAILS);
			 ps.setString(1,req.getMcategory());
	         rs = ps.executeQuery();
	         while (rs.next()) {
                     
	        	 common.setMcategory(rs.getString("MCATEGORY"));
	        	 common.setMkey(rs.getString("MKEY"));
	        	 common.setMkvalue(rs.getString("MKVALUE"));
	             System.out.println(rs.getString("MKVALUE"));
               

	              result.add(common);
	          

	         }

			}
			catch(SQLException e){
	            e.printStackTrace();
	        }finally{
			            try {
			                rs.close();
			                ps.close();
			                con.close();
			            } catch (SQLException e) {
			                e.printStackTrace();
			                
			                throw e;
			            }
	        }
		return result;
	}
	


	
}
