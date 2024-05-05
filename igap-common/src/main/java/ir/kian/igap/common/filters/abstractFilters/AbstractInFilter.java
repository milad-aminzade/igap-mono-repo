package ir.kian.igap.common.filters.abstractFilters;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.FilterDecorator;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public abstract class AbstractInFilter<T extends Comparable<T>> extends FilterDecorator {
    private List<T> values;
    private Filter filter;
    private String columnName;

    public AbstractInFilter(String columnName, List<T> value, Filter filter) {
        this.columnName = columnName;
        this.values = value;
        this.filter = filter;
    }

    public List<Predicate> filters(CriteriaBuilder criteriaBuilder, Root root) {
        List<Predicate> filters = filter.filters(criteriaBuilder, root);
        if (values != null && !values.isEmpty()) {
            Path path = root.get(columnName);
            filters.add(path.in(values));
        }
        return filters;
    }
}
