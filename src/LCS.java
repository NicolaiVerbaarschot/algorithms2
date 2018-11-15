import java.io.*;


public class LCS {

	private void lcs(String a, String b) {


	    printLCS(lcsLength(a,b), a , a.length(), b.length());

	}

	private String[][] lcsLength(String x, String y){
	    int m = x.length()+1;
	    int n = y.length()+1;

	    String[][] b = new String[m][n]; // Implicitly set to zeros
	    int[][] c = new int[m][n];

        for (int i=1; i<m; i++) {
            for (int j = 1; j < n; j++) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = "LeftUp";
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = "Up";
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = "Left";
                }
            }
        }
        return b;
    }

    private void printLCS(String[][] b, String x, int i, int j) {

	    if (i==0 || j==0) {
	        return;
        }
        if (b[i][j].equals("LeftUp")) {
            printLCS(b,x,i-1,j-1);
            System.out.print(x.charAt(i-1));
        } else if (b[i][j].equals("Up")) {
            printLCS(b,x,i-1,j);
        } else {
            printLCS(b,x,i,j-1);
        }
    }





	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		new LCS().lcs(input.readLine(), input.readLine());
	}
}
