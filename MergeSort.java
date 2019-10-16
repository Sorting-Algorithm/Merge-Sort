package com.sorting.algorithm;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 12, 29, 27, 4, 8, 11, 32, 1 };
		mergeSortAlgorithm(arr, 0, arr.length - 1);
		for (int value : arr) {
			System.out.print(value + " ");
		}
	}

	private static void mergeSortAlgorithm(int arr[], int lowerIndex, int higherIndex) {
		if (lowerIndex < higherIndex) {
			int middle = (lowerIndex + higherIndex) / 2;
			mergeSortAlgorithm(arr, lowerIndex, middle);
			mergeSortAlgorithm(arr, middle + 1, higherIndex);
			merge(arr, lowerIndex, middle, higherIndex);
		}
	}

	static void merge(int arr[], int lowerIndex, int middle, int higherIndex) {
		int first = middle - lowerIndex + 1;
		int second = higherIndex - middle;
		int left[] = new int[first];
		int right[] = new int[second];
		for (int i = 0; i < first; ++i) {
			left[i] = arr[lowerIndex + i];
		}
		for (int j = 0; j < second; ++j) {
			right[j] = arr[middle + 1 + j];
		}
		int i = 0, j = 0;
		int k = lowerIndex;
		while (i < first && j < second) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < first) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j < second) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}
}
