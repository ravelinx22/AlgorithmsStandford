public class InversionCounter {

	public static int[] mergeSort(int[] array) {
		int[] temp = new int[array.length];
		_mergeSort(array, temp, 0, array.length-1);
		return temp;
	}

	public static void _mergeSort(int[] array, int[] temp, int i, int j) {
		if(i == j) {
			return;
		}

		int mid = (i+j)/2;

	    _mergeSort(array, temp, i, mid);
		_mergeSort(array, temp, mid+1, j);
		merge(array, temp,  i, mid, j);
	}

	public static void merge(int[] array, int[] temp, int i, int mid, int j) {
		int tempMid = mid+1;
		int k = i;
		while(i <= tempMid && tempMid <= j) {
			if(array[i] <= array[mid+1]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[tempMid++];
			}
		}	
	}


	public static void main(String args[]) {
		int[] array = {3,5,2,5,7,3,2,1};
		int[] response = mergeSort(array);
		System.out.println("Termino\n");
		for(int i = 0; i < response.length; i++) {
			System.out.print(response[i] + " ");
		}
	}
}
