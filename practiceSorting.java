import Array.SearchUtils;
import Array.SortUtils;

public class practiceSorting {
    public static void main(String args[]) {
        SortUtils sorting = new SortUtils();
        SearchUtils search = new SearchUtils();
        int[] arr = { 10, 36, 12, 23, 78, 45 };
        sorting.display(arr);
        sorting.mergeSort(arr);
        sorting.display(arr);
        int idx = search.binarySearch(arr, 23);
        String clgMssg = idx == -1 ? "Not Found." : 23 + " found at index " + idx;
        System.out.println(clgMssg);
    }
}
