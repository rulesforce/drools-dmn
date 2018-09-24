package com.luukas.rules.entity;

public class Input {

	private String strInput1;
    
	private String strInput2;
    
	private String strInput3;
    
	private boolean boolInput;	
    
    private int intInput;
 
	public String getStrInput1() {
		return strInput1;
	}

	public void setStrInput1(String strInput1) {
		this.strInput1 = strInput1;
	}

	public String getStrInput2() {
		return strInput2;
	}

	public void setStrInput2(String strInput2) {
		this.strInput2 = strInput2;
	}

	public String getStrInput3() {
		return strInput3;
	}

	public void setStrInput3(String strInput3) {
		this.strInput3 = strInput3;
	}

	public boolean getBoolInput() {
		return boolInput;
	}

	public void setBoolInput(boolean boolInput) {
		this.boolInput = boolInput;
	}

	public int getIntInput() {
		return intInput;
	}

	public void setIntInput(int intInput) {
		this.intInput = intInput;
	}

	@Override
	public String toString() {
		String str = 
				"strInput1: " + this.strInput1 + "\n" +
				"strInput2: " + this.strInput2 + "\n" +
				"response3: " + this.strInput3 + "\n" +
				"boolInput: " + this.boolInput + "\n" +
				"intInput: " + this.intInput + "\n";
		
		return str;
	}

}
