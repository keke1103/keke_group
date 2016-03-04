package com.yuan.myferalpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
/**
 * 设置新密码界面用于点击忘记密码
 * @author yuan-pc
 *
 */
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SetNewPassword extends Activity {
	ImageView onReturn;//返回上一个界面
	EditText verificationCode;//输入验证码
	EditText newPassword;//新的密码
	TextView toResend;//重新发送
	RelativeLayout layoutTime;//包裹着不可点击的重新发送
	TextView time;//间隔时间
	Button determine;//确定

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_password);
		onReturn = (ImageView) findViewById(R.id.image_new_password_return);
		determine = (Button) findViewById(R.id.button_new_password_determine);
		toResend=(TextView)findViewById(R.id.text_new_password_to_resend);
		
		onReturn.setOnClickListener(onClickListener);
		determine.setOnClickListener(onClickListener);
		toResend.setOnClickListener(onClickListener);
	}
	OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.image_new_password_return:
				finish();
				break;
			case R.id.button_new_password_determine:
				Intent intent=new Intent(SetNewPassword.this,MainActivity.class);
				startActivity(intent);
				finish();
				break;
				
			case R.id.text_new_password_to_resend://点击重新发送，重新获取服务器验证码
				
				break;
			default:
				break;
			}
		}
	};
}
