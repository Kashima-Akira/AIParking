package com.xzy.service.serviceImp;

import com.xzy.mapper.ParkingMapper;
import com.xzy.pojo.User;
import com.xzy.pojo.mapping;
import com.xzy.pojo.parking;
import com.xzy.pojo.userHistory;
import com.xzy.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
/**
 * Created by ♕ Prince on 2018/8/6.
 */
public class ParkingServiceImp implements ParkingService
{

    @Autowired
    private ParkingMapper parkingMapper;


    @Override
    public void mappingUpdate(Map map)
    {

    }

    @Override
    public void Bechoosen(Integer id)
    {

    }

    @Override
    public List<mapping> SerachMapping(String value)
    {
        return parkingMapper.SerachMapping(value);
    }

    @Override
    public List<mapping> selectMapping() {
        return parkingMapper.selectMapping();
    }

    @Override
    public List<userHistory> UserHistory(String uid) {
        return parkingMapper.UserHistory(uid);
    }

    @Override
    public void UserInsert(Map map)
    {
        System.out.println(map);
    }

    @Override
    public void testData(String carId) {
        System.out.println(carId);
    }

    @Override
    public int ThreadStatus(int id)
    {
        return 0;
    }


}
