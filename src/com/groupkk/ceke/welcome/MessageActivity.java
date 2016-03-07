package com.groupkk.ceke.welcome;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.groupkk.ceke.R;
import com.groupkk.ceke.adapter.MessageAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MessageActivity extends Activity {
	ListView listUnread;
	ListView listHaveRead;
	ListView listComplete;
	RadioGroup group;

	RadioButton uButton[];
	View inlud;
	TextView title;
	View toReturn;
	List<Map<String, String>> list;
	MessageAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		findView();
		list = new ArrayList<Map<String, String>>();
		group.setOnCheckedChangeListener(checkedLister);
		changed();
	}

	private OnCheckedChangeListener checkedLister = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			changed();

		}

	};

	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	private void changed() {
		for (int i = 0; i < uButton.length; i++) {
			if (uButton[i].isChecked()) {
				uButton[i].setTextColor(getResources().getColor(R.color.main_orange));
				switch (i) {
				case 0:
					list.clear();
					getDataList("预约未受理");
					adapter = new MessageAdapter(this, list);
					listUnread.setAdapter(adapter);
					listUnread.setVisibility(View.VISIBLE);
					listHaveRead.setVisibility(View.GONE);
					listComplete.setVisibility(View.GONE);
					break;
				case 1:
					list.clear();
					getDataList("预约已受理");
					adapter = new MessageAdapter(this, list);
					listHaveRead.setAdapter(adapter);
					listUnread.setVisibility(View.GONE);
					listHaveRead.setVisibility(View.VISIBLE);
					listComplete.setVisibility(View.GONE);
					break;
				case 2:
					list.clear();
					getDataList("全部预约");
					adapter = new MessageAdapter(this, list);
					listComplete.setAdapter(adapter);
					listUnread.setVisibility(View.GONE);
					listHaveRead.setVisibility(View.GONE);
					listComplete.setVisibility(View.VISIBLE);
					break;

				default:
					break;
				}
			} else {
				uButton[i].setTextColor(getResources().getColor(R.color.other_text_gray));
			}

		}

	}

	@SuppressLint("SimpleDateFormat")
	void getDataList(String str) {

		for (int i = 0; i < 5; i++) {
			Map<String, String> map = new HashMap<String, String>();

			map.put("message", "系统消息：你的" + str + "，请耐心等待");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(new Date());
			map.put("time", time);
			list.add(map);
			//Toast.makeText(getApplicationContext(), "123", Toast.LENGTH_SHORT).show();
		}
	}

	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

		}
	};

	private void findView() {
		inlud = findViewById(R.id.message_include);
		title = (TextView) inlud.findViewById(R.id.title_text);
		toReturn = inlud.findViewById(R.id.title_back);
		listUnread = (ListView) findViewById(R.id.list_view_message_unread);
		listHaveRead = (ListView) findViewById(R.id.list_view_message_have_read);
		listComplete = (ListView) findViewById(R.id.list_view_message_complete);

		group = (RadioGroup) findViewById(R.id.radio_message);
		uButton = new RadioButton[3];
		uButton[0] = (RadioButton) findViewById(R.id.text_message_unread);
		uButton[1] = (RadioButton) findViewById(R.id.text_message_have_read);
		uButton[2] = (RadioButton) findViewById(R.id.text_message_complete);

		toReturn.setVisibility(View.VISIBLE);
		title.setText(getString(R.string.message));

	}
}
