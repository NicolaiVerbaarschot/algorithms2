import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicTable {

    private int numberOfElements = 0;
	private int[] table = new int[1];

    private void insert(int number) {
	    if (numberOfElements == table.length)
	        doubleArraySize(table);
	    table[numberOfElements] = number;
		numberOfElements++;
	}
	
	private void delete() {
		numberOfElements--;
		if (table.length != 1)
		    if (numberOfElements <= 0.25 * table.length)
            halfArraySize(table);
	}
		
	private void printTable() {
        for (int i = 0 ; i < numberOfElements; i++)
            System.out.print(table[i] + " ");
        System.out.println();
	}
	
	private void reportSize() {
        System.out.print(numberOfElements + " " + table.length);
        System.out.println();

    }

	private void doubleArraySize(int[] tableOriginal) {
        int[] tableCopy = new int[table.length * 2];
        if (numberOfElements >= 0) System.arraycopy(table, 0, tableCopy, 0, numberOfElements);
        table = tableCopy;
    }

    private void halfArraySize(int[] tableOriginal) {
        int[] tableCopy = new int[table.length/2];
        if (numberOfElements >= 0) System.arraycopy(table, 0, tableCopy, 0, numberOfElements);
        table = tableCopy;
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		DynamicTable table = new DynamicTable();
	
		String line;
		
		while ((line = input.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(line);
			String cmd = tokens.nextToken();
			
			if (cmd.equals("I")) {
				table.insert(Integer.parseInt(tokens.nextToken()));
			} else if (cmd.equals("D")) {
				table.delete();
			} else if (cmd.equals("P")) {
				table.printTable();
			} else if (cmd.equals("S")) {
				table.reportSize();
			}
		}
	}
}
