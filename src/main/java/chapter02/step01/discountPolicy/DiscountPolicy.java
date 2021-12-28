package chapter02.step01.discountPolicy;

import chapter02.step01.Money;
import chapter02.step01.Screening;
import chapter02.step01.discountCondition.DiscountCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract public class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);

}
