package helper;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
	public static String checkRegex(String regex,String message) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println(message+" ");
			String i= sc.nextLine();
				if(Pattern.compile(regex).matcher(i).matches()) {
					return i;
				}else {
					System.out.println("Error:invalid \n");
				}
			}
	}
	public static boolean checkBoolean(String regex,String i) {

				return Pattern.compile(regex).matcher(i).matches();
			
	}
}
