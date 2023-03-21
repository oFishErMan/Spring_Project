package com.CustomSoft.db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
	private String custom_user_nick;
	private String custom_user_email;
	private String custom_user_pswd;

	public LoginDto(String custom_user_name, String custom_user_nick, String custom_user_email,
			String custom_user_pswd, String custom_user_birth, String custom_user_phone, String custom_user_address) {
		super();
		this.custom_user_nick = custom_user_nick;
		this.custom_user_email = custom_user_email;
		this.custom_user_pswd = custom_user_pswd;
	}
	
	

	public String getCustom_user_nick() {
		return custom_user_nick;
	}



	public void setCustom_user_nick(String custom_user_nick) {
		this.custom_user_nick = custom_user_nick;
	}



	public String getCustom_user_email() {
		return custom_user_email;
	}



	public void setCustom_user_email(String custom_user_email) {
		this.custom_user_email = custom_user_email;
	}



	public String getCustom_user_pswd() {
		return custom_user_pswd;
	}



	public void setCustom_user_pswd(String custom_user_pswd) {
		this.custom_user_pswd = custom_user_pswd;
	}



	public LoginDto() {
		super();
	}



	public String viewMember(String custom_user_nick) {
		this.custom_user_nick = custom_user_nick;
		return custom_user_nick;
	}


}
