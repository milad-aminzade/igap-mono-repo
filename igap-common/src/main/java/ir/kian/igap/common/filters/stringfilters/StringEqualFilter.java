package ir.kian.igap.common.filters.stringfilters;

import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractEqualFilter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StringEqualFilter extends AbstractEqualFilter<String> {

    public StringEqualFilter(String columnName, String value, Filter filter) {
        super(columnName, value, filter);
    }

}
