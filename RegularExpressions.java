import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static HashMap<String, Pattern> patterns;
    static{
        patterns = new HashMap<>();
        patterns.put("IP", Pattern.compile("^([1-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-5][0-5]))\\." +
                        "([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-5][0-5]))\\." +
                        "([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-5][0-5]))\\." +
                        "([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-5][0-5]))$",
                     Pattern.CASE_INSENSITIVE));

        patterns.put("GUID", Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$",
                Pattern.CASE_INSENSITIVE));

        patterns.put("URL", Pattern.compile("^(\\w+://)?(\\w{2,}\\.)?(\\w{2,})\\.(\\w{2,})(:\\d{4,5})?((\\?\\p{L}+=\\p{L}+)(&\\p{L}+=\\p{L}+)*)?(#\\w+)?$",
                Pattern.UNICODE_CASE));

        patterns.put("SecurePassword", Pattern.compile("^(?=.*\\d)(?=.*[A-Za-z_])\\w{8,}$",
                Pattern.UNICODE_CASE));
    }
    public static boolean checkPattern(String in, Pattern pattern) {
        if(pattern != null) {
            Matcher matcher = pattern.matcher(in);
            return matcher.find();
        }
        return false;
    }
}
