package ir.kian.igap.common.filters.integerfilters;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractLessThanOrEqualFilter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IntegerLessThanOrEqualFilter extends AbstractLessThanOrEqualFilter<Integer> {

    public IntegerLessThanOrEqualFilter(String columnName, Integer value, Filter filter) {
        super(columnName, value, filter);
    }


}
