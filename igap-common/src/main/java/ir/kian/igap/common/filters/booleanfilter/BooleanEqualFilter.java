package ir.kian.igap.common.filters.booleanfilter;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractEqualFilter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BooleanEqualFilter extends AbstractEqualFilter<Boolean> {
    public BooleanEqualFilter(String columnName, Boolean value, Filter filter) {
        super(columnName, value, filter);
    }
}
