import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class bubbleSort {
  static void bSort(int arr[], int n){
    int i, j, temp;
    boolean swapped;
    for(i = 0; i < n-1; i++){
      swapped = false;
      for(j = 0; j < n-i-1; j++){
        if(arr[j] > arr[j+1]){
          System.out.println("swapped " + arr[j] + " and " + arr[j+1]);
          temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
          swapped = true;
        }
      }
      if(!swapped)
        break;
    }
    System.out.println();
  }
  static void printArr(int arr[], int size){
    int i;
    for(i = 0; i<size; i++)
      System.out.println(arr[i]);
    System.out.println("\nSORTED");
  }
  public static void main(String[] args) {
    Scanner sc = new  Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();
    String filePath;
    System.out.println("Write or copy paste the absolute path to the file");
    filePath = sc.nextLine();

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while((line = br.readLine()) != null){
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
    int n = arr.length;
    bSort(arr, n);
    printArr(arr, n);
  }
}
