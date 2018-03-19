package BinarySearch;

public class BinarySearch {
public static void main(String[] args) {


		int data[] = { 3, 6, 7, 10, 34, 56, 60 };
		int numberToFind = 10;
		        int key = 0;
		        int Lo = 0;
		       
		        int Hi = data.length-1;
		             for (int i = 0; i < data.length; i++) {
		        for (int j = data.length - 1; j > i; j--) {
		            if (data [j] < data [j - 1]) {
		                int tmp = data[j];
		                data [j] = data [j - 1];
		                data [j - 1] = tmp;
		                        }
		                    }
		                }
		               while (Lo<=Hi) {


		            int mid = Lo + (Hi - Lo) / 2;
		            if (numberToFind < data[mid]){
		                Hi = mid - 1;
		            }
		            else if (numberToFind > data[mid]){
		                Lo = mid + 1;
		            } else if(numberToFind == data[mid]){ key = mid;  break;}

		               }
		               if(Lo>Hi)
                       {
                        key = -1;
                       }
		            System.out.println(key);
			}

}
