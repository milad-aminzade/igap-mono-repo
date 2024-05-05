package ir.kian.igap.common.filters.enumFilters;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractEqualFilter;

public class EnumEqualFilter<E extends Enum<E>> extends AbstractEqualFilter<E> {
    public EnumEqualFilter(String columnName, E value, Filter filter) {
        super(columnName, value, filter);
    }
}
