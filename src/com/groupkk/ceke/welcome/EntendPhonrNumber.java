package com.groupkk.ceke.welcome;

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
 * 输入手机号界面
 * 
 * @author yuan-pc
 *
 */
public class EntendPhonrNumber extends Activity {
	ImageView toReturn;
	EditText phoneNumber;
	EditText phoneCode;// 手机验证码
	TextView getCode;// 获取验证码
	Button nextStep;// 下一步
	TextView ckServer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write_phone_number);
		toReturn = (ImageView) findViewById(R.id.image_write_phone_return);
		nextStep = (Button) findViewById(R.id.button_write_phont_next_step);
		ckServer = (TextView) findViewById(R.id.text_write_phone_service_terms);
		getCode = (TextView) findViewById(R.id.text_write_phont_get_code);

		toReturn.setOnClickListener(clickListener);
		nextStep.setOnClickListener(clickListener);
		ckServer.setOnClickListener(clickListener);
		getCode.setOnClickListener(clickListener);
	}

	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.image_write_phone_return:// 返回上一个页面
				finish();
				break;

			case R.id.button_write_phont_next_step:// 进行下一步的按钮
				Intent intent = new Intent(EntendPhonrNumber.this, Register.class);
				startActivity(intent);
				break;

			case R.id.text_write_phone_service_terms:// 蹭课服务条款
				finish();
				break;

			case R.id.text_write_phont_get_code:// 获取验证码

				break;
			default:
				break;
			}
		}
	};
}
