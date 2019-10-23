package com.yuu.model;

public class Test_param {
	private long belongId;
	private int param1;
	private int param2;
	private String info;
	private int param3;
	
	public Test_param() {
		
	}
	
	public Test_param(long belongId, int param1, int param2, String info, int param3) {
		this.belongId = belongId;
		this.param1 = param1;
		this.param2 = param2;
		this.info = info;
		this.param3 = param3;
	}

	/**
	 * @return the belongId
	 */
	public long getBelongId() {
		return belongId;
	}

	/**
	 * @param belongId the belongId to set
	 */
	public void setBelongId(long belongId) {
		this.belongId = belongId;
	}

	/**
	 * @return the param1
	 */
	public int getParam1() {
		return param1;
	}

	/**
	 * @param param1 the param1 to set
	 */
	public void setParam1(int param1) {
		this.param1 = param1;
	}

	/**
	 * @return the param2
	 */
	public int getParam2() {
		return param2;
	}

	/**
	 * @param param2 the param2 to set
	 */
	public void setParam2(int param2) {
		this.param2 = param2;
	}

	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @return the param3
	 */
	public int getParam3() {
		return param3;
	}

	/**
	 * @param param3 the param3 to set
	 */
	public void setParam3(int param3) {
		this.param3 = param3;
	}

	@Override
	public String toString() {
		return "Test_param [belongId=" + belongId + ", param1=" + param1 + ", param2=" + param2 + ", info=" + info
				+ ", param3=" + param3 + "]";
	}
	
}	
