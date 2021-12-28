package chapter02.step01.discountPolicy;

import chapter02.step01.Money;
import chapter02.step01.Screening;
import chapter02.step01.discountCondition.DiscountCondition;

import java.util.List;

public class PercentDiscountPolicy extends DiscountPolicy{
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
