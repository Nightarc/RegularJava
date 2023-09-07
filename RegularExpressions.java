import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static boolean checkIP(String in) {
        Pattern pattern = Pattern.compile("^([1-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-5][0-5]))\\."
                        + "([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-5][0-5]))\\."
                        + "([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-5][0-5]))\\."
                        + "([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-5][0-5]))$",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(in);
        return matcher.find();
    }

    public static boolean checkGUID(String in) {
        Pattern pattern = Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(in);
        return matcher.find();
    }
}
