package com.abin.lee.mongo.model;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

public abstract class BaseMongoBean {
    @Id
    private ObjectId _id;
    private String reportedId;// 唯一编号 businessLine+客户生成唯一编号
    private Date createTime;
    private Date updateTime;
    /**
     * 数据类型（小额贷款，O2O,第三方数据）
     */
    private Integer dataType;

    /**
     * 数据上报类型 （新增、修改、删除） 业务表中使用
     */
    private Integer syncType;

    /**
     * 数据上报类型 （新增、修改、取消）OperatorTypeEnums 枚举值 第三方中间表中使用
     */
    private String operateType;
    /**
     * 合同编号
     */
    private String contractNo;

    private String syncStatus;// 同步状态 TaskSyncStatus同步状态

    private Boolean isDelete;// 是否被删除

    // 数据同步状态 新增
    public static final int SYNC_TYPE_INSERT = 0;
    // 数据同步状态 更新
    public static final int SYNC_TYPE_MODIFY = 1;
    // 数据同步状态 删除
    public static final int SYNC_TYPE_CANCLE = 2;
    // 数据上报状态 未上报
    public static final int UPLOAD_STATUS_NOT_REPORT = 0;
    //
    public static final int UPLOAD_STATUS_REPORTING = 1;
    // 数据上报状态 已上报
    public static final int UPLOAD_STATUS_REPORTED = 2;
    // 数据上报状态 上报失败
    public static final int UPLOAD_STATUS_REPORT_FAIL = 3;
    // 数据类型 小贷
    public static final int DATA_TYPE_XIAODAI = 1;
    // 数据类型 O2O
    public static final int DATA_TYPE_O2O = 2;
    // 数据类型 第三方数据上报
    public static final int DATA_TYPE_THRID_PARTY = 3;

    /**
     * @return the syncStatus
     */
    public String getSyncStatus() {
        return syncStatus;
    }

    /**
     * @param syncStatus
     *            the syncStatus to set
     */
    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     *            the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     *            the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public BaseMongoBean() {
        this._id = null;
    }

    /**
     * @return the _id
     */
    public ObjectId get_id() {
        return _id;
    }

    /**
     * @param _id
     *            the _id to set
     */
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Map<String, Object> toMap() {
        try {
            Map<String, Object> map = PropertyUtils.describe(this);
            map.remove("class");
            map.remove("updateMap");
            return map;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        throw new RuntimeException(this.getClass().getName() + "转换map发生异常！");
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public Integer getSyncType() {
        return syncType;
    }

    public void setSyncType(int syncType) {
        this.syncType = syncType;
    }

    /**
     * @return the operateType
     */
    public String getOperateType() {
        return operateType;
    }

    /**
     * @param operateType
     *            the operateType to set
     */
    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    /**
     * @return the reportedId
     */
    public String getReportedId() {
        return reportedId;
    }

    /**
     * @param reportedId
     *            the reportedId to set
     */
    public void setReportedId(String reportedId) {
        this.reportedId = reportedId;
    }

    /**
     * @return the isDelete
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete
     *            the isDelete to set
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

}
