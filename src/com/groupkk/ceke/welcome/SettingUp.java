package com.groupkk.ceke.welcome;

import com.groupkk.ceke.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * 设置界面
 * @author Administrator
 *
 */
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingUp extends Activity {

	ImageView toReturn;
	RelativeLayout aboutUs;// 关于我们
	RelativeLayout cache;// 清空缓存
	TextView cacheData;
	Button returnAccount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting_up);
		toReturn = (ImageView) findViewById(R.id.image_setting_up_return);
		aboutUs = (RelativeLayout) findViewById(R.id.layout_setting_up_about_us);
		cache = (RelativeLayout) findViewById(R.id.layout_setting_up_cache);
		cacheData = (TextView) findViewById(R.id.test_setting_up_data);
		returnAccount = (Button) findViewById(R.id.button_setting_up_returnAccount);

		toReturn.setOnClickListener(onClickListener);
		aboutUs.setOnClickListener(onClickListener);
		cache.setOnClickListener(onClickListener);
		returnAccount.setOnClickListener(onClickListener);
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.image_setting_up_return:
				finish();
				break;

			case R.id.layout_setting_up_about_us:

				break;

			case R.id.layout_setting_up_cache:

				break;

			case R.id.button_setting_up_returnAccount:
				Intent intent = new Intent(SettingUp.this, LoginAndRegister.class);
				startActivity(intent);
				finish();
				break;
			default:
				break;
			}
		}
	};
}
