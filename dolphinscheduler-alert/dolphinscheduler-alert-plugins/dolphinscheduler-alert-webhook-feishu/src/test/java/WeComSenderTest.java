import org.apache.dolphinscheduler.plugin.alert.webhook.WebHookFeiShuAlertConstants;
import org.apache.dolphinscheduler.plugin.alert.webhook.WebHookFeiShuSender;
import org.junit.Test;

import java.util.HashMap;

public class WeComSenderTest {
    @Test
    public void sendTest(){
//        String mapStr="[{headerParams=null, url=\"https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=e697b7c0-86a5-4c9a-9914-f2bccae9c21a\"}]";

        String Content = "[{\"projectCode\":12966940544096,\"projectName\":\"OUT_FLOW\",\"owner\":\"admin\",\"processId\":29,\"processDefinitionCode\":12979698800352,\"processName\":\"Test-3-20240322101253566\",\"taskCode\":12992500940896,\"taskName\":\"OVER_CALL_BACK\",\"taskType\":\"SHELL\",\"taskState\":\"FAILURE\",\"taskStartTime\":\"2024-03-22 10:12:55\",\"taskEndTime\":\"2024-03-22 10:12:55\",\"taskHost\":\"172.19.110.14:1234\",\"logPath\":\"/data/app/dolphinscheduler/worker-server/logs/20240322/12979698800352_3-29-96.log\"}]";
//        Map<String, String> map = JSONUtils.toMap(mapStr);
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(WebHookFeiShuAlertConstants.HEADER_PARAMS,"{\"Content-Type\": \"application/json\"}");
        objectObjectHashMap.put("url","https://open.feishu.cn/open-apis/bot/v2/hook/5ed3791e-ad71-4965-8cc5-091853eef688");
        new WebHookFeiShuSender(objectObjectHashMap).send(Content);
    }


}
