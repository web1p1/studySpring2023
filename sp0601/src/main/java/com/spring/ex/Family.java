package com.spring.ex;

public class Family {
	
	String papaName;
	String mamiName;
	String brotherName;
	
	public Family(String papaName, String mamiName) {
		// super();
		this.papaName = papaName;
		this.mamiName = mamiName;
	}

	public String getPapaName() {
		return papaName;
	}

	public void setPapaName(String papaName) {
		this.papaName = papaName;
	}

	public String getMamiName() {
		return mamiName;
	}

	public void setMamiName(String mamiName) {
		this.mamiName = mamiName;
	}

	public String getBrotherName() {
		return brotherName;
	}

	public void setBrotherName(String brotherName) {
		this.brotherName = brotherName;
	}
	
	
	
}
