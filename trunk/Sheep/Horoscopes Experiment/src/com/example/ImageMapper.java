package com.example;

public final class ImageMapper {
	public static int findBig(int position) {
		int imageId = 0;
		switch (position) {
		case 0:
			imageId = R.drawable.horse_big;
			break;
		case 1:
			imageId = R.drawable.sheep_big;
			break;
		case 2:
			imageId = R.drawable.snake_big;
			break;
		case 3:
			imageId = R.drawable.rabbit_big;
			break;

		default:
			break;
		}

		return imageId;
	}

	public static int findSmall(int position) {
		int imageId = 0;
		switch (position) {
		case 0:
			imageId = R.drawable.horse;
			break;
		case 1:
			imageId = R.drawable.sheep;
			break;
		case 2:
			imageId = R.drawable.snake;
			break;
		case 3:
			imageId = R.drawable.rabbit;
			break;

		default:
			break;
		}

		return imageId;
	}
}
