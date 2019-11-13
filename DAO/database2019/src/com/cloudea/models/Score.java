package com.cloudea.models;

public class Score {


	private int rep_id;
	private int tch_id;
	private int score;
	private String comments;
	public Score() {
		super();
	}

	public Score(int tch_id, int rep_id, int score, String comments) {
		super();
		this.tch_id = tch_id;
		this.rep_id = rep_id;
		this.score = score;
		this.comments = comments;
	}

	public int getTch_id() {
		return tch_id;
	}

	public void setTch_id(int tch_id) {
		this.tch_id = tch_id;
	}

	public int getRep_id() {
		return rep_id;
	}

	public void setRep_id(int rep_id) {
		this.rep_id = rep_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
