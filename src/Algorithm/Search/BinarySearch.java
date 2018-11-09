package Algorithm.Search;

public class BinarySearch {
    static int binarySearch(int[] inputArray, int value) {
        int left = 0;
        int right = inputArray.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (inputArray[middle] > value) {
                right = middle - 1;
            } else if (inputArray[middle] < value) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArray = {1, 2, 4, 6, 7, 10, 12, 15};
        int value1 = 4;
        int value2 = 7;
        int value3 = 15;
        int value4 = 8;
        int value5 = 20;

        System.out.println(value1 + " index in testArray : "
                + binarySearch(testArray, value1));
        System.out.println(value2 + " index in testArray : "
                + binarySearch(testArray, value2));
        System.out.println(value3 + " index in testArray : "
                + binarySearch(testArray, value3));
        System.out.println(value4 + " index in testArray : "
                + binarySearch(testArray, value4));
        System.out.println(value5 + " index in testArray : "
                + binarySearch(testArray, value5));
    }
}
