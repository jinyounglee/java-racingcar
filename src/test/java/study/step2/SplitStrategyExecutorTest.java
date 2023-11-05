package study.step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SplitStrategyExecutorTest {

    private final static List<SplitStrategy> ONLY_COMMA_COLON_SPLIT_STRATEGY = List.of(new CommaAndColonSplitStrategy());
    private final static List<SplitStrategy> ONLY_CUSTOM_SPLIT_STRATEGY = List.of(new CustomRegexSplitStrategy());

    private final static List<SplitStrategy> ALL_SPLIT_STRATEGY = List.of(new CustomRegexSplitStrategy(), new CommaAndColonSplitStrategy());


    @Test
    @DisplayName("comma colon split전략으로 split")
    void comma_colon_strategy() {
        SplitStrategyExecutor executor = new SplitStrategyExecutor(ONLY_COMMA_COLON_SPLIT_STRATEGY);
        String[] split = executor.split("1,2:3,4");
        Assertions.assertThat(split).containsExactly("1", "2", "3", "4");
    }

    @Test
    @DisplayName("custom split전략으로 split")
    void custom_split_strategy() {
        SplitStrategyExecutor executor = new SplitStrategyExecutor(ONLY_CUSTOM_SPLIT_STRATEGY);
        String[] split = executor.split("//;\n1;2;3;4");
        Assertions.assertThat(split).containsExactly("1", "2", "3", "4");
    }

    @Test
    @DisplayName("모든 전략으로 split")
    void all_split_strategy() {
        SplitStrategyExecutor executor = new SplitStrategyExecutor(ALL_SPLIT_STRATEGY);
        String[] split = executor.split("1,2:3,4");
        Assertions.assertThat(split).containsExactly("1", "2", "3", "4");
        String[] customSplit = executor.split("//;\n1;2;3;4");
        Assertions.assertThat(customSplit).containsExactly("1", "2", "3", "4");
    }
}