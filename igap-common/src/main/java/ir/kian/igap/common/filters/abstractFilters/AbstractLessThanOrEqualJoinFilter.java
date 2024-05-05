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
public abstract class AbstractLessThanOrEqualJoinFilter<T extends Comparable<T>> extends FilterDecorator {
    private T value;
    private Filter filter;
    private List<String> sortedJoinColumns;

    public AbstractLessThanOrEqualJoinFilter(List<String> sortedJoinColumns, T value, Filter filter) {
        this.sortedJoinColumns = sortedJoinColumns;
        this.value = value;
        this.filter = filter;
    }

    public List<Predicate> filters(CriteriaBuilder criteriaBuilder, Root root) {
        List<Predicate> filters = filter.filters(criteriaBuilder, root);
        if (value != null) {
            Path pathFromHierarchyJoin = HierarchyJoinPath.getPathFromHierarchyJoin(sortedJoinColumns, root);
            filters.add(criteriaBuilder.lessThanOrEqualTo(pathFromHierarchyJoin, value));
        }
        return filters;
    }
}
