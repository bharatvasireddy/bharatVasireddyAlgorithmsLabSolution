package com.gl.lab.session;

import java.util.Scanner;

public class PayMoneyTransaction {
	static int[] array;
	static int size;
	static int targetNo;
	static int targetValue;

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);

		System.out.println("enter the size of array");
		size = obj.nextInt();
		array = new int[size];
		int i = 0;
		System.out.println("Enter the values of array");
		for (i = 0; i < size; i++) {
			array[i] = obj.nextInt();
		}
		System.out.println("Enter the total no of tagets that needs to be achieved");
		targetNo = obj.nextInt();

		for (i = 0; i < targetNo; i++) {

			System.out.println("Enter the Value of the target");
			targetValue = obj.nextInt();
			int count = 0;
			if (targetValue > 0) {
				count = checkForTransactions(array, size, targetValue);
				if (count > 0)
					System.out.println("Target acheived after " + count + " transaction");
				else
					System.out.println("Target not achieved");

			} else
				System.out.println("target is invalid");
		}
	}

	static int checkForTransactions(int[] elements, int size, int target) {
		int sum = 0, transactions = 0;
		for (int i = 0; i < size; i++) {
			sum = sum + elements[i];
			if (sum >= target) {
				transactions = i + 1;
				break;
			}
		}
		if (sum < target)
			transactions = 0;
		return transactions;
	}
}
