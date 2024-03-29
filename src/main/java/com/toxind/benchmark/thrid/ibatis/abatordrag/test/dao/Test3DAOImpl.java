package com.toxind.benchmark.thrid.ibatis.abatordrag.test.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.toxind.benchmark.thrid.ibatis.abatordrag.test.model.Test3;
import com.toxind.benchmark.thrid.ibatis.abatordrag.test.model.Test3Example;
@Repository
public class Test3DAOImpl extends SqlMapClientDaoSupport implements Test3DAO {

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test3
     *
     * @abatorgenerated Thu Feb 16 14:01:18 CST 2012
     */
    public Test3DAOImpl() {
        super();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test3
     *
     * @abatorgenerated Thu Feb 16 14:01:18 CST 2012
     */
    public void insert(Test3 record) {
        getSqlMapClientTemplate().insert("test3.abatorgenerated_insert", record);
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test3
     *
     * @abatorgenerated Thu Feb 16 14:01:18 CST 2012
     */
    public int updateByPrimaryKey(Test3 record) {
        int rows = getSqlMapClientTemplate().update("test3.abatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test3
     *
     * @abatorgenerated Thu Feb 16 14:01:18 CST 2012
     */
    public int updateByPrimaryKeySelective(Test3 record) {
        int rows = getSqlMapClientTemplate().update("test3.abatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test3
     *
     * @abatorgenerated Thu Feb 16 14:01:18 CST 2012
     */
    public List selectByExample(Test3Example example) {
        List list = getSqlMapClientTemplate().queryForList("test3.abatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test3
     *
     * @abatorgenerated Thu Feb 16 14:01:18 CST 2012
     */
    public Test3 selectByPrimaryKey(Long id) {
        Test3 key = new Test3();
        key.setId(id);
        Test3 record = (Test3) getSqlMapClientTemplate().queryForObject("test3.abatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test3
     *
     * @abatorgenerated Thu Feb 16 14:01:18 CST 2012
     */
    public int deleteByExample(Test3Example example) {
        int rows = getSqlMapClientTemplate().delete("test3.abatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test3
     *
     * @abatorgenerated Thu Feb 16 14:01:18 CST 2012
     */
    public int deleteByPrimaryKey(Long id) {
        Test3 key = new Test3();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("test3.abatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test3
     *
     * @abatorgenerated Thu Feb 16 14:01:18 CST 2012
     */
    public int countByExample(Test3Example example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("test3.abatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test3
     *
     * @abatorgenerated Thu Feb 16 14:01:18 CST 2012
     */
    public int updateByExampleSelective(Test3 record, Test3Example example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("test3.abatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table test3
     *
     * @abatorgenerated Thu Feb 16 14:01:18 CST 2012
     */
    public int updateByExample(Test3 record, Test3Example example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("test3.abatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table test3
     *
     * @abatorgenerated Thu Feb 16 14:01:18 CST 2012
     */
    private static class UpdateByExampleParms extends Test3Example {
        private Object record;

        public UpdateByExampleParms(Object record, Test3Example example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}