package com.gl.lab.session;

import java.util.Scanner;

public class CurrDenomImpl {
	static int array[];
	static int size;
	static int amount;
	static int noteCounter[];

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the size of currency denominations");
		size = obj.nextInt();
		array = new int[size];
		noteCounter = new int[size];
		System.out.println("Enter the currency denominations value");
		for (int i = 0; i < size; i++) {
			array[i] = obj.nextInt();
		}

		// mergeSort for descending order of denominations
		mergeSort(array, 0, array.length - 1);

		// Amount to be calculated
		System.out.println("Enter the amount you want to pay");
		amount = obj.nextInt();

// need to print the denomination
		countCurrency(amount);

	}

	static void mergeSort(int[] array, int low, int high) {
		if (high <= low)
			return;
		int mid = (low + high) / 2;
		mergeSort(array, low, mid);
		mergeSort(array, mid + 1, high);
		merge(array, low, mid, high);
	}

	static void merge(int[] array, int low, int mid, int high) {
		int leftArray[] = new int[mid - low + 1];
		int rightArray[] = new int[high - mid];
		for (int i = 0; i < leftArray.length; i++)
			leftArray[i] = array[low + i];
		for (int i = 0; i < rightArray.length; i++)
			rightArray[i] = array[mid + i + 1];
		int leftIndex = 0;
		int rightIndex = 0;
		for (int i = low; i < high + 1; i++) {
			if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
				if (leftArray[leftIndex] >= rightArray[rightIndex]) {
					array[i] = leftArray[leftIndex];
					leftIndex++;
				} else {
					array[i] = rightArray[rightIndex];
					rightIndex++;
				}
			} else if (leftIndex < leftArray.length) {
				array[i] = leftArray[leftIndex];
				leftIndex++;
			} else if (rightIndex < rightArray.length) {
				array[i] = rightArray[rightIndex];
				rightIndex++;
			}
		}
	}

	public static void countCurrency(int amount) {

		for (int i = 0; i < size; i++) {
			if (amount >= array[i]) {
				noteCounter[i] = amount / array[i];
				amount = amount - noteCounter[i] * array[i];
			}
		}

		// Print notes
		System.out.println("Your payment approach in order to give min no of notes will be");
		for (int i = 0; i < size; i++) {
			if (noteCounter[i] != 0) {
				System.out.println(array[i] + " : " + noteCounter[i]);
			}
		}
	}
}
