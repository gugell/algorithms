public class IsAnagram
{
	public static void main (String[] args) {
		System.out.println(isAnagram("RYANMEYER", "RAYNEYEMR"));
	}

	public static boolean isAnagram(String str1, String str2) {
		int i1 = 0;
		int i2 = 0;

		for (char c : str1.toCharArray()) {
			i1 += c;
		}

		for (char c : str2.toCharArray()) {
			i2 += c;
		}

		System.out.println(i1 + " " + i2);

		return (i1 == i2);
	}
}

