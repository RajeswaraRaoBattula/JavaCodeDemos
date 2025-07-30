package mymockitodemos;

public class CalcApp {
	CalcServices cs1;
	public void setCs1(CalcServices cs1) {
		this.cs1=cs1;
	}
	
	public int add_1(int input1, int input2) {
		return cs1.add(input1, input2);
	}
	
	public int subtract_1_1(int input1, int input2) {
		return cs1.subtract(input1, input2);
	}
	
	public int multiply_1(int input1, int input2) {
		return cs1.multiply(input1, input2);
	}
	
	public int divide_1(int input1, int input2) {
		return cs1.devide(input1, input2);
	}
	
	
}
