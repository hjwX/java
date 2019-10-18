package com.yuu.model;

public class Pjxxas_ReloadItems {
	private String Name;
	private String UpdateTime;
	private String Arg;
	private String Description;

	public Pjxxas_ReloadItems(String name, String updateTime) {
		super();
		Name = name;
		UpdateTime = updateTime;
	}
	

	public Pjxxas_ReloadItems(String name, String updateTime, String arg, String description) {
		Name = name;
		UpdateTime = updateTime;
		Arg = arg;
		Description = description;
	}
	




	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return UpdateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.UpdateTime = updateTime;
	}

	/**
	 * @return the arg
	 */
	public String getArg() {
		return Arg;
	}

	/**
	 * @param arg the arg to set
	 */
	public void setArg(String arg) {
		Arg = arg;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	
	@Override
	public String toString() {
		return "Pjxxas_ReloadItems [Name=" + Name + ", UpdateTime=" + UpdateTime + ", Arg=" + Arg + ", Description="
				+ Description + "]";
	}
}
