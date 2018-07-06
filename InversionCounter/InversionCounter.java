import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class InversionCounter {

	public static long mergeSort(int[] array) {
		int[] temp = new int[array.length];
		return _mergeSort(array, temp, 0, array.length-1);
	}

	public static long _mergeSort(int array[], int temp[], int start, int end) {
		int middle = 0;
		long count = 0;

		if(end > start) {
			middle = (start+end)/2;

			count = _mergeSort(array, temp, start, middle);
			count += _mergeSort(array, temp, middle+1, end);
			count += merge(array, temp, start, middle, end);
			return count;
		}

		return count;
	}

	public static long merge(int array[], int temp[], int start, int middle, int end) {
		int i = start;
		int j = middle+1;
		int k = start;
		long count = 0;

		while(i <= middle && j <= end) {
			if(array[i] <= array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
				count += (middle+1-i);
			}
		}

		while(i <= middle) {
			temp[k++] = array[i++];
		}

		while(j <= end) {
			temp[k++] = array[j++];
		}

		for(i = start; i <= end; i++) {
			array[i] = temp[i];
		}

		return count;
	}

	public static int[] fileToIntArray(String fileName) {
		try {
			Scanner sc = new Scanner(new File(fileName));
			ArrayList<String> sts = new ArrayList<>();

			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				sts.add(line);
			}
			int[] ans = new int[sts.size()];
			for(int i = 0; i < ans.length; i++) {
				ans[i] = Integer.parseInt(sts.get(i));	
			}

			return ans;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new int[0];
	}

	public static void main(String args[]) {
		int[] array = fileToIntArray("./test.txt");
		long ans = mergeSort(array);
		System.out.println(ans);
	}
}
