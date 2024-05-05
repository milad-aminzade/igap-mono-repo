package ir.kian.igap.common.config.properties;

public class SortQueryProperties extends BaseProperties {

    public static final String DIRECTION_GROUP_NAME = "direction";
    public static final String KEY_GROUP_NAME = "key";
    public static final String SORT_QUERY_REGEX = "(?<" + DIRECTION_GROUP_NAME + ">ask|desk)[(](?<" + KEY_GROUP_NAME + ">\\w+?)[)],*";
    public static final String ASK = "ask";
    public static final String DESK = "desk";

}
