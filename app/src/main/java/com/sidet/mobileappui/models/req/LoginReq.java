package com.sidet.mobileappui.models.req;

import com.google.gson.annotations.SerializedName;

public class LoginReq{

	@SerializedName("password")
	private String password;

	@SerializedName("phone")
	private String phone;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	@Override
 	public String toString(){
		return 
			"LoginReq{" + 
			"password = '" + password + '\'' + 
			",phone = '" + phone + '\'' + 
			"}";
		}
}