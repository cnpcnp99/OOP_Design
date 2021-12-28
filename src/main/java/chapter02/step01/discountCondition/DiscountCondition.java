package chapter02.step01.discountCondition;

import chapter02.step01.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
