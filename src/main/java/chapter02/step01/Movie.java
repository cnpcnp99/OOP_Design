package chapter02.step01;

import chapter02.step01.discountPolicy.DiscountPolicy;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration duration;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration duration, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.duration = duration;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    /**
     * @return 영화 기본 요금. DiscountPolicy가 반영된 가격이 아님
     */
    public Money getFee() {
        return this.fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
