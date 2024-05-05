package ir.kian.igap.common.filters.joins;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractLessThanOrEqualJoinFilter;

import java.util.List;

public class LongLessThanJoinFilter extends AbstractLessThanOrEqualJoinFilter<Long> {
    public LongLessThanJoinFilter(List<String> columnName, Long value, Filter filter) {
        super(columnName, value, filter);
    }
}
