package ir.kian.igap.common.filters;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public abstract class FilterDecorator extends Filter {
    public abstract List<Predicate> filters(CriteriaBuilder criteriaBuilder, Root root);
}
