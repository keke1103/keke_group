package com.groupkk.ceke.view;

import com.groupkk.ceke.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainItemView {

	Context mContext;
	LayoutInflater inflater;
	View mView;
	View flag;
	TextView title;
	View more;
	LinearLayout itemLayouts[];
	ClassItem items[];

	@SuppressLint("InflateParams")
	public MainItemView(Context context) {
		mContext = context;
		inflater = LayoutInflater.from(context);
		mView = inflater.inflate(R.layout.main_item_layout, null);
		flag = mView.findViewById(R.id.title_flag);
		title = (TextView) mView.findViewById(R.id.title_type);
		more = mView.findViewById(R.id.title_more);
		itemLayouts = new LinearLayout[2];
		itemLayouts[0] = (LinearLayout) mView.findViewById(R.id.item_layout1);
		itemLayouts[1] = (LinearLayout) mView.findViewById(R.id.item_layout2);
	}

	/**
	 * 获取初始的view视图
	 * 
	 * @return view视图
	 */
	public View getContentView() {
		return mView;
	}

	/**
	 * 设置标题左边标签的颜色
	 * 
	 * @param color
	 */
	public void setLeftFlagColor(int color) {
		flag.setBackgroundColor(color);
	}

	/**
	 * 设置课程类型
	 * 
	 * @param title
	 */
	public void setTitleType(String title) {
		this.title.setText(title);
	}

	/**
	 * 设置更多课程按钮的点击事件
	 * 
	 * @param l
	 */
	public void setMoreClickListener(OnClickListener l) {
		more.setOnClickListener(l);
	}

	/**
	 * 设置课程内容视图组数据。根据数据自动生成布局
	 * 
	 * @param datas
	 *            课程数据封装类
	 */
	@SuppressLint("InflateParams")
	public void setClassData(ClassData[] datas) {
		items = new ClassItem[datas.length];
		for (int i = 0; i < items.length; i++) {
			View v = inflater.inflate(R.layout.main_image_item, null);
			LayoutParams params = new LayoutParams(0, -2, 1);
			if (i % 2 == 0) {
				params.setMargins(0, 0, 10, 0);
			} else {
				params.setMargins(10, 0, 0, 0);
			}
			v.setLayoutParams(params);
			if (i > 3) // 只允许最多四组数据
				break;
			if (i < 2)
				itemLayouts[0].addView(v);
			else
				itemLayouts[1].addView(v);

			items[i] = new ClassItem(v);
			items[i].setData(datas[i]);
		}
	}

	private static class ClassItem {
		ImageView class_image;
		TextView class_title;
		TextView class_sign_up_count;
		TextView class_company;
		TextView class_type;
		TextView class_leave;
		View class_end_layout;
		TextView class_remaining_day;

		public ClassItem(View c) {
			class_image = (ImageView) c.findViewById(R.id.item_image);
			class_title = (TextView) c.findViewById(R.id.item_title);
			class_sign_up_count = (TextView) c.findViewById(R.id.item_sing_up_count);
			class_company = (TextView) c.findViewById(R.id.item_company);
			class_type = (TextView) c.findViewById(R.id.item_class_type);
			class_leave = (TextView) c.findViewById(R.id.item_class_leave);
			class_end_layout = c.findViewById(R.id.item_end_layout);
			class_remaining_day = (TextView) c.findViewById(R.id.item_remaining_day);
		}

		void setData(Bitmap b, String title, int sign_c, String company, String type, String leave, int remaining) {
			class_image.setImageBitmap(b);
			class_title.setText(title);
			class_sign_up_count.setText(String.format("已报名\t%d\t人", sign_c));
			class_company.setText(company);
			class_type.setText(type);
			class_leave.setText(leave);
			class_remaining_day.setText("" + remaining);
			if (remaining < 1) {
				class_end_layout.setVisibility(View.GONE);
			}
		}

		void setData(ClassData data) {
			setData(data.b, data.title, data.sign_up_count, data.company, data.type, data.leave, data.remaining_day);
		}
	}

	/**
	 * 这是首页课程数据的一个封装类 包含
	 * 
	 * @param b
	 *            课程图片
	 * @param title
	 *            课程名称
	 * @param sign_up_count
	 *            报名人数
	 * @param company
	 *            公司名称
	 * @param type
	 *            课程类型 如 乐器
	 * @param leave
	 *            学历 如小学
	 * @param remaining_day
	 *            剩余天数
	 * 
	 * @author kk0927
	 *
	 */
	public static class ClassData {
		Bitmap b;
		String title;
		int sign_up_count;
		String company;
		String type;
		String leave;
		int remaining_day;

		public ClassData() {

		}

		/**
		 * 
		 * @param b
		 *            课程图片
		 * @param title
		 *            课程名称
		 * @param sign_up_count
		 *            报名人数
		 * @param company
		 *            公司名称
		 * @param type
		 *            课程类型 如 乐器
		 * @param leave
		 *            学历 如小学
		 * @param remaining_day
		 *            剩余天数
		 */
		public ClassData(Bitmap b, String title, int sign_up_count, String company, String type, String leave,
				int remaining_day) {
			this.b = b;
			this.title = title;
			this.sign_up_count = sign_up_count;
			this.company = company;
			this.type = type;
			this.leave = leave;
			this.remaining_day = remaining_day;
		}

		public Bitmap getClassImage() {
			return b;
		}

		public void setClassImage(Bitmap b) {
			this.b = b;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getSign_up_count() {
			return sign_up_count;
		}

		public void setSign_up_count(int sign_up_count) {
			this.sign_up_count = sign_up_count;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getLeave() {
			return leave;
		}

		public void setLeave(String leave) {
			this.leave = leave;
		}

		public int getRemaining_day() {
			return remaining_day;
		}

		public void setRemaining_day(int remaining_day) {
			this.remaining_day = remaining_day;
		}

	}

}
