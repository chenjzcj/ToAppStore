package com.succ7.toappstore;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

/**
 * Android 跳转应用市场的应用详情页
 * 
 * @author zhongcj 2015-6-29
 * 
 */
public class ToAppStoreUtils {
	/**
	 * 得到跳转到应用市场详情页的intent
	 * 
	 * @param context
	 *            上下文
	 * @return 目标intent
	 */
	public static Intent getIntent(Context context) {
		StringBuilder sb = new StringBuilder().append("market://details?id=");
		String str = context.getPackageName();
		sb.append(str);
		Uri uri = Uri.parse(sb.toString());
		return new Intent("android.intent.action.VIEW", uri);
	}

	/**
	 * 直接跳转不判断是否存在市场应用
	 * 
	 * @param context
	 *            上下文
	 */
	public static void start(Context context) {

		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("market://details?id="
				+ context.getPackageName()));
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}

	/**
	 * 判断当前设备中是否存在应用市场
	 * 
	 * @param context
	 * @param intent
	 * @return 如果存在返回true,不存在返回false
	 */
	public static boolean judge(Context context, Intent intent) {
		List<ResolveInfo> localList = context.getPackageManager()
				.queryIntentActivities(intent,
						PackageManager.GET_INTENT_FILTERS);
		if ((localList != null) && (localList.size() > 0)) {
			return true;
		} else {
			return false;
		}
	}
}
