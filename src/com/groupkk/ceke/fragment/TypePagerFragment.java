package com.groupkk.ceke.fragment;

import com.groupkk.ceke.R;
import com.groupkk.ceke.view.TypeItemView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class TypePagerFragment extends Fragment {
	View mView;
	LinearLayout main_layout;
	RadioGroup type_group;
	RadioButton type_btns[];
	View type_btn_bottom[];

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		LinearLayout mLa = new LinearLayout(getActivity());
		mLa.setLayoutParams(new LayoutParams(-1, -1));
		mView = inflater.inflate(R.layout.fragment_typepager, mLa);
		initView();
		return mView;
	}

	private void initView() {
		main_layout = (LinearLayout) mView.findViewById(R.id.type_main_layout);
		type_group = (RadioGroup) mView.findViewById(R.id.type_radiogroup_group);
		type_btns = new RadioButton[2];
		type_btn_bottom = new View[2];
		type_btns[0] = (RadioButton) mView.findViewById(R.id.type_radio_class);
		type_btns[1] = (RadioButton) mView.findViewById(R.id.type_radio_jigou);
		type_btn_bottom[0] = mView.findViewById(R.id.class_btn_bottom);
		type_btn_bottom[1] = mView.findViewById(R.id.jigou_btn_bottom);

		type_group.setOnCheckedChangeListener(groupChange);
		changeClassType();

		setLayoutData();
		setLayoutData();
		setLayoutData();

	}

	OnCheckedChangeListener groupChange = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {

			changeClassType();
		}
	};

	private void setLayoutData() {
		TypeItemView item = new TypeItemView(getActivity());
		item.setTitle(getString(R.string.musicclass));
		String[] infos = new String[] { "钢琴1", "打击乐1", "弦乐器1", "钢琴2", "打击乐2", "弦乐器2", "钢琴3", "打击乐3" };
		item.setInfo(infos);

		main_layout.addView(item.getContentView());
	}

	@SuppressWarnings("deprecation")
	private void changeClassType() {
		for (int i = 0; i < type_btns.length; i++) {
			if (type_btns[i].isChecked()) {
				type_btns[i].setTextColor(getResources().getColor(R.color.main_orange));
				type_btn_bottom[i].setVisibility(View.VISIBLE);
			} else {
				type_btns[i].setTextColor(getResources().getColor(R.color.title2_color_black));
				type_btn_bottom[i].setVisibility(View.INVISIBLE);
			}
		}
	}
}
