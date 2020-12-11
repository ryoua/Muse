 package com.muse.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.muse.job.entity.ScheduleJobLogEntity;
import com.muse.utils.PageUtils;

import java.util.Map;

/**
 * 定时任务日志
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
}
