package chapter02;

import chapter02.step01.Money;
import chapter02.step01.Movie;
import chapter02.step01.discountCondition.PeriodCondition;
import chapter02.step01.discountCondition.SequenceCondition;
import chapter02.step01.discountPolicy.AmountDiscountPolicy;
import chapter02.step01.discountPolicy.PercentDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class movieSettingTest {

    @Test
    @DisplayName("Movie(avatar) 객체 생성 테스트")
    void movieCreateTest1() {
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                // (1회(번째) 상영 or 10회(번째) 상영 or 월요일 10:00-11:59 상영 or 목요일 10:00-20:59) 상영 하는 아바타를 구매하면 800원 할인해줌
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(18, 0), LocalTime.of(20, 59))));

        Assertions.assertTrue(avatar.getFee().isGreaterThanOrEqual(new Money(BigDecimal.valueOf(10000 - 800))));
    }

    @Test
    @DisplayName("Movie(titanic) 객체 생성 테스트")
    void movieCreateTest2() {
        Movie titanic = new Movie("타이타닉",
                Duration.ofMinutes(180),
                Money.wons(11000),
                // (2회(번째) 상영 or 화요일 14:00-16:59 상영 or 목요일 10:00-13:59) 상영 하는 아바타를 구매하면 800원 할인해줌
                new PercentDiscountPolicy(0.1,
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))));

        Assertions.assertTrue(titanic.getFee().isGreaterThanOrEqual(new Money(BigDecimal.valueOf(11000 * 0.9))));
    }
}
