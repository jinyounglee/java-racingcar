package study.step2;

import java.util.ArrayList;
import java.util.List;

public class SplitStrategyExecutor {

    private final List<SplitStrategy> splitStrategies;

    public SplitStrategyExecutor(List<SplitStrategy> splitStrategies) {
        this.splitStrategies = splitStrategies;
    }

    public String[] split(String text) {
        String[] result = new String[]{text};
        for (SplitStrategy strategy : splitStrategies) {
            if (strategy.find(text)) {
                result = strategy.split(text);
            }
        }
        return result;
    }
}
