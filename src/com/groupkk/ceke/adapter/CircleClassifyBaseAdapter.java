package com.groupkk.ceke.adapter;

import java.util.ArrayList;

import com.groupkk.ceke.R;
import com.groupkk.ceke.fragment.CircleClassifyData;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 圈子分类的BaseAdapter
 * 
 * @author Administrator
 *
 */
public class CircleClassifyBaseAdapter extends BaseAdapter {
	ArrayList<CircleClassifyData> list;
	Context context;
	LayoutInflater inflater;

	public CircleClassifyBaseAdapter() {
		// TODO Auto-generated constructor stub
	}

	public CircleClassifyBaseAdapter(ArrayList<CircleClassifyData> list, Context context) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.circle_classify_layout_main, null);
			holder = new ViewHolder();
			holder.textView1 = (TextView) convertView.findViewById(R.id.china_literature_ceremony);
			holder.textView2 = (TextView) convertView.findViewById(R.id.circle_devotion_literature);
			holder.textView3 = (TextView) convertView.findViewById(R.id.circle_creation_user_name);
			holder.textView4 = (TextView) convertView.findViewById(R.id.circle_classify_comment);
			holder.textView5 = (TextView) convertView.findViewById(R.id.circle_last_comment_time);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		CircleClassifyData data = list.get(position);
		holder.textView1.setText(data.getCircle_classify_name());
		holder.textView2.setText(data.getCircle_classify_cultrue());
		holder.textView3.setText(data.getCircle_classify_creation_name());
		holder.textView4.setText(data.getCircle_classify_number());
		holder.textView5.setText(data.getCircle_classify_last_time());
		return convertView;
	}

	class ViewHolder {
		TextView textView1;
		TextView textView2;
		TextView textView3;
		TextView textView4;
		TextView textView5;
	}
}
