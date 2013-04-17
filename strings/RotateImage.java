public class RotateImage
{
	public static void main(String[] args) {
		int[][] image = new int[3][3];

		image[0][0] = 1;
		image[0][1] = 2;
		image[0][2] = 3;

		image[1][0] = 4;
		image[1][1] = 5;
		image[1][2] = 6;

		image[2][0] = 7;
		image[2][1] = 8;
		image[2][2] = 9;

		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image.length; j++) {
				System.out.print(image[i][j]);
			}
			System.out.println("");
		}

		int[][] newImage = rotate90(image);

		for (int i = 0; i < newImage.length; i++) {
			for (int j = 0; j < newImage.length; j++) {
				System.out.print(newImage[i][j]);
			}
			System.out.println("");
		}
	}
	
	public static int[][] rotate90(int[][] image) {
		int[][] newImage = new int[image.length][image.length];

		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image.length; j++) {
				newImage[i][j] = image[image.length - 1 - j][i];
			}
		}

		return newImage;
	}
}

