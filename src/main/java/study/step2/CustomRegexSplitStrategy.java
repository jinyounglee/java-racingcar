package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomRegexSplitStrategy implements SplitStrategy {

    private static final Pattern CUSTOM_DELIMITER_MATCHER = Pattern.compile("//(.)\\n(.*)");

    @Override
    public String[] split(String text) {
        Matcher matcher = CUSTOM_DELIMITER_MATCHER.matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return new String[]{text};
    }

    @Override
    public Boolean find(String text) {
        Matcher matcher = CUSTOM_DELIMITER_MATCHER.matcher(text);
        return matcher.find();
    }

}
