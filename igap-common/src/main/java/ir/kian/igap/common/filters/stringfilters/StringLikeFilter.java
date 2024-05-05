package ir.kian.igap.common.filters.stringfilters;


import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.abstractFilters.AbstractLikeFilter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StringLikeFilter extends AbstractLikeFilter {
    public StringLikeFilter(String columnName, String value, Filter filter) {
        super(columnName, value, filter);
    }

}
