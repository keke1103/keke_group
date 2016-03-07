package com.groupkk.ceke.view;

import com.groupkk.ceke.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by kk0927 on 2016/2/16.
 */
@SuppressLint("ClickableViewAccessibility")
public class Ball extends View {

	public Ball(Context context) {
		super(context);
	}

	public Ball(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public Ball(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	Paint paint = new Paint();
	Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rub_course_build_posts_non_sel);
	Matrix matrix = new Matrix();

	@Override
	protected void onDraw(Canvas canvas) {

		matrix.setScale((float) getWidth() / bitmap.getWidth(), (float) getHeight() / bitmap.getHeight());
		canvas.drawBitmap(bitmap, matrix, paint);

		setParentViewEdge();// 在onDraw的时候调用以免获取不了坐标
		mLeftEdge = getLeft();
		mRightEdge = ((View) getParent()).getWidth() - getWidth();
		mTopEdge = getTop();
		mBottomEdge = ((View) getParent()).getHeight() - getHeight();
		super.onDraw(canvas);
	}

	private void setParentViewEdge() {
		View parentView = (View) getParent();
		int v_s_xy[] = new int[2];
		parentView.getLocationOnScreen(v_s_xy);// 获取父控件的绝对坐标！
		Log.i("ball", "parentView_x:" + v_s_xy[0] + " parentView_y:" + v_s_xy[1]);
		mParentTopEdge = v_s_xy[1];
		mParentLeftEdge = v_s_xy[0];
	}

	int mParentTopEdge;
	int mParentLeftEdge;
	@SuppressWarnings("deprecation")
	GestureDetector mDetector = new GestureDetector(new GestureDetector.OnGestureListener() {
		@Override
		public boolean onDown(MotionEvent e) {
			if (isMoving) {
				stop();
			}
			return true;
		}

		@Override
		public void onShowPress(MotionEvent e) {

		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			return false;
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

			float x = e2.getRawX() - mParentLeftEdge - getWidth() / 2;
			float y = e2.getRawY() - mParentTopEdge - getHeight() / 2;
			Log.i("Ball", "onTouchEvent: x:" + x + "y:" + y);
			if (x >= 0 && x <= mRightEdge) {
				setX(x);
			}
			if (y >= 0 && y <= mBottomEdge) {
				setY(y);
			}
			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {

		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			// setSpeed(velocityX, velocityY);
			// start();
			return false;
		}
	});

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		mDetector.onTouchEvent(event);
		super.onTouchEvent(event);
		return true;

	}

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			changeAngle();
			move();
			if (isMoving) {

				mHandler.postDelayed(mRun, mDelay);
			}
		}

	};

	boolean isMoving;

	private void move() {
		this.setX(getX() + velocityX);
		this.setY(getY() + velocityY);
	}

	float velocityX;
	float velocityY;
	View mBroad;

	private void changeAngle() {
		if (this.getY() <= mTopEdge) {
			velocityY = Math.abs(velocityY);
		} else if (this.getY() >= mBottomEdge) {
			velocityY = -Math.abs(velocityY);
		} else if (this.getX() <= mLeftEdge) {
			velocityX = Math.abs(velocityX);
		} else if (this.getX() >= mRightEdge) {
			velocityX = -Math.abs(velocityX);
		}

	}

	Runnable mRun = new Runnable() {
		@Override
		public void run() {
			mHandler.sendEmptyMessage(1);
		}
	};

	public void start() {
		mHandler.post(mRun);
		isMoving = true;
	}

	public void stop() {
		isMoving = false;
		if (this.getY() <= mTopEdge) {
			this.setY(mTopEdge);
		} else if (this.getY() >= mBottomEdge) {
			this.setY(mBottomEdge);
		} else if (this.getX() <= mLeftEdge) {
			this.setX(mLeftEdge);
		} else if (this.getX() >= mRightEdge) {
			this.setX(mRightEdge);
		}

	}

	int fps = 60;
	int mDelay = 20;

	public boolean isMoving() {
		return isMoving;
	}

	public Bitmap getBitmap() {
		return bitmap;

	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public void setImageResourses(int resourses) {
		bitmap = BitmapFactory.decodeResource(getResources(), resourses);
	}

	public double getAngle() {

		return Math.atan2(velocityY, velocityX);
	}

	/**
	 * 通过绝对速度与角度来设置速度。
	 *
	 * @param angle
	 *            与x轴的角度，顺时针方向为正
	 * @param speed
	 *            绝对速度值，（每秒移动像素点）
	 */
	public void setSpeedByAngle(int angle, float speed) {
		float mSpeed = speed / fps;
		velocityX = (float) Math.cos(angle * Math.PI / 180) * mSpeed;
		velocityY = (float) Math.sin(angle * Math.PI / 180) * mSpeed;
	}

	/**
	 * 设置每秒钟移动的速度，
	 *
	 * @param velocityX
	 *            x轴速度像素点
	 * @param velocityY
	 *            y轴速度像素点！
	 */
	public void setSpeed(float velocityX, float velocityY) {
		this.velocityX = velocityX / fps;
		this.velocityY = velocityY / fps;
	}

	/**
	 * 获取绝对速度！ 如果用带参数的getSpeed，可以获取x,y分别的速度
	 *
	 * @return
	 */
	public float getSpeed() {
		double d = Math.hypot(velocityX, velocityY);
		return (float) (d * fps);
	}

	/**
	 * 获取x,y分别的速度！ velocityX=locat[0]； velocityY=locat[1];
	 * 如果用不带参数的getSpeed，可以获取绝对速度
	 */
	public void getSpeed(float locat[]) {
		if (locat != null && locat.length > 1) {
			locat[0] = velocityX * fps;
			locat[1] = velocityY * fps;
		}
	}

	public int getFPS() {
		return fps;
	}

	public void setFPS(int fps) {
		this.fps = fps;
		mDelay = 1000 / fps;
	}

	/**
	 * 到移动范围！
	 */
	int mLeftEdge;
	/**
	 * 到移动范围！
	 */
	int mRightEdge;
	/**
	 * 到移动范围！
	 */
	int mTopEdge;
	/**
	 * 到移动范围！
	 */
	int mBottomEdge;

	/**
	 * 设置移动范围！
	 */
	public void setMoveEdge(int left, int top, int right, int bottom) {
		mLeftEdge = left;
		mTopEdge = top;
		mRightEdge = right;
		mBottomEdge = bottom;
	}
}
