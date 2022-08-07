package com.sidet.mobileappui.models.res;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LoginRes{

	@SerializedName("roles")
	private List<String> roles;

	@SerializedName("id")
	private int id;

	@SerializedName("tokenType")
	private String tokenType;

	@SerializedName("accessToken")
	private String accessToken;

	@SerializedName("email")
	private String email;

	@SerializedName("refreshToken")
	private String refreshToken;

	@SerializedName("username")
	private String username;

	public void setRoles(List<String> roles){
		this.roles = roles;
	}

	public List<String> getRoles(){
		return roles;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTokenType(String tokenType){
		this.tokenType = tokenType;
	}

	public String getTokenType(){
		return tokenType;
	}

	public void setAccessToken(String accessToken){
		this.accessToken = accessToken;
	}

	public String getAccessToken(){
		return accessToken;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setRefreshToken(String refreshToken){
		this.refreshToken = refreshToken;
	}

	public String getRefreshToken(){
		return refreshToken;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"LoginRes{" + 
			"roles = '" + roles + '\'' + 
			",id = '" + id + '\'' + 
			",tokenType = '" + tokenType + '\'' + 
			",accessToken = '" + accessToken + '\'' + 
			",email = '" + email + '\'' + 
			",refreshToken = '" + refreshToken + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}