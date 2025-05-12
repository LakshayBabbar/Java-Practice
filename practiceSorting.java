import Array.Sort;

public class practiceSorting {
    public static void main(String args[]) {
        Sort sorting = new Sort();
        int[] arr = sorting.getRandomArrayOfIntegers(8);
        sorting.display(arr);
        sorting.mergeSort(arr);
        sorting.display(arr);
    }
}
