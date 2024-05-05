package ir.kian.igap.common.filters.joins;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractInJoinFilter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class IntegerInJoinFilter extends AbstractInJoinFilter<Integer> {
    public IntegerInJoinFilter(List<String> joinColumns, List<Integer> values, Filter filter) {
        super(joinColumns, values, filter);
    }
}
