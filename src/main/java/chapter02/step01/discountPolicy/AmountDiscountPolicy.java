package chapter02.step01.discountPolicy;

import chapter02.step01.Money;
import chapter02.step01.Screening;
import chapter02.step01.discountCondition.DiscountCondition;

import java.util.List;

public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
