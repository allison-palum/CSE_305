import java.util.*;
import java.lang.*;
import java.io.*;

public class hw2 {
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
	public static void hw2(String input, String output)throws IOException {
		//read input file
		String in = new String();
                in = readFile(input);
		
		//output file	
                PrintWriter pw = new PrintWriter(new FileWriter(output));
               	
		//create stack of Objects
		Stack<String> stack = new Stack<String>();
		
		//Strings for testing
		String strx = new String();
		String stry = new String();
		
		//int for testing
		int intx;
		int inty;
	
		//array of lines of files
                String[] file_str = in.split("\n"); // each index of array is one line of the file
		
		//parse file_string
		for (int i = 0; i < file_str.length; i++) {
			String[] str = file_str[i].split(" "); // first index of array is the action, second is the variable
			//quit
			if (str[0].equals("quit")) {
				while(!stack.empty()) {	
					pw.write(stack.pop()+"\n");
				}		
			}
			//push
			else if (str[0].equals("push")) {	
				stack.push(str[1]);
			}
			//pop
			else if (str[0].equals("pop")) {
				if(!stack.empty()) stack.pop();
				else stack.push(":error:");
			}
			//boolean
			else if (str[0].equals(":true:") || str[0].equals(":false:")) {
				stack.push(str[0]);
			}
			//error
			else if (str[0].equals(":error:")) {
				stack.push(str[0]);
			}
			//add
			else if (str[0].equals("add")) {	
				stry = stack.peek();
				if (stack.empty() || stack.size() == 1) stack.push(":error:");
				else if(!stry.equals(":error:") && !stry.equals(":false:") && !stry.equals(":true:")) {
					stry = stack.pop();
					strx = stack.peek();
					if(!strx.equals(":error:") && !strx.equals(":false:") && !strx.equals(":true:")) {
						strx = stack.pop();
						inty = Integer.parseInt(stry);
						intx = Integer.parseInt(strx);
						int addition = intx + inty;
						StringBuilder sb = new StringBuilder();
						sb.append("");
						sb.append(addition);
						String add = sb.toString();
						stack.push(add); 
					}
					else {
						stack.push(stry);
						stack.push(":error:");
					}	
				}
			}
			//sub
			else if (str[0].equals("sub")) {
				stry = stack.peek();
				if (stack.empty() || stack.size() == 1) stack.push(":error:");
				else if(!stry.equals(":error:") && !stry.equals(":false:") && !stry.equals(":true:")) {
					stry = stack.pop();
					strx = stack.peek();
					if(!strx.equals(":error:") && !strx.equals(":false:") && !strx.equals(":true:")) {
						strx = stack.pop();
						inty = Integer.parseInt(stry);
						intx = Integer.parseInt(strx);
						int subtraction = intx - inty;
						StringBuilder sb = new StringBuilder();
						sb.append("");
						sb.append(subtraction);
						String sub = sb.toString();
						stack.push(sub);
					}
					else {
						stack.push(stry);
						stack.push(":error:");
					}
				} 
			}
			//mul
			else if (str[0].equals("mul")) {
                                stry = stack.peek();
				if (stack.empty() || stack.size() == 1) stack.push(":error:");
                                else if(!stry.equals(":error:") && !stry.equals(":false:") && !stry.equals(":true:")) {
                                        stry = stack.pop();
					strx = stack.peek();
                                        if(!strx.equals(":error:") && !strx.equals(":false:") && !strx.equals(":true:")) {
						strx = stack.pop();
                                                inty = Integer.parseInt(stry);
                                                intx = Integer.parseInt(strx);
                                                int multiplication = intx * inty;
                                                StringBuilder sb = new StringBuilder();
                                                sb.append("");
                                                sb.append(multiplication);
                                                String mul = sb.toString();
                                                stack.push(mul);
                                        }
					else {
						stack.push(stry);
						stack.push(":error:");
					}
                                }
                        }
			//div
			else if (str[0].equals("div")) {
                                stry = stack.peek();
                                if (stack.empty() || stack.size() == 1) stack.push(":error:");
                                else if(!stry.equals(":error:") && !stry.equals(":false:") && !stry.equals(":true:") && !stry.equals("0")) {
                                        stry = stack.pop();
					strx = stack.peek();
                                        if(!strx.equals(":error:") && !strx.equals(":false:") && !strx.equals(":true:")) {
						strx = stack.pop();
                                                inty = Integer.parseInt(stry);
                                                intx = Integer.parseInt(strx);
                                                int division = intx / inty;
                                                StringBuilder sb = new StringBuilder();
                                                sb.append("");
                                                sb.append(division);
                                                String div = sb.toString();
                                                stack.push(div);
                                        }
					else {
						stack.push(stry);
						stack.push(":error:");
					}
                                }
                        }
	        	//rem
	        	else if (str[0].equals("rem")) {
				stry = stack.peek();
				if (stack.empty() || stack.size() == 1) stack.push(":error:");
                                else if(!stry.equals(":error:") && !stry.equals(":false:") && !stry.equals(":true:") && !stry.equals("0")) {
                                        stry = stack.pop();
					strx = stack.peek();
                                        if(!strx.equals(":error:") && !strx.equals(":false:") && !strx.equals(":true:")) {
						strx = stack.pop();
                                                inty = Integer.parseInt(stry);
                                                intx = Integer.parseInt(strx);
                                                int remainder = intx % inty;
                                                StringBuilder sb = new StringBuilder();
                                                sb.append("");
                                                sb.append(remainder);
                                                String rem = sb.toString();
                                                stack.push(rem);
                                        }
					else {
						stack.push(stry);
						stack.push(":error:");
					}
                                }
			}
			//neg
			else if (str[0].equals("neg")) {
				stry = stack.peek();
				if(stack.empty()) stack.push(":error:");
				else if(!stry.equals(":error:") && !stry.equals(":false:") && !stry.equals(":true:")) {
					stry = stack.pop();
					inty = Integer.parseInt(stry);
                                        int negative = inty * -1;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("");
                                        sb.append(negative);
                                        String neg = sb.toString();
                                        stack.push(neg) ;
				}
				else stack.push(":error:");
			}
			//swap
			else if (str[0].equals("swap")) {
				if(stack.empty() || stack.size() == 1) stack.push(":error:");
				else {
					stry = stack.pop();
					strx = stack.pop();
					stack.push(stry);
					stack.push(strx);
				}
			}
		}
		pw.close();
	}
}
