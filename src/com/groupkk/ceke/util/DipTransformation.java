package com.groupkk.ceke.util;

import android.content.Context;

public class DipTransformation {

	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}
}
