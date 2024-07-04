package org.apache.dolphinscheduler.plugin.alert.wecom;

import org.apache.dolphinscheduler.alert.api.AlertChannel;
import org.apache.dolphinscheduler.alert.api.AlertData;
import org.apache.dolphinscheduler.alert.api.AlertInfo;
import org.apache.dolphinscheduler.alert.api.AlertResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public final class WeComAlertChannel implements AlertChannel {

    private static final Logger log = LoggerFactory.getLogger(WeComAlertChannel.class);

    @Override
    public AlertResult process(AlertInfo alertInfo) {
        AlertData alertData = alertInfo.getAlertData();
        Map<String, String> paramsMap = alertInfo.getAlertParams();
        if (null == paramsMap) {
            return new AlertResult("false", "weCom params is null");
        }
        log.info("paramsMap:{}===alertData:{}",paramsMap.toString(),alertData.toString());
        return new WeComSender(paramsMap).send(alertData.getContent());
    }
}