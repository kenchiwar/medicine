package helper;

public class RegexConst {
	public final static String NUM = "[0-9]+";
	public final static String CHARS = "^([a-zA-Z]\\s*){2,25}$";
	public final static String CHARS_NUM = "^([a-zA-Z0-9+]\\s*){2,25}$";

	public final static String STATUS = "[0-1]";
	public final static String PHONE = "([0-9]).{9,10}$";
	public final static String MAIL = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	public final static String PASS = "^([a-zA-Z0-9]\\s*){3,10}$";

}
