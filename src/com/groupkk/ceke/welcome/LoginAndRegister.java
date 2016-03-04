package com.groupkk.ceke.welcome;

import com.groupkk.ceke.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 登录与注册跳转页面
 * 
 * @author Administrator
 *
 */
public class LoginAndRegister extends Activity {
	Button login;
	Button register;
	ImageView toReturn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_and_register);
		login = (Button) findViewById(R.id.button_login_and_register_login_and);
		register = (Button) findViewById(R.id.button_login_and_register_speed_registered);
		toReturn = (ImageView) findViewById(R.id.image_login_and_register_return);

		register.setOnClickListener(onClickListener);
		login.setOnClickListener(onClickListener);
		toReturn.setOnClickListener(onClickListener);
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.button_login_and_register_login_and:
				Intent intent = new Intent(LoginAndRegister.this, LoginAndLogin.class);
				startActivity(intent);
				break;

			case R.id.button_login_and_register_speed_registered:
				Intent intent2 = new Intent(LoginAndRegister.this, EntendPhonrNumber.class);
				startActivity(intent2);
				break;

			case R.id.image_login_and_register_return:
				finish();
				break;
			default:
				break;
			}
		}
	};
}
