package com.succ7.toappstore;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/**
	 * 跳转到应用市场列表
	 * 
	 * @param v
	 */
	public void toappstore(View v) {

		if (ToAppStoreUtils.judge(this, ToAppStoreUtils.getIntent(this))) {
			ToAppStoreUtils.start(this);
		} else {
			Toast.makeText(this, "您的手机中无应用市场啦", 0).show();
		}

	}

}
