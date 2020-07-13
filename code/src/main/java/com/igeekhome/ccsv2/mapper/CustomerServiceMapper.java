package com.igeekhome.ccsv2.mapper;

import com.igeekhome.ccsv2.entity.CustomerService;
import com.igeekhome.ccsv2.entity.CustomerServiceGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerServiceMapper {

    /**
     * 新增(注册)客服信息
     */
    int save(CustomerService cs);

    /**
     * 根据id、电话、姓名等条件查询，实现客服信息模糊查询
     */
    List<CustomerService> queryFuzzy(CustomerService cs);

    /**
     * 根据客服组别，返回客服集合对象
     */
    List<CustomerService> showByGroup(CustomerServiceGroup group);

    /**
     * 根据某一客服原信息 oldcs，替换为该客服新的信息 newcs，也可修改主键客服id
     */
    int update(@Param("oldcs") CustomerService oldcs, @Param("newcs") CustomerService newcs);

    int updatePwd(CustomerService cs);

    HashMap<String, String> findPwd(CustomerService cs);

    int deleteById(int id);//删除单个
    int deleteBatch(List<Integer> ids);//批量删除

    CustomerService getOne(CustomerService cs);

    List<CustomerService> queryWorkload(CustomerService cs);

    List<CustomerService> queryCheckingIn(CustomerService cs);
}
