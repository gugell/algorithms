public class Bits {
	public static void main(String[] args) {
		/*
		System.out.println(problem1(100000, 15, 11, 17));
		System.out.println(problem3b(224));
		System.out.println(problem3b(28));
		System.out.println(problem3b(7));
		System.out.println(problembb(85));
		System.out.println(problem4(0, 15));
		System.out.println(problem5(39));

		double d = 0.73;
		System.out.println(Double.doubleToRawLongBits(d));
		*/

		byte[] screen = new byte[12];
		drawHorizontal(screen, 24, 5, 18, 3);
		
		for (byte b : screen) {
			System.out.println(b);
		}
	}

	public static int problem1(int n, int m, int i, int j) {
		return (n | (m << i));
	}

	public static int problem3a(int num) {
		int firstZero = -1;
		boolean wasZero = false;

		for (int i = 0; i < 32; i++) {
			boolean isSet = getBit(num, i);

			if (wasZero && isSet && firstZero == -1) {
				firstZero = i;
			}

			wasZero = !isSet;
		}

		if (firstZero != -1) {
			num = clearBit(num, firstZero);
			num = setBit(num, firstZero - 1);
		}

		return num;
	}

	public static int problem3b(int num) {
		int firstOne = -1;
		boolean wasOne = false;

		for (int i = 0; i < 32; i++) {
			boolean isSet = getBit(num, i);

			if (wasOne && !isSet && firstOne == -1) {
				firstOne = i;
			}

			wasOne = isSet;
		}

		if (firstOne != -1) { 
			num = setBit(num, firstOne);
			num = clearBit(num, firstOne - 1);
		}

		return num;
	}

	public static int problem4(int a, int b) {
		int i = a ^ b;
		int counted = 0;

		for (int j = 0; j < 32; j++) {
			if (getBit(i, j)) {
				counted++;
			}
		}

		return counted;
	}

	public static int problem5(int num) {
		boolean even = false;

		for (int i = 0; i < 32; i++) {
			if (i % 2 == 1) {
				boolean odd = getBit(num, i);
				if (even != odd) {
					if (even) {
						num = clearBit(num, i - 1);
						num = setBit(num, i);
					} else {
						num = setBit(num, i - 1);
						num = clearBit(num, i);
					}
				}
			} else {
				even = getBit(num, i);
			}
		}

		return num;
	}

	public static void drawHorizontal(byte[] screen, int width, int x1, int x2, int y) {
		if (x2 < x1) { return; }

		int firstByte = (width / 8) * (y - 1);
		int x1b = (x1 / 8) + firstByte;
		int x1offset = x1 % 8;

		int x2b = (x2 / 8) + firstByte;
		int x2offset = x2 % 8;

		System.out.println(x1b + " " + x2b);

		if (x1b == x2b) {
			int mask = 0xff << (8 - x2offset);
			mask = mask >> x1offset;
			screen[x1b] = (byte)(screen[x1b] | (byte)mask);
		} else {
			int mask1 = 0xff >> (x1offset - 1);
			screen[x1b] = (byte)(screen[x1b] | (byte)mask1);

			int mask2 = 0xff << (8 - x2offset);
			screen[x2b] = (byte)(screen[x2b] | (byte)mask2);
		}

		for (int i = x1b + 1; i < x2b; i++) {
			screen[i] = (byte)0xff;
		}	
	}

	public static int setBit(int num, int i) {
		return num | (1 << i);
	}

	public static int clearBit(int num, int i) {
		int mask = ~(1 << i);
		return num & mask;
	}

	public static Boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}
}

