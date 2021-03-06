package com.android.dexshell;

import android.app.Application;
import android.content.Context;

public class DexLoadJni {
	
	static
	{
		String strLibrary = "/data/data/" + Util.mContext.getPackageName() + "/cache/";
		if(Util.getCPUABI().equals("x86"))
		{
			strLibrary += "libDexLoadJniX86.so";
		}
		else if(Util.getCPUABI().equals("mips"))
		{
			strLibrary += "libDexLoadJniMips.so";
		}
		else if(Util.getCPUABI().equals("armeabi-v7a"))
		{
			strLibrary += "libDexLoadJniV7.so";
		}
		else
		{
			strLibrary += "libDexLoadJniArm.so";
		}
		
		System.load(strLibrary);
		
	}
	
	
	static public native void changeClassLoader(Context context, int os_version);
	
	static public native void changeApplication(Context context, String strApplication, int os_version);

}
