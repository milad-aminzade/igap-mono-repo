package ir.kian.igap.common.filters.joins;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractEqualJoinFilter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class StringEqualJoinsFilter extends AbstractEqualJoinFilter<String> {

    public StringEqualJoinsFilter(List<String> joinColumns, String value, Filter filter) {
        super(joinColumns, value, filter);

    }
}
