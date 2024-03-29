package com.toxind.benchmark.thrid.ibatis.abatordrag.test.dao;

import java.util.List;

import com.toxind.benchmark.thrid.ibatis.abatordrag.test.model.Test5;
import com.toxind.benchmark.thrid.ibatis.abatordrag.test.model.Test5Example;

public interface Test5DAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test5
     *
     * @abatorgenerated Thu Feb 16 14:01:40 CST 2012
     */
    void insert(Test5 record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test5
     *
     * @abatorgenerated Thu Feb 16 14:01:40 CST 2012
     */
    int updateByPrimaryKey(Test5 record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test5
     *
     * @abatorgenerated Thu Feb 16 14:01:40 CST 2012
     */
    int updateByPrimaryKeySelective(Test5 record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test5
     *
     * @abatorgenerated Thu Feb 16 14:01:40 CST 2012
     */
    List selectByExample(Test5Example example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test5
     *
     * @abatorgenerated Thu Feb 16 14:01:40 CST 2012
     */
    Test5 selectByPrimaryKey(Long id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test5
     *
     * @abatorgenerated Thu Feb 16 14:01:40 CST 2012
     */
    int deleteByExample(Test5Example example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test5
     *
     * @abatorgenerated Thu Feb 16 14:01:40 CST 2012
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test5
     *
     * @abatorgenerated Thu Feb 16 14:01:40 CST 2012
     */
    int countByExample(Test5Example example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test5
     *
     * @abatorgenerated Thu Feb 16 14:01:40 CST 2012
     */
    int updateByExampleSelective(Test5 record, Test5Example example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test5
     *
     * @abatorgenerated Thu Feb 16 14:01:40 CST 2012
     */
    int updateByExample(Test5 record, Test5Example example);
}