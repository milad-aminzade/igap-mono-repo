package ir.kian.igap.common.filters.joins;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractInJoinFilter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class LongInJoinsFilter extends AbstractInJoinFilter<Long> {
    public LongInJoinsFilter(List<String> joinColumns, List<Long> values, Filter filter) {
        super(joinColumns, values, filter);
    }
}
