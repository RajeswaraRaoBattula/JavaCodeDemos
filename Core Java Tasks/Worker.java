package myjavacodes;

class Workers {
	String name;
	double salaryRate;
	
	public Workers(String name, double salaryRate) {
		this.name = name;
		this.salaryRate = salaryRate;
	}

	public double pay(int hours) {
		return 0.0;
	}
	
	public void display(int hours) {
		System.out.println("Name:"+name);
		System.out.println(pay(hours));
	}
}

class DailyWorker extends Workers{

		public DailyWorker(String name, double salaryRate) {
			super(name, salaryRate);
			// TODO Auto-generated constructor stub
		}
		@Override
		public double pay(int hours) {
			return salaryRate*hours;
		}
}	

class SalariedWorker extends Workers{

		public SalariedWorker(String name, double salaryRate) {
			super(name, salaryRate);
			// TODO Auto-generated constructor stub
		}
		@Override
		public double pay(int hours) {
			return salaryRate*40;
		}
}


public class Worker{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DailyWorker d1=new DailyWorker("Raja",60);
		SalariedWorker s1=new SalariedWorker("Kaja",100);
		d1.display(20);
		s1.display(20);

	}
}


