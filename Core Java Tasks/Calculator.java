package myjavacodes;

public class Calculator {
	public int add(int x,int y) {
		return x+y;
	}
	
	public int sub(int x,int y) {
		return x-y;
	}
	
	public int mul(int x,int y) {
		return (x*y);
	}
	
	public int div(int x,int y) {
		return x/y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc=new Calculator();
		System.out.println(calc.add(5, 8));
		System.out.println(calc.sub(15, 8));
		System.out.println(calc.mul(5, 8));
		System.out.println(calc.div(58, 8));
		

	}

}
