package ir.kian.igap.common.filters;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class BaseFilterImpl extends Filter {
    @Override
    public List<Predicate> filters(CriteriaBuilder criteriaBuilder, Root root) {
        return new ArrayList<>();
    }
}
