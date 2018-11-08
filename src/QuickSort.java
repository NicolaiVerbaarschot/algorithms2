import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {


	// In-place sort A using QuickSort
	public void sort(int[] A, int lo, int hi) {
		if (lo < hi) {
			int p = this.partition(A, lo, hi);
			sort(A, lo,p-1);
			sort(A,p+1, hi);
		}
	}

	private int partition(int[] A, int lo, int hi) {

		int pivot, i, j;
		pivot = A[hi];
		i = lo - 1;

		for (j = lo; j < hi; j++){

			if (A[j] <= pivot) {
				i++;
				this.swap(A, i, j);
			}
		}

		this.swap(A,i+1, A[hi]);

		return i+1;


	}

	private void swap(int[] A, int i, int j) {
		int temp;
		temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int[] A = new int[Integer.parseInt(input.readLine())];
		
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(tokens.nextToken());
		}
		
		new QuickSort().sort(A,0,A.length-1);

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
}
