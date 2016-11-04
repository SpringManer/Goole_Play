package com.itheima.gooleplay74.globe;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * 自定义application 实现常用是方法
 * 
 * @author Spring
 * 
 */
public class GoolePlayApplicaton extends Application {

	public static Context Context;
	public static int mainThredId;
	public static Handler handler;

	@Override
	public void onCreate() {
		super.onCreate();

		Context = getApplicationContext();

		mainThredId = android.os.Process.myTid();

		handler = new Handler();

	}

	public static Context getContext() {
		return Context;
	}

	public static int getMainThredId() {
		return mainThredId;
	}

	public static Handler getHandler() {
		return handler;
	}

}
