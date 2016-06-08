public class NewTest {
	public void sample1(String a) {
		System.out.println(a);
	}
	
	public void sample2() {
		double r1 = (Math.random()+1);
		double r2 = (Math.random()+1)*2*3*5*5*823;
		double r3 = (r1 * 2*2*3*5*7*11*13*37 - 6) / 9;
		String s1 = Double.toString(r3);
		// double r3 = (r3 % 10000000000) - 9;
		// r3 = r3 / 8 / (2*3^2*5*3607*3803);
		if(r3 > r2) {
			System.out.println("of course!");
		} else {
			System.out.println("what????!?!?!");
		}
	}
	
	public void sample3() {
		double a = Math.random();
		System.out.println(a);
	}

	public void sample4() {
		int a = 0;		
		if(random(1.0, 1.0) == 1) {
			System.out.println(a);
		}
		
		System.out.println(a);
	}

	public void sample5(int b) {
		if(sample6(b) == 0) {
			b = 1;
		}
	}

	private static int sample6(int a) {
		return a;
	}

	private int random(double r1, double r2) {
		r1 = ((r1+1)*2*2*3*5*7*11*13*37 - 6) / 9;
		r2 = (r2+1)*2*3*5*5*823;

		if(r1 > r2) {
			return 1;
		} else {
			return 0;
		}
	}
}

/*
r1 = 12345 * r
r2 = (111111-6)/8 * r
*/