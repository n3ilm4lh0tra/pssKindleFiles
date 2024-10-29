import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class MergeSort {

    static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void sort(int arr[], int l, int r)
    {
        if (l < r) {

            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.println(arr[i]);
        System.out.println();
    }

    public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      ArrayList<Integer> numberList = new ArrayList<>();
        String filePath;
        System.out.println("Write or copy paste the absolute path to the file");
        filePath = sc.next();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    numberList.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Transfer numbers from ArrayList to an array
        int[] arr = new int[numberList.size()];
        for (int i = 0; i < numberList.size(); i++) {
            arr[i] = numberList.get(i);
        }

        System.out.println("Given array is");
        printArray(arr);

        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
    }
}

