package org.apache.dolphinscheduler.plugin.alert.webhook;

import com.google.auto.service.AutoService;
import org.apache.dolphinscheduler.alert.api.AlertChannel;
import org.apache.dolphinscheduler.alert.api.AlertChannelFactory;
import org.apache.dolphinscheduler.spi.params.base.PluginParams;
import org.apache.dolphinscheduler.spi.params.base.Validate;
import org.apache.dolphinscheduler.spi.params.input.InputParam;

import java.util.Arrays;
import java.util.List;

@AutoService(AlertChannelFactory.class)
public final class WebHookFeiShuAlertChannelFactory implements AlertChannelFactory {
    @Override
    public String name() {
        return "WebHookFeiShu";
    }

    @Override
    public List<PluginParams> params() {

        InputParam url = InputParam.newBuilder(WebHookFeiShuAlertConstants.URL, WebHookFeiShuAlertConstants.URL)
                .addValidate(Validate.newBuilder()
                        .setRequired(true)
                        .build())
                .build();

        InputParam headerParams = InputParam.newBuilder(WebHookFeiShuAlertConstants.HEADER_PARAMS, WebHookFeiShuAlertConstants.HEADER_PARAMS)
                .addValidate(Validate.newBuilder()
                        .setRequired(false)
                        .build())
                .build();

        return Arrays.asList(url, headerParams);
    }

    @Override
    public AlertChannel create() {
        return new WebHookFeiShuAlertChannel();
    }
}
