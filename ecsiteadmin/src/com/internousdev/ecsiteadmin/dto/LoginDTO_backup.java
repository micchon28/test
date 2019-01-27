package com.internousdev.ecsiteadmin.dto;

public class LoginDTO_backup {
	private String loginId;
	private String loginPassword;
	private String userName;
	private String adminFlg;
	private Boolean loginFlg=false;

	public String getLoginId(){
		return loginId;
	}

	public void setLoginId(String loginId){
		this.loginId=loginId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName=userName;
	}

	public String getAdminFlg() {
		return adminFlg;
	}

	public void setAdminFlg(String adminFlg) {
		this.adminFlg = adminFlg;
	}

	public boolean getLoginFlg(){
		return loginFlg;
	}

	public void setLoginFlg(Boolean loginFlg){
		this.loginFlg=loginFlg;
	}

}
