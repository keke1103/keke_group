package com.yuan.myferalpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 登录与注册跳转页面
 * 
 * @author Administrator
 *
 */
public class LoginAndRegister extends Activity {
	Button login;
	Button register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_and_register);
		login = (Button) findViewById(R.id.button_login_and_register_login);
		register = (Button) findViewById(R.id.button_login_and_register_speed_registered);
		register.setOnClickListener(onClickListener);
		login.setOnClickListener(onClickListener);

	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.button_login_and_register_login:
				Intent intent = new Intent(LoginAndRegister.this, LoginAndLogin.class);
				startActivity(intent);
				break;

			case R.id.button_login_and_register_speed_registered:
				Intent intent2 = new Intent(LoginAndRegister.this, EntendPhonrNumber.class);
				startActivity(intent2);
				break;

			default:
				break;
			}
		}
	};
}
