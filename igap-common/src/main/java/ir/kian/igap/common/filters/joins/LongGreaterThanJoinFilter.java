package ir.kian.igap.common.filters.joins;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractGreaterThanOrEqualJoinFilter;

import java.util.List;

public class LongGreaterThanJoinFilter extends AbstractGreaterThanOrEqualJoinFilter<Long> {
    public LongGreaterThanJoinFilter(List<String> columnName, Long value, Filter filter) {
        super(columnName, value, filter);
    }
}
