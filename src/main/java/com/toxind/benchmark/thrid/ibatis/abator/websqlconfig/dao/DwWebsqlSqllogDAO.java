package com.toxind.benchmark.thrid.ibatis.abator.websqlconfig.dao;

import java.math.BigDecimal;
import java.util.List;

import com.toxind.benchmark.thrid.ibatis.abator.websqlconfig.model.DwWebsqlSqllog;
import com.toxind.benchmark.thrid.ibatis.abator.websqlconfig.model.DwWebsqlSqllogExample;

public interface DwWebsqlSqllogDAO {
    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table TIANXUAN.DW_WEBSQL_SQLLOG
     *
     * @abatorgenerated Thu Feb 16 11:07:25 CST 2012
     */
    void insert(DwWebsqlSqllog record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table TIANXUAN.DW_WEBSQL_SQLLOG
     *
     * @abatorgenerated Thu Feb 16 11:07:25 CST 2012
     */
    int updateByPrimaryKeyWithoutBLOBs(DwWebsqlSqllog record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table TIANXUAN.DW_WEBSQL_SQLLOG
     *
     * @abatorgenerated Thu Feb 16 11:07:25 CST 2012
     */
    int updateByPrimaryKeyWithBLOBs(DwWebsqlSqllog record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table TIANXUAN.DW_WEBSQL_SQLLOG
     *
     * @abatorgenerated Thu Feb 16 11:07:25 CST 2012
     */
    int updateByPrimaryKeySelective(DwWebsqlSqllog record);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table TIANXUAN.DW_WEBSQL_SQLLOG
     *
     * @abatorgenerated Thu Feb 16 11:07:25 CST 2012
     */
    List selectByExampleWithoutBLOBs(DwWebsqlSqllogExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table TIANXUAN.DW_WEBSQL_SQLLOG
     *
     * @abatorgenerated Thu Feb 16 11:07:25 CST 2012
     */
    List selectByExampleWithBLOBs(DwWebsqlSqllogExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table TIANXUAN.DW_WEBSQL_SQLLOG
     *
     * @abatorgenerated Thu Feb 16 11:07:25 CST 2012
     */
    DwWebsqlSqllog selectByPrimaryKey(BigDecimal sqlId);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table TIANXUAN.DW_WEBSQL_SQLLOG
     *
     * @abatorgenerated Thu Feb 16 11:07:25 CST 2012
     */
    int deleteByExample(DwWebsqlSqllogExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table TIANXUAN.DW_WEBSQL_SQLLOG
     *
     * @abatorgenerated Thu Feb 16 11:07:25 CST 2012
     */
    int deleteByPrimaryKey(BigDecimal sqlId);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table TIANXUAN.DW_WEBSQL_SQLLOG
     *
     * @abatorgenerated Thu Feb 16 11:07:25 CST 2012
     */
    int countByExample(DwWebsqlSqllogExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table TIANXUAN.DW_WEBSQL_SQLLOG
     *
     * @abatorgenerated Thu Feb 16 11:07:25 CST 2012
     */
    int updateByExampleSelective(DwWebsqlSqllog record, DwWebsqlSqllogExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table TIANXUAN.DW_WEBSQL_SQLLOG
     *
     * @abatorgenerated Thu Feb 16 11:07:25 CST 2012
     */
    int updateByExampleWithBLOBs(DwWebsqlSqllog record, DwWebsqlSqllogExample example);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table TIANXUAN.DW_WEBSQL_SQLLOG
     *
     * @abatorgenerated Thu Feb 16 11:07:25 CST 2012
     */
    int updateByExampleWithoutBLOBs(DwWebsqlSqllog record, DwWebsqlSqllogExample example);
}