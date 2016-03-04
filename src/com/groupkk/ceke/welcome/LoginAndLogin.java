package com.groupkk.ceke.welcome;

import com.groupkk.ceke.MainActivity;
import com.groupkk.ceke.R;

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
	Button login;//登录按钮
	EditText phoneAndEmail;//输入手机号或邮箱
	EditText password;//输入密码
	TextView register;//注册按钮
	TextView forgotPassword;//忘记密码

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_login);
		getID();
		onReturn.setOnClickListener(onClickListener);
		login.setOnClickListener(onClickListener);
		forgotPassword.setOnClickListener(onClickListener);
		register.setOnClickListener(onClickListener);
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.image_login_return://返回上一个页面
				finish();
				break;

			case R.id.text_login_register://注册跳转
				Intent intent = new Intent(LoginAndLogin.this, EntendPhonrNumber.class);
				startActivity(intent);
				
				break;

			case R.id.text_login_forgot_password://忘记密码跳转
				Intent intent2 = new Intent(LoginAndLogin.this, SetNewPassword.class);
				startActivity(intent2);
				break;
				
			case R.id.button_login_immediately://登录跳转
				Intent intent3 = new Intent(LoginAndLogin.this, MainActivity.class);
				startActivity(intent3);
				finish();
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
