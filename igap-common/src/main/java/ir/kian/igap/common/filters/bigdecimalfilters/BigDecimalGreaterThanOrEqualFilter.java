package ir.kian.igap.common.filters.bigdecimalfilters;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractGreaterThanOrEqualFilter;

import java.math.BigDecimal;

public class BigDecimalGreaterThanOrEqualFilter extends AbstractGreaterThanOrEqualFilter<BigDecimal> {
    public BigDecimalGreaterThanOrEqualFilter(String columnName, BigDecimal value, Filter filter) {
        super(columnName, value, filter);
    }
}
