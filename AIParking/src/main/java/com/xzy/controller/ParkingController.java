package com.xzy.controller;


import com.alibaba.dubbo.common.json.JSONObject;
import com.xzy.mapper.ParkingMapper;
import com.xzy.pojo.mapping;
import com.xzy.pojo.parking;
import com.xzy.pojo.userHistory;
import com.xzy.utils.CommonUtil;
import com.xzy.utils.OpenIDUtils;
import com.xzy.utils.TestUDP;
import org.apache.ibatis.annotations.Param;
import org.apache.zookeeper.Op;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ♕ Prince on 2018/8/6.
 */
@Controller
public class ParkingController


{
    @Autowired
    private ParkingMapper parkingMapper;

    private Integer count=0;



    @RequestMapping(value = "/selectMapping")
    @ResponseBody
    public List<mapping> selectMapping()
    {

        return parkingMapper.selectMapping();
    }


    @RequestMapping(value = "/Bechoosen")
    @ResponseBody
    public void Bechoosen(Integer id)
    {
        parkingMapper.Bechoosen(id);
    }

    @RequestMapping(value ="StopParking")
    @ResponseBody
    public Integer StopParking()
    {
        return  parkingMapper.StopParking();
    }



    @RequestMapping(value = "/SerachMapping")
    @ResponseBody
    public List<mapping> SerachMapping(String value)
    {
        if(value==null)
            return null;
        else
        return parkingMapper.SerachMapping(value);
    }


    @RequestMapping(value = "/testData")
    @ResponseBody
            public void testData(String carId)
    {
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");

        System.out.println(carId);
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("===============================================");

    }
   /*@ResponseBody
    @RequestMapping(value = "/getOpenId", method = RequestMethod.GET) // 获取用户信息
    public String getOpenId(@Param("code") String code, @RequestParam("headurl") String headurl,
                            @RequestParam("nickname") String nickname, @RequestParam("sex") String sex,
                            @RequestParam("country") String country, @RequestParam("province") String province,
                            @RequestParam("city") String city) {
        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

        St  ring requestUrl = WX_URL.replace("APPID", WxConfig.APPID).replace("SECRET", WxConfig.APPSECRECT)
                .replace("JSCODE", code).replace("authorization_code", WxConfig.GRANTTYPE);
        String  jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

    return jsonObject;
    }*/

    @RequestMapping(value = "/UserHistory",method =RequestMethod.GET)
    @ResponseBody
    public List<userHistory> UserHistory(String OpenID)
    {
        //String OpenID;
        //OpenID=OpenIDUtils.getOpen(code);
        return   parkingMapper.UserHistory(OpenID);


    }

    @RequestMapping(value = "/Login")
    @ResponseBody
    public void UserInsert(String code)
    {

        String OpenID = null;

        System.out.println("==================================================");
        System.out.println("==================================================");
        System.out.println("==================================================");
        System.out.println("code"+code);


        OpenID= OpenIDUtils.getOpen(code);
        System.out.println(OpenID);
        Map map=new HashMap();
        map.put("openID",OpenID);

        if(null!=parkingMapper.openIdisnotRepeat(OpenID))
        parkingMapper.UserInsert(map);
        else
            {
            parkingMapper.userUpdate(map);
            }

    }
    @RequestMapping(value = "/upDateHistoryStart")
    @ResponseBody
    public  int upDateHistoryStart(String OpenID, String mapId, String start_time)
    {
        count+=1;
        Map map=new HashMap();
        map.put("user_id",OpenID);
        map.put("map_id",mapId);
        map.put("start_time",start_time);
        map.put("id",count);
        parkingMapper.upDateHistoryStart(map);

        return count;
    }
    @RequestMapping(value = "/ThreadStatus")
    @ResponseBody
    public int ThreadStatus(int id)
    {
        return parkingMapper.ThreadStatus(id);
    }

    @RequestMapping(value = "/ServerStart")
    @ResponseBody
    public void ServerStart() throws Exception
    {
        TestUDP testUDP=new TestUDP();
       // testUDP.doStart();
    }
    @RequestMapping(value = "/upDateHistoryEnd")
    @ResponseBody
    public void upDateHistoryEnd(String endTime,int count,int payStatus,String price)
    {
        Map map=new HashMap();
        map.put("endTime",endTime);
        map.put("id",count);
        map.put("payStatus",payStatus);
        map.put("price",price);
        parkingMapper.upDateHistoryEnd(map);
    }


}
