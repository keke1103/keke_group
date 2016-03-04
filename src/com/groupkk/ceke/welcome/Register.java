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
public class Register extends Activity {
	ImageView toReturn;//返回上一个页面
	EditText username;//输入昵称
	EditText password;//输入密码
	TextView getCode;//获取验证码
	Button immediately;//注册
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		toReturn =(ImageView)findViewById(R.id.image_regidter_return);
		username =(EditText)findViewById(R.id.edit_register_nickname);
		password=(EditText)findViewById(R.id.edit_register_password);
		getCode=(TextView)findViewById(R.id.text_register_get_code);
		immediately=(Button)findViewById(R.id.button_register_immediately);
		
		toReturn.setOnClickListener(onClickListener);
		getCode.setOnClickListener(onClickListener);
		immediately.setOnClickListener(onClickListener);
	}
	OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.image_regidter_return://返回上一个页面
				finish();
				break;

			case R.id.text_register_get_code://获取验证码
				
				break;
				
			case R.id.button_register_immediately://快速注册
				Intent intent=new Intent(Register.this,MainActivity.class);
				startActivity(intent);
				finish();
				break;
			default:
				break;
			}
		}
	};
}
