package org.apache.dolphinscheduler.plugin.alert.wecom;

public final class WeComAlertConstants {
    public static final String URL = "url";

    public static final String HEADER_PARAMS = "headerParams";

    public static final String BODY_PARAMS = "{\"msgtype\":\"markdown\",\"markdown\":{\"content\":\"\",\"mentioned_mobile_list\":[]}}";

    public static final String CONTENT_FIELD = "markdown.content";

    private WeComAlertConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
