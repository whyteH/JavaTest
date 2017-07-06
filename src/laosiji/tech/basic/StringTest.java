package laosiji.tech.basic;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "a";
		String s3 = s2 + "bc";
		String s4 = "a" + "bc";
		String s5 = s3.intern();
		final String s6 = getA();
		String s7 = s6 + "bc";
		System.out.println(s1 == s3);
		System.out.println(s1 == s4);
		System.out.println(s1 == s5);
		System.out.println(s1 == s7);
	}

	public static String getA() {
		return "a";
	}
}
