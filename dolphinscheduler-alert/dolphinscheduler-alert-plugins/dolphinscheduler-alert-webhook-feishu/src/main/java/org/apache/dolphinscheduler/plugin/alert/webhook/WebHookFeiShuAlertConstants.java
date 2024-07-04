package org.apache.dolphinscheduler.plugin.alert.webhook;

public final class WebHookFeiShuAlertConstants {
    public static final String URL = "url";

    public static final String HEADER_PARAMS = "headerParams";

    public static final String BODY_PARAMS = "{\n" +
            "        \"msg_type\": \"interactive\",\n" +
            "        \"card\": {\n" +
            "            \"header\": {\n" +
            "                \"title\": {\n" +
            "                    \"content\": \"数据流告警提醒\",\n" +
            "                    \"tag\": \"plain_text\"\n" +
            "                }\n" +
            "            },"+
            "            \"elements\": [{\n" +
            "                \"tag\": \"div\",\n" +
            "                \"text\": {\n" +
            "                    \"tag\": \"lark_md\",\n" +
            "                    \"content\": \"\"\n" +
            "                }\n" +
            "            }]\n" +
            "        }\n" +
            "    }";

    public static final String CONTENT_FIELD = "card.elements.0.text.content";

    private WebHookFeiShuAlertConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
