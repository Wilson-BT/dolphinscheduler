package org.apache.dolphinscheduler.plugin.alert.webhook;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.dolphinscheduler.alert.api.AlertResult;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class WebHookFeiShuSender {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(WebHookFeiShuSender.class);
    private static final String DEFAULT_CHARSET = "utf-8";
    private final String headerParams;
    private final Integer TIMEOUT = 10000;
    private String url;
    private HttpRequest httpRequest;

    public WebHookFeiShuSender(Map<String, String> paramsMap) {
        url = paramsMap.get(WebHookFeiShuAlertConstants.URL);
        headerParams = paramsMap.get(WebHookFeiShuAlertConstants.HEADER_PARAMS);
    }

    public AlertResult send(String msg) {
        httpRequest = HttpRequest.post(url).timeout(TIMEOUT).charset(DEFAULT_CHARSET).contentType("application/json");
        AlertResult alertResult = new AlertResult();
        // 生成http远程请求相关
        try {
            JSONObject bodyJson = JSONUtil.parseObj(WebHookFeiShuAlertConstants.BODY_PARAMS);

            // 格式数据为企业微信markdown的数据内容
            // 通知信息内容
            if (StrUtil.isNotBlank(msg)) {
                JSONArray jsonArray = JSONUtil.parseArray(msg);
                jsonArray.forEach(x -> {

                    JSONObject object = (JSONObject) x;
                    Set<Map.Entry<String, Object>> entries = object.entrySet();
                    StringBuffer stringBuffer = new StringBuffer();
                    for (Map.Entry<String, Object> entry : entries){
                        stringBuffer.append(String.format("**%s**: %s", entry.getKey(),entry.getValue())).append("\n");
                    }
                    bodyJson.putByPath(WebHookFeiShuAlertConstants.CONTENT_FIELD, stringBuffer.toString());
                    String resp = "";
                    try {
                        if (StrUtil.isNotBlank(headerParams)) {
                            HashMap hashMap = JSONUtil.toBean(headerParams, HashMap.class);
                            if(!hashMap.isEmpty()){
                                httpRequest.headerMap(hashMap, true);
                            }
                        }
                        String jsonStr = JSONUtil.toJsonStr(bodyJson);
                        System.out.println(jsonStr);
                        httpRequest.body(jsonStr);
                        resp = httpRequest.execute().body();
                    } catch (Exception e) {
                        log.error("send WeCom alert msg  exception : {}", e.getMessage());
                    }
                    // 设置header
                    alertResult.setStatus("true");
                    alertResult.setMessage(resp);
                });
            }

        } catch (Exception e) {
            System.out.println(e);
            log.error("send WeCom msg exception : {}", e.toString());
            alertResult.setStatus("false");
            alertResult.setMessage("send WeCom request alert fail.");
        }
        return alertResult;
    }
    /**
     * 根据jsonObject生成对应企微markDown文本
     *
     * @param jsonObject
     * @return
     */
    private String getMarkDownMsg(JSONObject jsonObject) {
        if (null == jsonObject) {
            return null;
        }
        Set<String> keySet = jsonObject.keySet();
        StringBuffer stringBuffer = new StringBuffer();
        keySet.forEach(key -> {
            stringBuffer.append(">" + key + ":<font color=\"comment\">" + jsonObject.getStr(key) + "</font>\n");
        });
        return stringBuffer.toString();
    }
    @Override
    public String toString() {
        return "WeComSender{" +
                "headerParams='" + headerParams + '\'' +
                ", TIMEOUT=" + TIMEOUT +
                ", url='" + url + '\'' +
                ", httpRequest=" + httpRequest +
                '}';
    }
}
