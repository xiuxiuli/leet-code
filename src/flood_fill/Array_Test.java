package flood_fill;

import java.util.Arrays;

public class Array_Test {
	
	public static int[] twoDim2oneDim(int[][] data){
		int cols = data[0].length;
		int rows = data.length;
		
		int[] res = new int[cols * rows];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int index = i * cols + j;
				res[index] = data[i][j];
			}
		}
		return res;	
	}
	
	public static int[][] oneDim2twoDim(int[] arr, int rows, int cols){
		int[][] res = new int[rows][cols];
		
		for (int index = 0; index < arr.length; index++) {
			int i = index / cols; //行
			int j = index % cols; //列
			res[i][j] = arr[index];
		}
		return res;
	}
	
	//二维数组中，指定某个点， 打印出它的上下左右四联通
	public static void printAdj4(int[][] data, int i, int j) {
		int cols = data[0].length;
		int rows = data.length;
		
		int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //上下左右
		for(int[] dir : directions) {
			int row = i + dir[0];
			int col = j + dir[1];
			if (row >= 0 && row < rows && col >= 0 && col < cols) {
				System.out.println(data[row][col]);
			}
		}
	}
	
	//二维数组中，指定某个点， 打印出它的上下左右八联通
		public static void printAdj8(int[][] data, int i, int j) {
			int cols = data[0].length;
			int rows = data.length;
			
			int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1},
								   {-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; //上下左右
			for(int[] dir : directions) {
				int row = i + dir[0];
				int col = j + dir[1];
				if (row >= 0 && row < rows && col >= 0 && col < cols)
				System.out.println(data[row][col]);
			}
		}
	
	public static void main(String[] args) {
		int[][] data = {
				{4, 2, 5, 11},
				{3, 7, 1, 9},
				{32, 22, 13, 8} };
		System.out.println(Arrays.toString(twoDim2oneDim(data)));
		
		System.out.println("========");
		
		int[] arr = {4, 2, 5, 11, 3, 7, 1, 9, 32, 22, 13, 8};
		for (int[] a : oneDim2twoDim(arr, 3, 4)) {
			System.out.println(Arrays.toString(a));
		}
		
		System.out.println("========");
		printAdj4(data, 1, 2);
		
		System.out.println("========");
		printAdj8(data, 1, 2);
	}

}
