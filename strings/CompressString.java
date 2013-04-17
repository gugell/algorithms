public class CompressString {
	public static void main(String[] args) {
		System.out.println(compressString("AAABCDDDEE"));
	}

	public static String compressString(String str) {
		StringBuilder sb = new StringBuilder();
		char lastChar = '\t';
		int runCount = 1;
		
		for (char c : str.toCharArray()) {
			if (lastChar != '\t') {
				if (c == lastChar) {
					runCount++;
				} else { 
					sb.append(Character.toString(lastChar) + runCount);
					runCount = 1;
				}
			}

			lastChar = c;
		}

		sb.append(Character.toString(lastChar) + runCount);

		return sb.toString();
	}
}

