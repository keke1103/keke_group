package com.groupkk.ceke.util;

public class MyApplyRecordData {
	int imageID;// 图片的ID
	String name;// 公司名字
	String chairName;// 讲座名字
	int residueDay;// 剩余天数
	String chairTime;// 讲座时间
	/**
	 * 是否受理-1未受理 是否受理0不受理 是否受理1已经受理
	 */
	int accept;// 是否受理

	public int getImageID() {
		return imageID;
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

	public String getChairName() {
		return chairName;
	}

	public void setChairName(String chairName) {
		this.chairName = chairName;
	}

	public int getResidueDay() {
		return residueDay;
	}

	public void setResidueDay(int residueDay) {
		this.residueDay = residueDay;
	}

	public String getChairTime() {
		return chairTime;
	}

	public void setChairTime(String chairTime) {
		this.chairTime = chairTime;
	}

	/**
	 * 是否受理-1未受理 是否受理0不受理 是否受理1已经受理
	 */
	public int getAccept() {
		return accept;
	}

	/**
	 * 是否受理-1未受理 是否受理0不受理 是否受理1已经受理
	 */
	public void setAccept(int accept) {
		this.accept = accept;
	}

}
