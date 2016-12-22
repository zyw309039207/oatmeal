package com.mozovw.oatmeal.test.llr.tempout.dao;

import com.mozovw.oatmeal.common.annotation.MybaitsDao;
import com.mozovw.oatmeal.test.llr.tempout.entity.MeTempDataEntity;


@MybaitsDao
public interface TempOutDao {
	MeTempDataEntity queryAllTempDate(String llrId);
}
