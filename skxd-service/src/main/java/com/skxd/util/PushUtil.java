package com.skxd.util;

import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PushUtil {


    private static String secret = "6fa0a34f1028a149f9efafc6";
    private static String key = "c7df874427cb72a21712f7bc";

    public static void sendPush(String title, String content,List<String> alias) {

        try {
            ClientConfig clientConfig = ClientConfig.getInstance();
            JPushClient jpushClient = new JPushClient(secret, key, null, clientConfig);
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(PlatformNotification.class, new InterfaceAdapter<PlatformNotification>())
                    .create();

            PushPayload payload = buildPushObject_android_and_ios(title, content,alias);

            PushResult result = jpushClient.sendPush(payload);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static PushPayload buildPushObject_android_and_ios(String title, String content,List<String> alias) {
        Map<String, String> extras = new HashMap<String, String>();
        //extras.put("test", "https://community.jiguang.cn/push");
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.newBuilder()
                        .setAlert(content)
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setTitle(title)
                                .addExtras(extras).build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .incrBadge(1)
                                .addExtra("extra_key", "extra_value").build())
                        .build())
                .build();
    }
}
