package u8pp;
import java.util.ArrayList;
import java.util.Comparator;

public class SearchSort {

    // Insertion Sort for arrays of integers
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Insertion Sort for ArrayLists of Students
    public static ArrayList<Student> insertionSort(ArrayList<Student> students) {
        ArrayList<Student> sortedList = new ArrayList<>(students);
        for (int i = 1; i < sortedList.size(); i++) {
            Student key = sortedList.get(i);
            int j = i - 1;
            while (j >= 0 && new StudentSorter().compare(sortedList.get(j), key) > 0) {
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }
            sortedList.set(j + 1, key);
        }
        return sortedList;
    }

    // Selection Sort for arrays of integers
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Selection Sort for ArrayLists of Students
    public static ArrayList<Student> selectionSort(ArrayList<Student> students) {
        ArrayList<Student> sortedList = new ArrayList<>(students);
        for (int i = 0; i < sortedList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (new StudentSorter().compare(sortedList.get(j), sortedList.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Student temp = sortedList.get(minIndex);
            sortedList.set(minIndex, sortedList.get(i));
            sortedList.set(i, temp);
        }
        return sortedList;
    }

    // Merge Sort for arrays of integers
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }
    
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }
    



    // Merge Sort for ArrayLists of Students
    public static ArrayList<Student> mergeSort(ArrayList<Student> students) {
        int n = students.size();
        if (n < 2) {
            return students;
        }
        int mid = n / 2;
        ArrayList<Student> left = new ArrayList<>(students.subList(0, mid));
        ArrayList<Student> right = new ArrayList<>(students.subList(mid, n));
        left = mergeSort(left);
        right = mergeSort(right);
        ArrayList<Student> merged = merge(left, right);
        return merged;
    }
    
    private static ArrayList<Student> merge(ArrayList<Student> left, ArrayList<Student> right) {
        ArrayList<Student> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (new StudentSorter().compare(left.get(i), right.get(j)) <= 0) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }
        return merged;
    }
    
    // public static void mergeSort(int[] arr) {
    //     int n = arr.length;
    //     if (n < 2) {
    //         return;
    //     }
    //     int mid = n / 2;
    //     int[] left = new int[mid];
    //     int[] right = new int[n - mid];
    //     for (int i = 0; i < mid; i++) {
    //         left[i] = arr[i];
    //     }
    //     for (int i = mid; i < n; i++) {
    //         right[i - mid] = arr[i];
    //     }
    //     mergeSort(left);
    //     mergeSort(right);
    //     merge(arr, left, right);
    // }
    
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
    
