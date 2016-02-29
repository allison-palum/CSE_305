import java.io.*;
import java.util.*;
import java.lang.*;

public class hw1 {
	public static String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while(line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		}
		finally {
			br.close();
		}
	}
	public static boolean hw1(String input, String output) throws IOException {
		//function definition here
		String in = new String();
		in = readFile(input);
		PrintWriter pw = new PrintWriter(new FileWriter(output));
		int start = 0;
		String[] s = in.split("\n");
		for (int i = 0; i < 5; i++) {
			boolean isFalse = false;
			if (s[i].length() < 26) {
				pw.write("false\n");
				isFalse = true;
			}
			else{
				for (char j = 'a'; j < 'z'; j++) {
					if((s[i].indexOf(j) < 0) && (s[i].indexOf((char)(j + 32)) < 0)) {
						pw.write("false\n");
						isFalse = true;
						break;
					}
				}	
				if (!isFalse) {
					pw.write("true\n");
				}	
			}	 
		}
		pw.close();
		return true;
	}
}
