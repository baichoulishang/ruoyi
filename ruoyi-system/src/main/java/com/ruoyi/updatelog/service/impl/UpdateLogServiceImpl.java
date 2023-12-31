package com.ruoyi.updatelog.service.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.updatelog.domain.UpdateLog;
import com.ruoyi.updatelog.mapper.UpdateLogMapper;
import com.ruoyi.updatelog.service.IUpdateLogService;

/**
 * 系统更新日志Service业务层处理
 *
 * @author ruoyi
 * @date 2023-08-28
 */
@Service
public class UpdateLogServiceImpl implements IUpdateLogService {

    @Autowired
    private UpdateLogMapper updateLogMapper;

    /**
     * 查询系统更新日志
     *
     * @param id 系统更新日志主键
     * @return 系统更新日志
     */
    @Override
    public UpdateLog selectUpdateLogById(Long id) {
        return updateLogMapper.selectUpdateLogById(id);
    }

    /**
     * 查询系统更新日志列表
     *
     * @param updateLog 系统更新日志
     * @return 系统更新日志
     */
    @Override
    public List<UpdateLog> selectUpdateLogList(UpdateLog updateLog) {
        return updateLogMapper.selectUpdateLogList(updateLog);
    }

    /**
     * 新增系统更新日志
     *
     * @param updateLog 系统更新日志
     * @return 结果
     */
    @Override
    public int insertUpdateLog(UpdateLog updateLog) {
        updateLog.setCreateTime(new Date());
        updateLog.setUpdateTime(new Date());
        return updateLogMapper.insertUpdateLog(updateLog);
    }

    /**
     * 修改系统更新日志
     *
     * @param updateLog 系统更新日志
     * @return 结果
     */
    @Override
    public int updateUpdateLog(UpdateLog updateLog) {
        updateLog.setUpdateTime(DateUtils.getNowDate());
        return updateLogMapper.updateUpdateLog(updateLog);
    }

    /**
     * 批量删除系统更新日志
     *
     * @param ids 需要删除的系统更新日志主键
     * @return 结果
     */
    @Override
    public int deleteUpdateLogByIds(String ids) {
        return updateLogMapper.deleteUpdateLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除系统更新日志信息
     *
     * @param id 系统更新日志主键
     * @return 结果
     */
    @Override
    public int deleteUpdateLogById(Long id) {
        return updateLogMapper.deleteUpdateLogById(id);
    }

}
