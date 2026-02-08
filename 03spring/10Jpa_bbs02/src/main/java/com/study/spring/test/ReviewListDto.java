package com.study.spring.test;

public class ReviewListDto {
	private String hCode;
	private String rTitle;
	private String rContent;
	private int rEvalPt;

	public ReviewListDto(String hCode, String rTitle, String rContent, int rEvalPt) {
		this.hCode = hCode;
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.rEvalPt = rEvalPt;
	}

	// Getter
	public String getHCode() {
		return hCode;
	}

	public String getRTitle() {
		return rTitle;
	}

	public String getRContent() {
		return rContent;
	}

	public int getREvalPt() {
		return rEvalPt;
	}

	// Setter (필요하면)
	public void setHCode(String hCode) {
		this.hCode = hCode;
	}

	public void setRTitle(String rTitle) {
		this.rTitle = rTitle;
	}

	public void setRContent(String rContent) {
		this.rContent = rContent;
	}

	public void setREvalPt(int rEvalPt) {
		this.rEvalPt = rEvalPt;
	}
}
