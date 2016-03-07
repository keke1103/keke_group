package com.groupkk.ceke.view;

import com.groupkk.ceke.R;
import com.groupkk.ceke.util.DipTransformation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class JiGouTypeItemView {
	Context mContext;
	LayoutInflater inflater;
	View mView;
	TextView title;
	LinearLayout infoLayout1;
	LinearLayout infoLayout2;

	@SuppressLint("InflateParams")
	public JiGouTypeItemView(Context context) {
		mContext = context;
		inflater = LayoutInflater.from(context);
		mView = inflater.inflate(R.layout.jigou_type_item_layout, null);
		title = (TextView) mView.findViewById(R.id.jigou_title_type);
		infoLayout1 = (LinearLayout) mView.findViewById(R.id.jigou_item_layout1);
		infoLayout2 = (LinearLayout) mView.findViewById(R.id.jigou_item_layout2);
	}

	/**
	 * 设置类型名
	 * 
	 * @param ti
	 */
	public void setTitle(String ti) {
		title.setText(ti);
	}

	/**
	 * 设置相应课程类型的内容！
	 * 
	 * @param infos
	 */
	@SuppressLint({ "NewApi", "InflateParams" })
	public void setInfo(String[] infos, Bitmap[] bitmap) {

		android.widget.LinearLayout.LayoutParams params = new android.widget.LinearLayout.LayoutParams(0, -2, 1);
		View v;
		for (int i = 0; i < infos.length; i++) {
			v = LayoutInflater.from(mContext).inflate(R.layout.jitou_item_layout, null);
			v.setLayoutParams(params);
			ImageView image = (ImageView) v.findViewById(R.id.jigou_logo);
			TextView text = (TextView) v.findViewById(R.id.jigou_name);
			image.setImageBitmap(bitmap[i]);
			text.setText(infos[i]);
			if (i < 2)
				infoLayout1.addView(v);
			else
				infoLayout2.addView(v);
			if (i == 3)
				break;
		}
	}

	public View getContentView() {
		return mView;
	}

	private int setDp(float dp) {
		return DipTransformation.dip2px(mContext, dp);
	}

}
