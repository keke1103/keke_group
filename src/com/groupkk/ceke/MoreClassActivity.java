package com.groupkk.ceke;

import java.util.ArrayList;
import java.util.List;

import com.groupkk.ceke.adapter.TypeViewAdapter;
import com.groupkk.ceke.view.MainItemView;
import com.groupkk.ceke.view.MainItemView.ClassData;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MoreClassActivity extends Activity {
	View back;
	TextView title;
	RadioGroup typeGroup;
	RadioButton typeBtns[];

	GridView typeGridView;
	TypeViewAdapter adapter;
	public List<ClassData> dataList;

	private OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_back:
				finish();
				break;

			default:
				break;
			}

		}
	};

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_more_class);
		initView();
		back.setOnClickListener(click);

	}

	private void initView() {
		back = findViewById(R.id.title_back);
		back.setVisibility(View.VISIBLE);
		// title 的文字由跳转传来
		title = (TextView) findViewById(R.id.title_text);
		title.setText("音乐类");

		typeGroup = (RadioGroup) findViewById(R.id.class_type_group);
		typeBtns = new RadioButton[5];
		typeGridView = (GridView) findViewById(R.id.type_gridView);
		typeBtns[0] = (RadioButton) findViewById(R.id.type0);
		typeBtns[1] = (RadioButton) findViewById(R.id.type1);
		typeBtns[2] = (RadioButton) findViewById(R.id.type2);
		typeBtns[3] = (RadioButton) findViewById(R.id.type3);
		typeBtns[4] = (RadioButton) findViewById(R.id.type4);
		changeType();
		typeGroup.setOnCheckedChangeListener(typeChange);
		/**
		 * 模拟添加数据
		 */
		dataList = new ArrayList<MainItemView.ClassData>();
		ClassData mData = new ClassData(null, getString(R.string.erhu), 2, getString(R.string.company), "乐器", "小学", 5);
		for (int i = 0; i < 15; i++) {
			dataList.add(mData);
		}
		adapter = new TypeViewAdapter(this);
		typeGridView.setAdapter(adapter);

	}

	@SuppressWarnings("deprecation")
	private void changeType() {
		for (RadioButton type : typeBtns) {
			if (type.isChecked()) {
				type.setTextColor(getResources().getColor(R.color.main_orange));
			} else {
				type.setTextColor(getResources().getColor(R.color.main_text_gray));
			}
		}

	}

	private OnCheckedChangeListener typeChange = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {

			changeType();
		}

	};
}
