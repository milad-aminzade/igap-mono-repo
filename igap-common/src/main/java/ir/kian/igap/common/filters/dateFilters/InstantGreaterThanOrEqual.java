package ir.kian.igap.common.filters.dateFilters;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractGreaterThanOrEqualFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class InstantGreaterThanOrEqual extends AbstractGreaterThanOrEqualFilter<Long> {
    private final String columnName;
    private final Long value;
    private final Filter filter;

    public InstantGreaterThanOrEqual(String columnName, Long value, Filter filter) {
        super(columnName, value, filter);
        this.columnName = columnName;
        this.value = value;
        this.filter = filter;
    }

    @Override
    public List<Predicate> filters(CriteriaBuilder criteriaBuilder, Root root) {
        List<Predicate> filters = filter.filters(criteriaBuilder, root);
        if (value != null)
            filters.add(criteriaBuilder.greaterThanOrEqualTo(root.get(columnName), value));
        return filters;
    }
}
