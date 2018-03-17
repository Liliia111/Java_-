package ArraySort;

public class ArraySort {
	public static void main(String[] args) {
	int[] array = {30, 2, 10, 4, 6};
	int length = array.length;

	for (int i = 0; i < array.length; i++) {
    for (int j = array.length - 1; j > i; j--) {
        if (array [j] < array [j - 1]) {
            int tmp = array[j];
            array [j] = array [j - 1];
            array [j - 1] = tmp;
                    }
                }
            }
	for (int i = 0; i < length; i++) {
		System.out.print(array[i] + " ");
	}
}

}
