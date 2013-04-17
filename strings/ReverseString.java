public class ReverseString {
	public static void main(String[] args) {
		System.out.println(9 / 2);
		System.out.println(reverseString("RYANMEYER"));
		System.out.println(reverseString("VANESSAMEYER"));
	}

	public static String reverseString(String str) {
		char[] chars = str.toCharArray();

		for (int i = 0; i < str.length() / 2; i++) {
			char c = chars[i];
			chars[i] = chars[str.length() - 1 - i];
			chars[str.length() - 1 - i] = c;
		}

		return new String(chars);
	}
}

