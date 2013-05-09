package com.toxind.benchmark.thrid.redis;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: BaseDO.java
 * @Package com.taobao.matrix.tg.dal.dataobject
 * @Description: TODO(�������)
 * @author chenhao.pt
 * @date 2010-7-30 ����01:40:19
 * @version V1.0
 */
/**
 * @ClassName: BaseDO
 * @Description: TODO(������һ�仰��������������)
 * @author chenhao.pt
 * @date 2010-7-30 ����01:40:19
 *
 */
public class BaseDO implements Serializable{

	/**
	* @Fields serialVersionUID : 
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * �Ƿ�ɾ��
	 */
	private Integer isDeleted;				
	/**
	 * ����ʱ��
	 */
	private Date gmtCreate;				
	/**
	 * �޸�ʱ��
	 */
	private Date gmtModified;
	/**
	 * @return isDeleted
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}
	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * @return gmtCreate
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * @param gmtCreate the gmtCreate to set
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * @return gmtModified
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
	/**
	 * @param gmtModified the gmtModified to set
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
}

