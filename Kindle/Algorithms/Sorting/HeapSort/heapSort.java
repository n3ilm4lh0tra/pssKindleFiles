import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class heapSort{
  static void heapify(int arr[], int n, int i){
    int largest = i;
    int l = 2*i+1;
    int r = 2*i+2;
    if(l<n && arr[l] > arr[largest]){
      largest = l;
    }
    if(r<n && arr[r] > arr[largest]){
      largest = r;
    }
    if(largest != i){
      int temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;

      heapify(arr, n, largest);
    }
  }
  static void HeapSort(int arr[]){
    int n = arr.length;

    for(int i = n/2-1; i >=0; i--)
      heapify(arr, n, i);
    for(int i = n-1; i>0; i--){
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      heapify(arr, i, 0);
    }
  }
  static void printArray(int arr[]){
    for(int i = 0; i < arr.length; i++){
      System.out.println(arr[i]);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();
    String filePath;
    System.out.println("Write or copy paste the absolute path to the file");
    filePath = sc.next();

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null){
        try {
          int num = Integer.parseInt(line.trim());
          list.add(num);
        } catch (NumberFormatException e) {
          System.out.println("INVALID_NUMBER_FORMAT: " + line);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    int arr[] = new int[list.size()];
    for(int i = 0; i < list.size(); i++)
      arr[i] = list.get(i);
    HeapSort(arr);
    printArray(arr);
  }
}
