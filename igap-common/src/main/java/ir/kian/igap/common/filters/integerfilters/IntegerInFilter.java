package ir.kian.igap.common.filters.integerfilters;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractInFilter;

import java.util.List;

public class IntegerInFilter extends AbstractInFilter<Integer> {
    public IntegerInFilter(String columnName, List<Integer> value, Filter filter) {
        super(columnName, value, filter);
    }
}
