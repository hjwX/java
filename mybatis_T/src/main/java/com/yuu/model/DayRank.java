package com.yuu.model;

public class DayRank {
	private int date;
	private long imageId;
	
	
	public DayRank() {}

	public DayRank(int date, long imageId) {
		super();
		this.date = date;
		this.imageId = imageId;
	}

	/**
	 * @return the date
	 */
	public int getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(int date) {
		this.date = date;
	}

	/**
	 * @return the imageId
	 */
	public long getImageId() {
		return imageId;
	}

	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	@Override
	public String toString() {
		return "DayRank [date=" + date + ", imageId=" + imageId + "]";
	}

}
