package ir.kian.igap.common.filters.joins;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractGreaterThanOrEqualJoinFilter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class InstantGreaterThanOrEqualJoinFilter extends AbstractGreaterThanOrEqualJoinFilter<Long> {

    public InstantGreaterThanOrEqualJoinFilter(List<String> joinColumns, Long value, Filter filter) {
        super(joinColumns, value, filter);
    }
}
