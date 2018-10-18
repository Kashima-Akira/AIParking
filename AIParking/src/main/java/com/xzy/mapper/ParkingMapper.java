package com.xzy.mapper;

import com.xzy.pojo.mapping;
import com.xzy.pojo.parking;
import com.xzy.pojo.userHistory;

import javax.naming.directory.SearchResult;
import java.util.List;
import java.util.Map;

/**
 * Created by ♕ Prince on 2018/8/6.
 */
public interface ParkingMapper
{

    public  void mappingUpdate(Map map);

    public void Bechoosen(Integer id);

    public List<mapping> SerachMapping(String value);

    public List<mapping> selectMapping();

    public List<userHistory> UserHistory(String uid);

    public void UserInsert(Map map);

    public void testData(String carId);

    public Integer StopParking();

    public String openIdisnotRepeat(String URL);

    public void userUpdate(Map map);

    public int ThreadStatus(int id);

    public  int upDateHistoryStart(Map map);


    public void upDateHistoryEnd(Map map);

}
