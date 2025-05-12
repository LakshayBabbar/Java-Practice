package Array;

public class SearchUtils {
    public int linerSearch(int arr[], int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int arr[], int element) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (element == arr[mid])
                return mid;
            else if (element < arr[mid])
                right = mid - 1;
            else if (element > arr[mid])
                left = mid + 1;
        }
        return -1;
    }
}
