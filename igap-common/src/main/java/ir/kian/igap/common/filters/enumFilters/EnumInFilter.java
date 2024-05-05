package ir.kian.igap.common.filters.enumFilters;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractInFilter;

import java.util.List;

public class EnumInFilter<E extends Enum<E>> extends AbstractInFilter<E> {
    public EnumInFilter(String columnName, List<E> value, Filter filter) {
        super(columnName, value, filter);
    }
}
