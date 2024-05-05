package ir.kian.igap.common.filters.abstractFilters;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.FilterDecorator;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractLikeFilter extends FilterDecorator {
    private String columnName;
    private String value;
    private Filter filter;

    @Override
    public List<Predicate> filters(CriteriaBuilder criteriaBuilder, Root root) {
        List<Predicate> filters = filter.filters(criteriaBuilder, root);
        if (value != null)
            filters.add(criteriaBuilder.like(root.get(columnName), "%" + value + "%"));
        return filters;
    }
}
