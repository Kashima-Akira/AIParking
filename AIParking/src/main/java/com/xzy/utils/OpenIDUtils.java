package com.xzy.utils;

/**
 * Created by ♕ Prince on 2018/8/20.
 */
public   class OpenIDUtils
{
    public static  String getOpen(String code)
    {
        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

        String requestUrl = WX_URL.replace("APPID", "wx12311c8b49f755c2").replace("SECRET", "288a03e084edfc98e56b6017920cec8b")
                .replace("JSCODE", code).replace("authorization_code", "authorization_code");
        String  jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

        System.out.println(requestUrl);
        System.out.println( jsonObject);

        String OpenID;
        int start;
        if(jsonObject.indexOf("openid")==-1)
        {
            return null;
        }
        start=jsonObject.indexOf("openid")+9;
        OpenID=jsonObject.substring(start,jsonObject.length()-2);

        return OpenID;
    }
}
