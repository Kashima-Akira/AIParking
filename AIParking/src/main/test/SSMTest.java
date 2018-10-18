import com.xzy.mapper.ParkingMapper;
import com.xzy.pojo.mapping;
import com.xzy.pojo.userHistory;
import com.xzy.utils.CommonUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ♕ Prince on 2018/8/17.
 */
public class SSMTest
{

    @Test
    public void test()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        ParkingMapper bean=applicationContext.getBean(ParkingMapper.class);
        List<mapping> list=bean.selectMapping();
        System.out.println(list.toString());
    }
    @Test
    public void SearchTest()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        ParkingMapper bean=applicationContext.getBean(ParkingMapper.class);
        String value="钟楼";
        List<mapping> list=bean.SerachMapping(value);
        System.out.println(list.toString());

    }

    @Test
    public void test4()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        ParkingMapper bean=applicationContext.getBean(ParkingMapper.class);
        int id=1;
        bean.Bechoosen(id);
    }
    @Test
    public  void UserHistory()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        ParkingMapper bean=applicationContext.getBean(ParkingMapper.class);
        String uid="88166250";
        List<userHistory> History=bean.UserHistory(uid);
        System.out.println(History.toString());
    }
    @Test
    public void OpenID()
    {
        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

        String requestUrl = WX_URL.replace("APPID", "wx12311c8b49f755c2").replace("SECRET", "288a03e084edfc98e56b6017920cec8b")
                .replace("JSCODE", "0218ikrY0UaOb12iZiqY0H0drY08ikra").replace("authorization_code", "authorization_code");
        String  jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

        System.out.println(requestUrl);
        System.out.println( jsonObject);



    }
    @Test
    public void StringTest()
    {
        String URL;
        int start;
        String code="{\"session_key\":\"VeboPso+0RiAeX1ahXQC5w==\",\"openid\":\"o6dn05XUdo6FadipxXS5p6vPZE7Y\"}";

        System.out.println(code.indexOf("open"));

    }
    @Test
    public void repeatTest()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        ParkingMapper bean=applicationContext.getBean(ParkingMapper.class);
        String result;

        result= bean.openIdisnotRepeat("o6sdf");
        System.out.println(result);
    }
    @Test
    public void DateTest()
    {
        Date date=new Date();
        System.out.println(date.toString());
    }


}
