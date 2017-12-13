package com.dev.neo.util;

public class AppConstant {

	public static final String Q_APPDETAILS="SELECT  [ID],[APP_CODE],[OS_NAME],[APP_VERSION],[DB_VERSION],[FORCE_UPDATE] FROM [dbo].[M_APPOS] WHERE [OS_NAME]=? and [APP_CODE]=?";

	public static final String Q_APPDB="SELECT [ID] ,[APPID],[CATEGORY],[MASTERVERSION] FROM [dbo].[M_APPDB] WHERE APPID=?";
	

	public static final String Q_COMMON_MASTER="SELECT [ID] ,[MCATEGORY] ,[MKEY] ,[MKVALUE] ,[VERSION] FROM [M_COMMON] WHERE [MCATEGORY] =?";
	
	public static final String Q_COMMON_DETAILS="SELECT [ID] ,[MCATEGORY] ,[MKEY] ,[MKVALUE] ,[VERSION] FROM [M_COMMON] WHERE [MCATEGORY] =?";


	//Constant
	
	public static final String MASTER_CODE_CITY="CITY=";
	public static final String MASTER_CODE_GOAL="GOAL";
	public static final String MASTER_CODE_ASSET="ASSET";
	
	public static final String MASTER_CATEGORY="MCATEGORY";
	public static final String MASTER_VERSION="MVERSION";
	
	public static final String APPVERSION="";
}
