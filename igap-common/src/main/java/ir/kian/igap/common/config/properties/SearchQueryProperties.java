package ir.kian.igap.common.config.properties;

public class SearchQueryProperties extends BaseProperties {

    public static final String KEY_GROUP_NAME = "key";
    public static final String OPERATION_GROUP_NAME = "operation";
    public static final String VALUE_GROUP_NAME = "value";
    public static final String SEARCH_QUERY_REGEX = "(?<" + KEY_GROUP_NAME + ">\\w+?)(?<" + OPERATION_GROUP_NAME + ">:|<|>:)(?<" + VALUE_GROUP_NAME + ">\\w+),*";
    public static final char GREATER_THEN = '>';
    public static final char EQUAL = ':';
    public static final char LESS_THEN = '<';
}
