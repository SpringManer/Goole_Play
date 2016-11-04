package com.itheima.gooleplay74.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;

import com.itheima.gooleplay74.globe.GoolePlayApplicaton;

/**
 * 常用UI工具类
 * 
 * @author Spring
 * 
 */
public class UIUtils {

	public static Context getContext() {

		return GoolePlayApplicaton.Context;

	}

	public static int getMainThredId() {
		return GoolePlayApplicaton.mainThredId;
	}

	public static Handler getHandler() {
		return GoolePlayApplicaton.getHandler();
	}

	// ////////////////加载资源文件////////////////////

	// 获取字符串
	public static String getString(int id) {

		return getContext().getResources().getString(id);
	}

	// 获取字符串数组
	public static String[] getStringArray(int id) {

		return getContext().getResources().getStringArray(id);
	}

	// 获取图片资源
	public static Drawable getDrawable(int id) {

		return getContext().getResources().getDrawable(id);
	}

	// 获取颜色
	public static int getColor(int id) {

		return getContext().getResources().getColor(id);
	}

	// 根据id获取颜色的状态选择器
	public static ColorStateList getColorStateList(int id) {
		return getContext().getResources().getColorStateList(id);
	}

	// 获取尺寸
	public static int getDimen(int id) {

		return getContext().getResources().getDimensionPixelSize(id);// 返回具体像素值
	}

	// ////////////////dp和px转换////////////////////

	// dp = px/像素密度

	// px --> dp
	public static float px2dp(int px) {

		float density = getContext().getResources().getDisplayMetrics().density;

		return px / density;
	}

	// dp --> px
	public static int dip2px(int dp) {

		float density = getContext().getResources().getDisplayMetrics().density;

		return (int) (density * dp + 0.5f);
	}

	// /////////////////加载布局文件//////////////////////////
	public static View inflate(int id) {
		return View.inflate(getContext(), id, null);
	}

	// /////////////////是否运行在主线程//////////////////////////
	public static boolean isRunOnUIThread() {

		int myTid = android.os.Process.myTid();
		if (myTid == getMainThredId()) {

			return true;
		}

		return false;
	}

	// /////////////////运行在主线程//////////////////////////

	public static void runOnUIhread(Runnable r) {

		if (isRunOnUIThread()) {
			// 已经是主线程, 直接运行
			r.run();
		} else {
			// 如果是子线程, 借助handler让其运行在主线程
			getHandler().post(r);

		}

	}
}
