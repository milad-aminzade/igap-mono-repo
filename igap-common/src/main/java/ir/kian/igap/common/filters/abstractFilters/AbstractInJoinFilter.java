package ir.kian.igap.common.filters.abstractFilters;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.FilterDecorator;
import ir.kian.igap.common.utils.HierarchyJoinPath;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public abstract class AbstractInJoinFilter<T extends Comparable<T>> extends FilterDecorator {
    private List<T> values;
    private Filter filter;
    private List<String> sortedJoinColumns;

    public AbstractInJoinFilter(List<String> sortedJoinColumns, List<T> value, Filter filter) {
        this.sortedJoinColumns = sortedJoinColumns;
        this.values = value;
        this.filter = filter;
    }

    public List<Predicate> filters(CriteriaBuilder criteriaBuilder, Root root) {
        List<Predicate> filters = filter.filters(criteriaBuilder, root);
        if (values != null && !values.isEmpty()) {
            Path pathFromHierarchyJoin = HierarchyJoinPath.getPathFromHierarchyJoin(sortedJoinColumns, root);
            filters.add(pathFromHierarchyJoin.in(values));
        }
        return filters;
    }
}
