package com.groupkk.ceke.adapter;

import com.groupkk.ceke.MoreClassActivity;
import com.groupkk.ceke.R;
import com.groupkk.ceke.view.MainItemView;
import com.groupkk.ceke.view.MainItemView.ClassData;
import com.groupkk.ceke.view.MainItemView.ClassItem;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class TypeViewAdapter extends BaseAdapter {
	MoreClassActivity context;

	public TypeViewAdapter(MoreClassActivity context) {
		this.context = context;
	}

	@Override
	public int getCount() {

		return context.dataList.size();
	}

	@Override
	public Object getItem(int position) {

		return context.dataList.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		MainItemView.ClassItem item;
		ClassData mData = context.dataList.get(position);
		if (convertView == null) {
			convertView = context.getLayoutInflater().inflate(R.layout.main_image_item, null);
			item = new MainItemView.ClassItem(convertView);
			convertView.setTag(item);
		} else {
			item = (ClassItem) convertView.getTag();
		}
		item.setData(mData);
		return convertView;
	}

}
