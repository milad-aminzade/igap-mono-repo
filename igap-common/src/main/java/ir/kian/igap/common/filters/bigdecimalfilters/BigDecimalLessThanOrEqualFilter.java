package ir.kian.igap.common.filters.bigdecimalfilters;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractLessThanOrEqualFilter;

import java.math.BigDecimal;

public class BigDecimalLessThanOrEqualFilter extends AbstractLessThanOrEqualFilter<BigDecimal> {
    public BigDecimalLessThanOrEqualFilter(String columnName, BigDecimal value, Filter filter) {
        super(columnName, value, filter);
    }
}
