package study.step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomRegexSplitStrategyTest {

    @Test
    @DisplayName("특정 구분자로 split 된다.")
    void custom_구분자로_split() {
        SplitStrategy strategy = new CustomRegexSplitStrategy();
        String[] split = strategy.split("//;\n1;2;3");
        Assertions.assertThat(split).containsExactly("1", "2", "3");
    }

}