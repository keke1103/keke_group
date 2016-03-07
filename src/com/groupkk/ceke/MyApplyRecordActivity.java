package com.groupkk.ceke;

import java.util.ArrayList;

import com.groupkk.ceke.adapter.MyApplyRecordBaseAdapter;
import com.groupkk.ceke.util.MyApplyRecordData;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * 我的报名记录
 * 
 * @author 冯灿
 *
 */
public class MyApplyRecordActivity extends Activity {
	ListView listview;
	ArrayList<MyApplyRecordData> list;
	MyApplyRecordBaseAdapter myApplyRecordBaseAdapter;
	RadioGroup group;
	RadioButton uButton[];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_apply_record_main);
		listview = (ListView) findViewById(R.id.my_apply_record_listview);
		findView();
		changed();
		getData();
		myApplyRecordBaseAdapter = new MyApplyRecordBaseAdapter(list, this);
		listview.setAdapter(myApplyRecordBaseAdapter);
	}

	private void findView() {
		group = (RadioGroup) findViewById(R.id.record_group);
		uButton = new RadioButton[3];
		uButton[0] = (RadioButton) findViewById(R.id.record_btn0);
		uButton[1] = (RadioButton) findViewById(R.id.record_btn1);
		uButton[2] = (RadioButton) findViewById(R.id.record_btn2);
		group.setOnCheckedChangeListener(checkedLister);

	}

	public void getData() {
		list = new ArrayList<MyApplyRecordData>();
		for (int i = 0; i < 5; i++) {
			MyApplyRecordData data = new MyApplyRecordData();
			data.setName("上课一二");
			if (i % 2 == 0)
				data.setAccept(1);
			else
				data.setAccept(-1);
			data.setImageID(R.drawable.ic_launcher);
			data.setChairTime("223天");
			data.setChairName("大大中国顾客");
			data.setResidueDay(i);
			list.add(data);
		}
	}

	private OnCheckedChangeListener checkedLister = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			changed();
		}

	};

	private void changed() {
		for (int i = 0; i < uButton.length; i++) {
			if (uButton[i].isChecked()) {
				uButton[i].setTextColor(getResources().getColor(R.color.main_orange));
				switch (i) {
				case 0:

					break;
				case 1:

					break;
				case 2:

					break;

				default:
					break;
				}
			} else {
				uButton[i].setTextColor(getResources().getColor(R.color.other_text_gray));
			}

		}

	}

}
