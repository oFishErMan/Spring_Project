package com.CustomSoft.db;

public class PapagoDto {
	private String korean;
	private String chinese;
	private String english;
	public String getKorean() {
		return korean;
	}
	public void setKorean(String korean) {
		this.korean = korean;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public PapagoDto(String korean, String chinese, String english) {
		super();
		this.korean = korean;
		this.chinese = chinese;
		this.english = english;
	}
	public PapagoDto() {
		super();
	}
	
	
}
