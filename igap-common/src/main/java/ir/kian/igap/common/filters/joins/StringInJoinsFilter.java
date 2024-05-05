package ir.kian.igap.common.filters.joins;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractInJoinFilter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class StringInJoinsFilter extends AbstractInJoinFilter<String> {

    public StringInJoinsFilter(List<String> joinColumns, List<String> values, Filter filter) {
        super(joinColumns, values, filter);
    }
}
