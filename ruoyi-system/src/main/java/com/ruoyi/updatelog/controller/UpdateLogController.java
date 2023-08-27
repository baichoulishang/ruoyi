package com.ruoyi.updatelog.controller;

import java.util.Date;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.updatelog.domain.UpdateLog;
import com.ruoyi.updatelog.service.IUpdateLogService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 系统更新日志Controller
 * 
 * @author cyk
 * @date 2023-08-27
 */
@Controller
@RequestMapping("/updateLog/updateLog")
public class UpdateLogController extends BaseController
{
    private String prefix = "updateLog/updateLog";

    @Autowired
    private IUpdateLogService updateLogService;

    @RequiresPermissions("updateLog:updateLog:view")
    @GetMapping()
    public String updateLog()
    {
        return prefix + "/updateLog";
    }

    /**
     * 查询系统更新日志列表
     */
    @RequiresPermissions("updateLog:updateLog:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UpdateLog updateLog)
    {
        startPage();
        List<UpdateLog> list = updateLogService.selectUpdateLogList(updateLog);
        return getDataTable(list);
    }

    /**
     * 导出系统更新日志列表
     */
    @RequiresPermissions("updateLog:updateLog:export")
    @Log(title = "系统更新日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UpdateLog updateLog)
    {
        List<UpdateLog> list = updateLogService.selectUpdateLogList(updateLog);
        ExcelUtil<UpdateLog> util = new ExcelUtil<UpdateLog>(UpdateLog.class);
        return util.exportExcel(list, "系统更新日志数据");
    }

    /**
     * 新增系统更新日志
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存系统更新日志
     */
    @RequiresPermissions("updateLog:updateLog:add")
    @Log(title = "系统更新日志", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UpdateLog updateLog)
    {
        return toAjax(updateLogService.insertUpdateLog(updateLog));
    }

    /**
     * 修改系统更新日志
     */
    @RequiresPermissions("updateLog:updateLog:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UpdateLog updateLog = updateLogService.selectUpdateLogById(id);
        mmap.put("updateLog", updateLog);
        return prefix + "/edit";
    }

    /**
     * 已经部署
     */
    @PostMapping("/hasUpdate")
    @ResponseBody
    public AjaxResult hasUpdate(UpdateLog updateLog) {
        updateLog.setUpdateResult(1);
        updateLog.setUpdateTime(new Date());
        updateLogService.updateUpdateLog(updateLog);
        return toAjax(1);
    }

    /**
     * 修改保存系统更新日志
     */
    @RequiresPermissions("updateLog:updateLog:edit")
    @Log(title = "系统更新日志", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UpdateLog updateLog)
    {
        return toAjax(updateLogService.updateUpdateLog(updateLog));
    }

    /**
     * 删除系统更新日志
     */
    @RequiresPermissions("updateLog:updateLog:remove")
    @Log(title = "系统更新日志", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(updateLogService.deleteUpdateLogByIds(ids));
    }
}
