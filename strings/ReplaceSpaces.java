public class ReplaceSpaces
{
	public static void main(String[] args) {
		System.out.println(replaceSpaces("Just a test of the emergency broadcast system."));
	}

	public static String replaceSpaces(String str) {
		StringBuilder sb = new StringBuilder();

		for (char c : str.toCharArray()) {
			if (c == ' ') {
				sb.append("%20");
			}
			else {
				sb.append(c);
			}
		}

		return sb.toString();
	}
}

