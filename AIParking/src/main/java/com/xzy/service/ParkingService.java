package com.xzy.service;

import com.xzy.pojo.mapping;
import com.xzy.pojo.parking;
import com.xzy.pojo.userHistory;

import java.util.List;
import java.util.Map;

/**
 * Created by ♕ Prince on 2018/8/6.
 */

public interface ParkingService
{
       void mappingUpdate(Map map);

       void Bechoosen(Integer id);

       List<mapping> SerachMapping(String value);

      List<mapping> selectMapping();

      List<userHistory> UserHistory(String uid);

      void UserInsert(Map map);

      void testData(String carId);

      int ThreadStatus(int id);

}
