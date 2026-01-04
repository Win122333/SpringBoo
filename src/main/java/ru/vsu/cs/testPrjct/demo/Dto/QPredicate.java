package ru.vsu.cs.testPrjct.demo.Dto;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QPredicate {
    private List<Predicate> predicates;

    public static QPredicate builder() {
        return new QPredicate();
    }

    public <T> QPredicate add(T obj, Function<T, Predicate> func) {
        if (obj != null) {
            predicates.add(func.apply(obj));
        }
        return this;
    }

    public Predicate buildAnd() {
        return ExpressionUtils.allOf(predicates);
    }

    public Predicate buildOr() {
        return ExpressionUtils.anyOf(predicates);
    }
}
