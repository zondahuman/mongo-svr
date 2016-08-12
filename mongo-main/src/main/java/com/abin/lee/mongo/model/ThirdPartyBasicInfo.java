package com.abin.lee.mongo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by abin Be Created in 2016/7/4.
 */
@JsonIgnoreProperties( ignoreUnknown = true )
@Document(collection = "ThirdPartyBasicInfo")
@CompoundIndexes({ @CompoundIndex(name = "reportedId_index", def = "{reportedId : 1}", unique = true) })
public class ThirdPartyBasicInfo extends BaseMongoBean {

    private String service; // 接口
    private String serviceVersion;// 接口版本号
    private String partner; // 合作商户
    private String businessLine;// 如果合作商户下面有多个子商户，用这个区分
    private String contractName;// 合同名称

    private String content; // 所有内容

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(String businessLine) {
        this.businessLine = businessLine;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
