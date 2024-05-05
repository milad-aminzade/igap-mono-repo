package ir.kian.igap.common.filters.integerfilters;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractGreaterThanOrEqualFilter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IntegerGreaterThanOrEqual extends AbstractGreaterThanOrEqualFilter<Integer> {
    public IntegerGreaterThanOrEqual(String columnName, Integer value, Filter filter) {
        super(columnName, value, filter);
    }
}
