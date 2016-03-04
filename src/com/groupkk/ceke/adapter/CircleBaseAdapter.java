package com.groupkk.ceke.adapter;

import java.util.ArrayList;

import com.groupkk.ceke.R;
import com.groupkk.ceke.fragment.CircleData;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 圈子listview的baseAdapter
 * @author Administrator
 *
 */
public class CircleBaseAdapter extends BaseAdapter {
    ArrayList<CircleData> list;
    Context context;
    LayoutInflater inflater;
    
    public CircleBaseAdapter() {
		// TODO Auto-generated constructor stub
	}
    
    public CircleBaseAdapter(ArrayList<CircleData> list,Context context) {
		// TODO Auto-generated constructor stub
    	this.list=list;
    	this.context=context;
    	inflater=LayoutInflater.from(context);
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
		if(convertView==null){
			convertView=inflater.inflate(R.layout.circle_layout_main,null);
			holder=new ViewHolder();
			holder.name=(TextView)convertView.findViewById(R.id.circle_name);
			holder.culture=(TextView)convertView.findViewById(R.id.circle_culture);
			holder.number=(TextView)convertView.findViewById(R.id.circle_number);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder)convertView.getTag();
		}
		CircleData data=list.get(position);
		holder.name.setText(data.getCircleName());
		holder.culture.setText(data.getCircleCulture());
		holder.number.setText(data.getPeopleNumber());
		return convertView;
	}
    class ViewHolder{
    	TextView name;
    	TextView culture;
    	TextView number;
    }
}
