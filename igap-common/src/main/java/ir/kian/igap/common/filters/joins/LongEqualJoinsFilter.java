package ir.kian.igap.common.filters.joins;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractEqualJoinFilter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class LongEqualJoinsFilter extends AbstractEqualJoinFilter<Long> {

    public LongEqualJoinsFilter(List<String> joinColumns, Long value, Filter filter) {
        super(joinColumns, value, filter);
    }
}
