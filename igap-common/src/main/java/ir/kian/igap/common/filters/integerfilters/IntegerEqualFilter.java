package ir.kian.igap.common.filters.integerfilters;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractEqualFilter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IntegerEqualFilter extends AbstractEqualFilter<Integer> {
    public IntegerEqualFilter(String columnName, Integer value, Filter filter) {
        super(columnName, value, filter);
    }
}
