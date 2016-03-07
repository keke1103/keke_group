package com.groupkk.ceke.view;

import com.groupkk.ceke.R;
import com.groupkk.ceke.util.DipTransformation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class TypeItemView {
	Context mContext;
	LayoutInflater inflater;
	View mView;
	TextView title;
	RelativeLayout infoLayout;

	@SuppressLint("InflateParams")
	public TypeItemView(Context context) {
		mContext = context;
		inflater = LayoutInflater.from(context);
		mView = inflater.inflate(R.layout.type_item_layout, null);
		title = (TextView) mView.findViewById(R.id.type_item_title);
		infoLayout = (RelativeLayout) mView.findViewById(R.id.type_item_info);
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
	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	public void setInfo(String[] infos) {
		TextView text;
		Drawable drawable = mContext.getResources().getDrawable(R.drawable.shape_for_type_text);
		LayoutParams params;
		for (int i = 0; i < infos.length; i++) {
			text = new TextView(mContext);
			text.setBackground(drawable);
			text.setGravity(Gravity.CENTER);
			text.setId(i + 1);
			text.setPadding(setDp(15), setDp(3), setDp(15), setDp(3));
			text.setTextColor(mContext.getResources().getColor(R.color.title2_color_black));
			text.setTextSize(13);
			text.setText(infos[i]);
			params = new LayoutParams(-2, -2);
			params.setMargins(0, setDp(6), 0, setDp(6));
			switch (i % 3) {
			case 1:
				params.addRule(RelativeLayout.CENTER_HORIZONTAL);
				break;
			case 2:
				params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
				break;
			}
			params.addRule(RelativeLayout.BELOW, i - 2);
			infoLayout.addView(text, params);
		}
	}

	public View getContentView() {
		return mView;
	}

	private int setDp(float dp) {
		return DipTransformation.dip2px(mContext, dp);
	}

}
