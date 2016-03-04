package com.groupkk.ceke;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

@SuppressLint("ResourceAsColor")
public class MainActivity extends Activity {

	RadioGroup bottomGroup;
	/**
	 * 0:首页 1：分类 2：圈子 3：我
	 */
	RadioButton[] bottomRadio;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		bottomGroup = (RadioGroup) findViewById(R.id.bottom_group);
		bottomGroup.setOnCheckedChangeListener(bottomChange);
		bottomRadio = new RadioButton[4];
		bottomRadio[0] = (RadioButton) findViewById(R.id.radio_main);
		bottomRadio[1] = (RadioButton) findViewById(R.id.radio_type);
		bottomRadio[2] = (RadioButton) findViewById(R.id.radio_friend);
		bottomRadio[3] = (RadioButton) findViewById(R.id.radio_me);

	}

	OnCheckedChangeListener bottomChange = new OnCheckedChangeListener() {

		@SuppressWarnings("deprecation")
		@SuppressLint("ResourceAsColor")
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			for (int i = 0; i < bottomRadio.length; i++) {
				if (bottomRadio[i].isChecked()) {
					bottomRadio[i].setTextColor(getResources().getColor(R.color.main_orange));
				} else {
					bottomRadio[i].setTextColor(getResources().getColor(R.color.other_text_gray));
				}
			}
		}
	};

}
