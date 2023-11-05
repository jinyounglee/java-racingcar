package study.step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommaAndColonSplitStrategyTest {

    @Test
    @DisplayName("comma, Colon 구분자로 split 된다.")
    void comman_colone_구분자로_split() {
        SplitStrategy splitStrategy = new CommaAndColonSplitStrategy();
        Assertions.assertThat(splitStrategy.split("1:2,3")).containsExactly("1", "2", "3");
    }

}