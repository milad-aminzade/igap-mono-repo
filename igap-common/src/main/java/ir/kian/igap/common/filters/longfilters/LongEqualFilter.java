package ir.kian.igap.common.filters.longfilters;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractEqualFilter;

public class LongEqualFilter extends AbstractEqualFilter<Long> {
    public LongEqualFilter(String columnName, Long value, Filter filter) {
        super(columnName, value, filter);
    }
}
