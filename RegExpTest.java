import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

public class RegExpTest {
    public static void main(String[] args) {
	Scanner sc = null;
	try {
	    sc = new Scanner(System.in);
	    while (sc.hasNext()) {
		String p = sc.next();
		RegExp re = new RegExp(p);
		String t = sc.next();
		boolean b = RegExp.match(t);
		System.out.println(p + " match " + t + " = " + b);
	    }
	} finally {
	    if (sc != null) {
		sc.close();
	    }
	}
    }
}

class RegExp {
    private static Pattern p;
    public RegExp(String s) {
	p = Pattern.compile(s);
    }
    public static boolean match(String t) {
	Matcher m = p.matcher(t);
	return m.matches();
    }
}