public class InversionCounter {

	public static void mergeSort(int[] array) {
		_mergeSort(array, 0, array.length-1);
	}

	public static void _mergeSort(int array[], int start, int end) {
		int middle = (start+end)/2;

		if(start < end) {
			_mergeSort(array, start, middle);
			_mergeSort(array, middle+1, end);
			merge(array, start, end);
		}
	}

	public static void merge(int array[], int start, int end) {
		int middle = (start+end)/2;
		int[] newArray = new int[end-start+1];
		int i = start;
		int j = middle+1;
		int k = 0;

		while(i <= middle && j <= end) {
			if(array[i] <= array[j]) {
				newArray[k++] = array[i++];
			} else {
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
	}


	public static void main(String args[]) {
		int[] array = {3,5,2,5,7,3,2,1};
		mergeSort(array);
		System.out.println("Termino\n");
		for(int x: array) {
			System.out.print(x +" ");
		}
	}
}
