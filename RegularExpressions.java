import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static boolean checkIP(String in) {
        Pattern ipPattern = Pattern.compile("([1-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-5][0-5]))\\."
                        + "([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-5][0-5]))\\."
                        + "([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-5][0-5]))\\."
                        + "([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-5][0-5]))",
                Pattern.CASE_INSENSITIVE);
        Matcher ipMatcher = ipPattern.matcher(in);
        return ipMatcher.find();
    }
}
