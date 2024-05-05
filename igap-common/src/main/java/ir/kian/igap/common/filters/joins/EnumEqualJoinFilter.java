package ir.kian.igap.common.filters.joins;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractEqualJoinFilter;

import java.util.List;

public class EnumEqualJoinFilter<E extends Enum<E>> extends AbstractEqualJoinFilter<E> {
    public EnumEqualJoinFilter(List<String> joinColumns, E value, Filter filter) {
        super(joinColumns, value, filter);

    }
}
