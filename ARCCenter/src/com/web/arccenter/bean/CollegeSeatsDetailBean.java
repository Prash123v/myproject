package com.web.arccenter.bean;

public class CollegeSeatsDetailBean 
{
	private int collegeid;
	private String branch;
	private int availableSeats;
	private int criteria;
	
	
	public int getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(int collegeid) {
		this.collegeid = collegeid;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public int getCriteria() {
		return criteria;
	}
	public void setCriteria(int criteria) {
		this.criteria = criteria;
	}

	
}
