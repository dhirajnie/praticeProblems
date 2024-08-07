public class RotateMatrix {

    public void rotate(int[][] matrix) {

//        int count =matrix.length/2;
        int count = 0;
        for (int i = count; i < matrix.length - count; i++) {
            for (int j = count; j < matrix.length - count; j++) {
                if (i >= 0 && i < matrix.length && j >= 0 && j < matrix.length) {
                    System.out.println("Looping" + Integer.valueOf(matrix.length - count - i));
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[matrix.length - count - i - 1][j];
                    matrix[matrix.length - count - i - 1][j] = matrix[matrix.length - count - i - 1][matrix.length - count - 1 - j];
                    matrix[matrix.length - count - i - 1][matrix.length - count - j - 1] = temp;
                }
            }
            ++count;
        }


    }


    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new RotateMatrix().rotate(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + ",");
            }
            System.out.println();
        }
    }
}
