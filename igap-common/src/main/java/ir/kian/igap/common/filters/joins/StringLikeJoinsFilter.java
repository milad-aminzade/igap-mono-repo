package ir.kian.igap.common.filters.joins;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractLikeJoinFilter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class StringLikeJoinsFilter extends AbstractLikeJoinFilter {
    public StringLikeJoinsFilter(List<String> joinColumns, String value, Filter filter) {
        super(joinColumns, value, filter);
    }
}
