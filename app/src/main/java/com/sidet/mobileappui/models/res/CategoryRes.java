package com.sidet.mobileappui.models.res;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CategoryRes{

	@SerializedName("data")
	private List<Category> categoryList;

	@SerializedName("message")
	private String message;

	public void setCategoryList(List<Category> categoryList){
		this.categoryList = categoryList;
	}

	public List<Category> getCategoryList(){
		return categoryList;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"CategoryRes{" + 
			"data = '" + categoryList + '\'' +
			",message = '" + message + '\'' + 
			"}";
		}
}