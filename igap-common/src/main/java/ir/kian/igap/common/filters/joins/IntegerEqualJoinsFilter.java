package ir.kian.igap.common.filters.joins;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractEqualJoinFilter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class IntegerEqualJoinsFilter extends AbstractEqualJoinFilter<Integer> {

    public IntegerEqualJoinsFilter(List<String> joinColumns, Integer value, Filter filter) {
        super(joinColumns, value, filter);

    }
}
