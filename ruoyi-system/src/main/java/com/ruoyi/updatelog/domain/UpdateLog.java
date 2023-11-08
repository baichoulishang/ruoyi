package com.ruoyi.updatelog.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 系统更新日志对象 update_log
 *
 * @author ruoyi
 * @date 2023-11-07
 */
public class UpdateLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 哪里的更新包，建德，海潮，等等 */
    @Excel(name = "哪里的更新包，建德，海潮，等等")
    private Integer systemLoc;

    /** 哪一个系统 */
    @Excel(name = "哪一个系统")
    private Integer whichSystem;

    /** 接口还是web */
    @Excel(name = "接口还是web")
    private Integer inferfaceOrWeb;

    /** 哪个模块 */
    @Excel(name = "哪个模块")
    private String module;

    /** 更新日志 */
    @Excel(name = "更新日志")
    private String log;

    /** 更新包位置 */
    @Excel(name = "更新包位置")
    private String packageLoc;

    /** 是否已经部署 */
    @Excel(name = "是否已经部署")
    private Integer updateResult;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    /** 版本号 */
    @Excel(name = "版本号")
    private String version;

    /** sql脚本 */
    @Excel(name = "sql脚本")
    private String sqlContent;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setSystemLoc(Integer systemLoc) {
        this.systemLoc = systemLoc;
    }

    public Integer getSystemLoc() {
        return systemLoc;
    }

    public void setWhichSystem(Integer whichSystem) {
        this.whichSystem = whichSystem;
    }

    public Integer getWhichSystem() {
        return whichSystem;
    }

    public void setInferfaceOrWeb(Integer inferfaceOrWeb) {
        this.inferfaceOrWeb = inferfaceOrWeb;
    }

    public Integer getInferfaceOrWeb() {
        return inferfaceOrWeb;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getModule() {
        return module;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getLog() {
        return log;
    }

    public void setPackageLoc(String packageLoc) {
        this.packageLoc = packageLoc;
    }

    public String getPackageLoc() {
        return packageLoc;
    }

    public void setUpdateResult(Integer updateResult) {
        this.updateResult = updateResult;
    }

    public Integer getUpdateResult() {
        return updateResult;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setSqlContent(String sqlContent) {
        this.sqlContent = sqlContent;
    }

    public String getSqlContent() {
        return sqlContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("systemLoc", getSystemLoc())
                .append("whichSystem", getWhichSystem())
                .append("inferfaceOrWeb", getInferfaceOrWeb())
                .append("module", getModule())
                .append("log", getLog())
                .append("packageLoc", getPackageLoc())
                .append("updateResult", getUpdateResult())
                .append("createUser", getCreateUser())
                .append("version", getVersion())
                .append("sqlContent", getSqlContent())
                .append("updateTime", getUpdateTime())
                .append("createTime", getCreateTime())
                .toString();
    }

}
