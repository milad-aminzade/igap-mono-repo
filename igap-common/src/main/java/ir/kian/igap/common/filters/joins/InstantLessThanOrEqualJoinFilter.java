package ir.kian.igap.common.filters.joins;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractLessThanOrEqualJoinFilter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class InstantLessThanOrEqualJoinFilter extends AbstractLessThanOrEqualJoinFilter<Long> {

    public InstantLessThanOrEqualJoinFilter(List<String> joinColumns, Long value, Filter filter) {
        super(joinColumns, value, filter);

    }
}
