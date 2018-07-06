import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class InversionCounter {

	public static int mergeSort(int[] array) {
		int ans = _mergeSort(array, 0, array.length-1);
		return ans;
	}

	public static int _mergeSort(int array[], int start, int end) {
		int middle = (start+end)/2;

		int inv = 0;
		if(start < end) {
			inv += _mergeSort(array, start, middle);
			inv += _mergeSort(array, middle+1, end);
			inv += merge(array, start, end);
			return inv;
		}

		return inv;
	}

	public static int merge(int array[], int start, int end) {
		int middle = (start+end)/2;
		int[] newArray = new int[end-start+1];
		int i = start;
		int j = middle+1;
		int k = 0;
		int inv = 0;

		while(i <= middle && j <= end) {
			if(array[i] <= array[j]) {
				newArray[k++] = array[i++];
			} else {
				inv += (j-i);
				newArray[k++] = array[j++];
			}
		}

		while(i <= middle) {
			newArray[k++] = array[i++];
		}

		while(j <= end) {
			newArray[k++] = array[j++];
		}

		for(i = 0; i < newArray.length; i++) {
			array[i+start] = newArray[i];
		}

		return inv;
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
		int ans = mergeSort(array);
		System.out.println(ans);
	}
}
