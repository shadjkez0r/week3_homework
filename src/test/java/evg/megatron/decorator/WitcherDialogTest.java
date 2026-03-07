package evg.megatron.decorator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WitcherDialogTest {
    private Dialog firstSentence;
    private Dialog secondSentence;
    private Dialog thirdSentence;
    private Dialog fourthSentence;

    @BeforeEach
    void setUp() {
        firstSentence = new WitcherDialog();
        secondSentence = new LessMoreMiddleDialogDecorator(firstSentence);
        thirdSentence = new NotHolyHermitDialogDecorator(secondSentence);
        fourthSentence = new PreferNotToChooseDialogDecorator(thirdSentence);
    }

    @Test
    @DisplayName("Базовый класс должен возвращать только 1 предложение")
    void shouldReturnOnlyOneSentence() {
        var result = firstSentence.dialogWithStregobor().split("\n");
        System.out.println(Arrays.toString(result));
        assertThat(result.length).isEqualTo(1);
    }

    @Test
    @DisplayName("Базовый класс обернутый в Декоратор должен вернуть 2 предложения")
    void shouldReturnTwoSentences() {
        var result = secondSentence.dialogWithStregobor().split("\n");
        System.out.println(Arrays.toString(result));
        assertThat(result.length).isEqualTo(2);
    }

    @Test
    @DisplayName("Базовый класс обернутый в 2 Декоратора должен вернуть 3 предложения")
    void shouldReturnThreeSentences() {
        var result = thirdSentence.dialogWithStregobor().split("\n");
        System.out.println(Arrays.toString(result));
        assertThat(result.length).isEqualTo(3);
    }

    @Test
    @DisplayName("Базовый класс обернутый в 3 Декоратора должен вернуть 4 предложения")
    void shouldReturnFourSentences() {
        var result = fourthSentence.dialogWithStregobor().split("\n");
        System.out.println(Arrays.toString(result));
        assertThat(result.length).isEqualTo(4);
    }

}
