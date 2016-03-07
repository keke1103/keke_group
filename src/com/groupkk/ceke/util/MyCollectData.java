package com.groupkk.ceke.util;

public class MyCollectData {
	int imageID;// 图片ID
	String name;// 兴趣班的名字
	int applyNumber;// 报名人数
	String companyName;// 公司名字

	String yueqi;// 报名的类型
	String grade;// 报名的年级
	int applyTime;// 报名的剩余天数

	public int getImageID() {
		return imageID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getApplyNumber() {
		return applyNumber;
	}

	public void setApplyNumber(int applyNumber) {
		this.applyNumber = applyNumber;
	}

	public String getYueqi() {
		return yueqi;
	}

	public void setYueqi(String yueqi) {
		this.yueqi = yueqi;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(int applyTime) {
		this.applyTime = applyTime;
	}
}
