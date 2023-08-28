package com.ruoyi.updatelog.mapper;

import java.util.List;
import com.ruoyi.updatelog.domain.UpdateLog;

/**
 * 系统更新日志Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-28
 */
public interface UpdateLogMapper 
{
    /**
     * 查询系统更新日志
     * 
     * @param id 系统更新日志主键
     * @return 系统更新日志
     */
    public UpdateLog selectUpdateLogById(Long id);

    /**
     * 查询系统更新日志列表
     * 
     * @param updateLog 系统更新日志
     * @return 系统更新日志集合
     */
    public List<UpdateLog> selectUpdateLogList(UpdateLog updateLog);

    /**
     * 新增系统更新日志
     * 
     * @param updateLog 系统更新日志
     * @return 结果
     */
    public int insertUpdateLog(UpdateLog updateLog);

    /**
     * 修改系统更新日志
     * 
     * @param updateLog 系统更新日志
     * @return 结果
     */
    public int updateUpdateLog(UpdateLog updateLog);

    /**
     * 删除系统更新日志
     * 
     * @param id 系统更新日志主键
     * @return 结果
     */
    public int deleteUpdateLogById(Long id);

    /**
     * 批量删除系统更新日志
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUpdateLogByIds(String[] ids);
}
