package com.toxind.benchmark.thrid.redis;

import org.apache.commons.lang.StringUtils;

public class ItemDO extends BaseDO {

    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = 1L;

    /**
     * ��Ʒid��ͬ��������Ʒid
     */
    private Long itemId;

    /**
     * ��Ʒ�����
     */
    private String longName;

    /**
     * ��Ʒ�����
     */
    private String shortName;

    /**
     * ��Ʒurl
     */
    private String itemUrl;

    /**
     * ��Ʒ����
     */
    private Integer itemCount;

    /**
     * ����Ŀ
     */
    private Long parentCategory;

    /**
     * ����Ŀ
     */
    private Long childCategory;

    /**
     * ��������
     */
    private Integer shopType;

    /**
     * �Ƿ����
     */
    private Integer payPostage;

    /**
     * ��Ʒԭ��
     */
    private Long originalPrice;

    /**
     * ��ƷͼƬurl
     */
    private String picUrl;

    /**
     * �Ź���
     */
    private Long activityPrice;

    /**
     * ���ڳ���
     */
    private String city;

    /**
     * ��������
     */
    private String itemDesc;
    /**
     * ��Ʒ״̬
     */
    private Integer itemStatus;
    /**
     * ��Ʒ����
     */
    private String itemGuarantee;
    /**
     * �ۿ���
     */
    private Double discount;

    /**
     * ������
     */
    private String checkComment;

    /**
     * ƽ̨id
     */
    private Long platformId;

    /**
     * ��id
     */
    private Long groupId;

    /**
     * ����id
     */
    private Long sellerId;

    /**
     * �����ǳ�
     */
    private String sellerNick;

    /**
     * �����Ǽ�
     */
    private Integer sellerCredit;

    /**
     * �洢forest����Ŀid
     */
    private Long categoryId;

    /**
     * ��������
     */
    private int soldCount;

    /**
     * ������id
     */
    private Long operatorId;

    /**
     * �������ǳ�
     */
    private String operatorNick;

    /**
     * �����ʼ�
     */
    private String sellerEmail;
    /**
     * ������ϵ�绰
     */
    private String sellerPhone;
    /**
     * ���ҵ�ַ
     */
    private String sellerAddress;

    /**
     * ���ҵ���Url
     */
    private String sellerShopUrl;

    /**
     * ������ʵ����
     */
    private String sellerRealName;
    /**
     * ��ƷͼƬurl�����Խ�����
     */
    private String picUrlFromIC;

    /**
     * ��Ʒ�Ƿ�����Ʒ�߱����̼��޷��޸ģ� 0������1�����
     */
    private Integer isLock = 0;

    /**
     * ��Ʒ������������
     */
    private Integer itemType;

    /**
     * �Ź����� 0:���˹��� 1:���ݼ۸� 2:֧������ͨ�����֧��
     */
    private Integer tgType;

    public Integer getTgType() {
        // if(tgType == null)
        // return 0;
        return tgType;
    }

    public void setTgType(Integer tgType) {
        this.tgType = tgType;
    }

    /**
     * ����
     */
    private String attributes;



    public String getAttributes() {
        // if(attributes == null){
        // return "";
        // }
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    /**
     * @return picUrlFromIC
     */
    public String getPicUrlFromIC() {
        return picUrlFromIC;
    }

    /**
     * @return sellerRealName
     */
    public String getSellerRealName() {
        return sellerRealName;
    }

    /**
     * @return sellerShopUrl
     */
    public String getSellerShopUrl() {
        return sellerShopUrl;
    }

    /**
     * @return sellerEmail
     */
    public String getSellerEmail() {
        return sellerEmail;
    }

    /**
     * @return sellerPhone
     */
    public String getSellerPhone() {
        return sellerPhone;
    }

    /**
     * @return sellerAddress
     */
    public String getSellerAddress() {
        return sellerAddress;
    }

    /**
     * @return operatorId
     */
    public Long getOperatorId() {
        return operatorId;
    }

    /**
     * @return operatorNick
     */
    public String getOperatorNick() {
        return operatorNick;
    }

    /**
     * @param operatorId
     *            the operatorId to set
     */
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * @param operatorNick
     *            the operatorNick to set
     */
    public void setOperatorNick(String operatorNick) {
        this.operatorNick = operatorNick;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(int soldCount) {
        this.soldCount = soldCount;
    }

    /**
     * @return categoryId
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     *            the categoryId to set
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return itemId
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * @param itemId
     *            the itemId to set
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * @return longName
     */
    public String getLongName() {
        return longName;
    }

    /**
     * @param longName
     *            the longName to set
     */
    public void setLongName(String longName) {
        this.longName = longName;
    }

    /**
     * @return shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName
     *            the shortName to set
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * @return itemUrl
     */
    public String getItemUrl() {
        if (StringUtils.isNotBlank(itemUrl)) {
            return itemUrl.replaceFirst("tmall", "taobao");
        } else {
            return null;
        }
    }

    /**
     * @param itemUrl
     *            the itemUrl to set
     */
    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    /**
     * @return itemCount
     */
    public Integer getItemCount() {
        return itemCount;
    }

    /**
     * @param itemCount
     *            the itemCount to set
     */
    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    /**
     * @return parentCategory
     */
    public Long getParentCategory() {
        return parentCategory;
    }

    /**
     * @param parentCategory
     *            the parentCategory to set
     */
    public void setParentCategory(Long parentCategory) {
        this.parentCategory = parentCategory;
    }

    /**
     * @return childCategory
     */
    public Long getChildCategory() {
        return childCategory;
    }

    /**
     * @param childCategory
     *            the childCategory to set
     */
    public void setChildCategory(Long childCategory) {
        this.childCategory = childCategory;
    }

    /**
     * @return shopType
     */
    public Integer getShopType() {
        return shopType;
    }

    /**
     * @param shopType
     *            the shopType to set
     */
    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    /**
     * @return payPostage
     */
    public Integer getPayPostage() {
        return payPostage;
    }

    /**
     * @param payPostage
     *            the payPostage to set
     */
    public void setPayPostage(Integer payPostage) {
        this.payPostage = payPostage;
    }

    /**
     * @return originalPrice
     */
    public Long getOriginalPrice() {
        return originalPrice;
    }

    /**
     * @param originalPrice
     *            the originalPrice to set
     */
    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * @return picUrl
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * @param picUrl
     *            the picUrl to set
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * @return activityPrice
     */
    public Long getActivityPrice() {
        return activityPrice;
    }

    /**
     * @param activityPrice
     *            the activityPrice to set
     */
    public void setActivityPrice(Long activityPrice) {
        this.activityPrice = activityPrice;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return itemDesc
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * @param itemDesc
     *            the itemDesc to set
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    /**
     * @return itemStatus
     */
    public Integer getItemStatus() {
        return itemStatus;
    }

    /**
     * @param itemStatus
     *            the itemStatus to set
     */
    public void setItemStatus(Integer itemStatus) {
        this.itemStatus = itemStatus;
    }

    /**
     * @return itemGuarantee
     */
    public String getItemGuarantee() {
        return itemGuarantee;
    }

    /**
     * @param itemGuarantee
     *            the itemGuarantee to set
     */
    public void setItemGuarantee(String itemGuarantee) {
        this.itemGuarantee = itemGuarantee;
    }

    /**
     * @return discount
     */
    public Double getDiscount() {
        return discount;
    }

    /**
     * @param discount
     *            the discount to set
     */
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    /**
     * @return checkComment
     */
    public String getCheckComment() {
        return checkComment;
    }

    /**
     * @param checkComment
     *            the checkComment to set
     */
    public void setCheckComment(String checkComment) {
        this.checkComment = checkComment;
    }

    /**
     * @return platformId
     */
    public Long getPlatformId() {
        return platformId;
    }

    /**
     * @param platformId
     *            the platformId to set
     */
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    /**
     * @return groupId
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     *            the groupId to set
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * @return sellerId
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * @param sellerId
     *            the sellerId to set
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * @return sellerNick
     */
    public String getSellerNick() {
        return sellerNick;
    }

    /**
     * @param sellerNick
     *            the sellerNick to set
     */
    public void setSellerNick(String sellerNick) {
        this.sellerNick = sellerNick;
    }

    /**
     * @return sellerCredit
     */
    public Integer getSellerCredit() {
        return sellerCredit;
    }

    /**
     * @param sellerCredit
     *            the sellerCredit to set
     */
    public void setSellerCredit(Integer sellerCredit) {
        this.sellerCredit = sellerCredit;
    }

    public ItemDO() {
    };

    /**
     * @param picUrlFromIC
     *            the picUrlFromIC to set
     */
    public void setPicUrlFromIC(String picUrlFromIC) {
        this.picUrlFromIC = picUrlFromIC;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public void setSellerShopUrl(String sellerShopUrl) {
        this.sellerShopUrl = sellerShopUrl;
    }

    public void setSellerRealName(String sellerRealName) {
        this.sellerRealName = sellerRealName;
    }

    /**
     * @return itemType
     */
    public Integer getItemType() {
        return itemType;
    }

    /**
     * @param itemType
     *            the itemType to set
     */
    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

}
