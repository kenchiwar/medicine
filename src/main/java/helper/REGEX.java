package helper;

public class REGEX {
	public final static String NUM="[0-9]+";
	public final static String DATE="((18|19|20)[0-9]{2}[-](0[13578]|1[02])"
			+ "[-](0[1-9]|[12][0-9]|3[01]))|(18|19|20)[0-9]{2}[-]"
			+ "(0[469]|11)[-](0[1-9]|[12][0-9]|30)|(18|19|20)"
			+ "[0-9]{2}[-](02)[-](0[1-9]|1[0-9]|2[0-8])|"
			+ "(((18|19|20)(04|08|[2468][048]|[13579][26]))|2000)[-](02)[-]29";
	public final static String NOTNUM="^([a-zA-Z]\\s*){5,50}$";
	public final static String CHAR = "^[a-zA-Z0-9\\s*]+{0,50}";
	public final static String TELEPHONE="^(0|\\+84)"
			+ "(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))"
			+ "(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
}
