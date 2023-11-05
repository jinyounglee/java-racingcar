package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.*;
import static study.step2.Calculator.calculate;

public class CalculatorTest {

    @Test
    void null_빈문자열_값() {
        assertThat(calculate(null)).isEqualTo(0);
        assertThat(calculate("")).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나만 주어진다면 주어진 숫자만 리턴된다.")
    void 숫자_하나_만_들어온다면_숫자가_리턴된다() {
        assertThat(calculate("1")).isEqualTo(1);
    }

    @Test
    @DisplayName(",|: 구분자로 합을 구한다.")
    void comma_and_colon_구분자로_합을_구한다() {
        String a = "1,2:3";

        String[] arr = a.split(",|:");
        assertThat(arr).contains("1", "2", "3");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3=6", "1,2=3", "1,2,3,4,5=15"}, delimiter = '=')
    @DisplayName(", 를 구분자로 합을 구한다.")
    void comma_구분자로_합을_구한다2(String input, String expected) {
        assertThat(calculate(input)).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3=6", "1:2=3", "1:2:3:4:5=15"}, delimiter = '=')
    @DisplayName(": 를 구분자로 합을 구한다.")
    void colon_구분자로_합을_구한다2(String input, String expected) {
        assertThat(calculate(input)).isEqualTo(Integer.parseInt(expected));
    }

    @Test
    @DisplayName("“//”와 “\\n” 사이에 위치하는 문자를 커스텀 구분자로 사용")
    void custom_delimiter() {
        String input = "//;\n1;2;3";
        assertThat(calculate(input)).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 들어가면 RuntimeException을 발생시킨다")
    void negative_input_runtime_exception() {
        assertThatThrownBy(() -> {
            calculate("1,-1,2");
        }).isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 들어갈 수 없습니다.");
    }

    @Test
    @DisplayName("숫자가 아니면 RuntimeException을 발생시킨다.")
    void not_NumberFormat_throwRuntimeException() {
        assertThatThrownBy(() -> {
            calculate("1,d");
        }).isInstanceOf(RuntimeException.class)
                .hasMessage("숫자 format이 아닙니다.");
    }
}
