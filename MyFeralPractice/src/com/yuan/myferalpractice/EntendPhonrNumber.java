package com.yuan.myferalpractice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 输入手机号界面
 * 
 * @author yuan-pc
 *
 */
public class EntendPhonrNumber extends Activity {
	ImageView toReturn;
	EditText phoneNumber;
	EditText phoneCode;//手机验证码
	TextView getCode;//获取验证码
	Button nextStep;//下一步 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write_phone_number);

	}
}
