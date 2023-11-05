package study.step2;

public class CommaAndColonSplitStrategy implements SplitStrategy {

    private static final String COMMA_COLON_DELIMITER = ",|:";

    private static final String FIND_MATCH_REGEX = "^(.*[,|:].*)*$";

    @Override
    public String[] split(String text) {
        return text.split(COMMA_COLON_DELIMITER);
    }

    @Override
    public Boolean find(String text) {
        return text.matches(FIND_MATCH_REGEX);
    }

}
