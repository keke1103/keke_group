package com.yuan.myferalpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 登陆界面
 * 
 * @author yuan-pc
 *
 */
public class LoginAndLogin extends Activity {
	ImageView onReturn;// 返回上一个
	Button login;
	EditText phoneAndEmail;
	EditText password;
	TextView register;
	TextView forgotPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getID();
		onReturn.setOnClickListener(onClickListener);
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.image_login_return:
				finish();
				break;

			case R.id.text_login_register:
				Intent intent = new Intent(LoginAndLogin.this, MainActivity.class);
				startActivity(intent);
				finish();
				break;

			case R.id.text_login_forgot_password:
				Intent intent2 = new Intent(LoginAndLogin.this, SetNewPassword.class);
				startActivity(intent2);
				break;
			default:
				break;
			}
		}
	};

	public void getID() {
		onReturn = (ImageView) findViewById(R.id.image_login_return);
		login = (Button) findViewById(R.id.button_login_immediately);
		phoneAndEmail = (EditText) findViewById(R.id.edit_login_phone_and_email);
		password = (EditText) findViewById(R.id.edit_login_password);
		register = (TextView) findViewById(R.id.text_login_register);
		forgotPassword = (TextView) findViewById(R.id.text_login_forgot_password);
	}
}
