package com.team1.webservice.jsonbean;

import org.codehaus.jackson.annotate.JsonProperty;

public class DepositBean {
	@JsonProperty("username")
	private String username;
	
	@JsonProperty("cash")
	private String cash;

	public String getUsername() {
		return username;
	}

	public String getCash() {
		return cash;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setCash(String cash) {
		this.cash = cash;
	}
	
	public boolean isValidInput() {
		if (   username == null || username.length() == 0
			|| cash == null || cash.length() == 0) {
			return false;
		}
		
		try {
			double amount = Double.parseDouble(cash);
			if (amount < 0.0) {
				return false;
			}

			String[] s = cash.split("\\.");
			if (s.length > 2) {
				return false;
			}
			
			String decimals="";
			if (s.length == 2) {
				decimals = s[s.length - 1];
			} else if (s.length == 1) {
				return true;
			}
			
			if (decimals.length() > 2) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
}
