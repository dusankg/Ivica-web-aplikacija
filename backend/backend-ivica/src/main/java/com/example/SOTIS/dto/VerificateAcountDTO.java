package com.example.SOTIS.dto;

public class VerificateAcountDTO {

	private String username;
	private String password;
	private int validationCode;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getValidationCode() {
		return validationCode;
	}
	public void setValidationCode(int validationCode) {
		this.validationCode = validationCode;
	}
	
	
}
