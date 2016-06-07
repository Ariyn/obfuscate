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
}

/*
r1 = 12345 * r
r2 = (111111-6)/8 * r
*/