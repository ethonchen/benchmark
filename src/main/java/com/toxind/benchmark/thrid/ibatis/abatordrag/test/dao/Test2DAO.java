package com.toxind.benchmark.thrid.ibatis.abatordrag.test.dao;

import java.util.List;

import com.toxind.benchmark.thrid.ibatis.abatordrag.test.model.Test2;
import com.toxind.benchmark.thrid.ibatis.abatordrag.test.model.Test2Example;

public interface Test2DAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test2
     *
     * @abatorgenerated Thu Feb 16 14:01:07 CST 2012
     */
    void insert(Test2 record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test2
     *
     * @abatorgenerated Thu Feb 16 14:01:07 CST 2012
     */
    int updateByPrimaryKey(Test2 record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test2
     *
     * @abatorgenerated Thu Feb 16 14:01:07 CST 2012
     */
    int updateByPrimaryKeySelective(Test2 record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test2
     *
     * @abatorgenerated Thu Feb 16 14:01:07 CST 2012
     */
    List selectByExample(Test2Example example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test2
     *
     * @abatorgenerated Thu Feb 16 14:01:07 CST 2012
     */
    Test2 selectByPrimaryKey(Long id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test2
     *
     * @abatorgenerated Thu Feb 16 14:01:07 CST 2012
     */
    int deleteByExample(Test2Example example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test2
     *
     * @abatorgenerated Thu Feb 16 14:01:07 CST 2012
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test2
     *
     * @abatorgenerated Thu Feb 16 14:01:07 CST 2012
     */
    int countByExample(Test2Example example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test2
     *
     * @abatorgenerated Thu Feb 16 14:01:07 CST 2012
     */
    int updateByExampleSelective(Test2 record, Test2Example example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test2
     *
     * @abatorgenerated Thu Feb 16 14:01:07 CST 2012
     */
    int updateByExample(Test2 record, Test2Example example);
}