package Sort;

public class QuickSort {
    public void quickSort(int arr[], int low, int high){
        if(low < high) {
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private int partition(int arr[], int low, int high){
        int i = low, j = high;
        int pivot = arr[low];

        while(i < j){
            while(arr[i] <= pivot)
                i++;
            while(arr[j] > pivot)
                j--;

            if(i < j){
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);

        return j;
    }

    private void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
