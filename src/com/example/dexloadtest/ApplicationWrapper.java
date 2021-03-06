package com.example.dexloadtest;

import dalvik.system.DexClassLoader;
import android.app.Application;
import android.content.res.Configuration;

public class ApplicationWrapper extends Application {

	public static String FirstApplication;
	public static Application realApplication = null;
	private DexClassLoader cl;

	static
	{
		FirstApplication = "com.example.dexloadtest.FirstApplication";
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		if(realApplication != null)
		{
			realApplication.onConfigurationChanged(newConfig);
		}
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		//创建RealApplication
		if(Util.getCustomClassLoader() == null)
		{
			Util.runAll(this);
		}
		String str = FirstApplication;
		this.cl = (DexClassLoader)Util.getCustomClassLoader();
//		realApplication = (Application)getClassLoader().loadClass(str).newInstance();
		if (realApplication != null)
	      {
//	        localACall = ACall.getACall();
//	        localACall.set2(this, realApplication, this.cl, getBaseContext());
//	        localACall.at1(realApplication, getBaseContext());
	      }
		
		
	}
	
	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
		if(realApplication != null)
		{
			realApplication.onLowMemory();
		}
	}
	
	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
		if(realApplication != null)
		{
			realApplication.onTerminate();
		}
	}
	
	@Override
	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub
		super.onTrimMemory(level);
		if(realApplication != null)
		{
			realApplication.onTrimMemory(level);
		}
	}
}
