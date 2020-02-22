package com.kh.semi.review.model.vo;

import java.io.Serializable;

public class ReviewScore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7528754388027963302L;
	
	private int one;
	private int two;
	private int three;
	private int four;
	private int five;
	private int total;
	private double score;
	private int fScore;
	
	public ReviewScore() {
		super();
	}

	public ReviewScore(int one, int two, int three, int four, int five, int total, double score, int fScore) {
		super();
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.total = total;
		this.score = score;
		this.fScore = fScore;
	}

	public int getOne() {
		return one;
	}

	public void setOne(int one) {
		this.one = one;
	}

	public int getTwo() {
		return two;
	}

	public void setTwo(int two) {
		this.two = two;
	}

	public int getThree() {
		return three;
	}

	public void setThree(int three) {
		this.three = three;
	}

	public int getFour() {
		return four;
	}

	public void setFour(int four) {
		this.four = four;
	}

	public int getFive() {
		return five;
	}

	public void setFive(int five) {
		this.five = five;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getfScore() {
		return fScore;
	}

	public void setfScore(int fScore) {
		this.fScore = fScore;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ReviewScore [one=" + one + ", two=" + two + ", three=" + three + ", four=" + four + ", five=" + five
				+ ", total=" + total + ", score=" + score + ", fScore=" + fScore + "]";
	}
	
}
