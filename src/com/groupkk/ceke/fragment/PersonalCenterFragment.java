package com.groupkk.ceke.fragment;

 
import com.groupkk.ceke.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

/**
 * 个人中心的Fragment
 * @author Administrator
 *
 */
public class PersonalCenterFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		LinearLayout linearLayout=new LinearLayout(getActivity());
		LayoutParams layoutParams=new LayoutParams(android.view.ViewGroup.LayoutParams.WRAP_CONTENT,android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
		linearLayout.setLayoutParams(layoutParams);
		View view=inflater.inflate(R.layout.fragment_personal_layout,linearLayout,true);
		return view;
	}

}
