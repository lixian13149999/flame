package com.bcdbook.flame.common.persistence.pojo;

import com.bcdbook.flame.common.config.Global;
import com.bcdbook.flame.common.util.DateUtil;
import com.bcdbook.flame.common.util.IdGen;
//import com.bcdbook.flame.common.util.UserUtil;
//import com.bcdbook.flame.system.pojo.User;


/**
 * @Description: 时间相关的基础类
 * 便于通用的数据维护
 * @author lason
 * @date 2016年8月23日
 */
public class DataEntity<T> extends BaseEntity<T> {

	/**
	 * 生成唯一的类识别码
	 */
	private static final long serialVersionUID = 2738342821838117314L;

	private String createBy;	// 创建者
	private String createTime;	// 创建日期
	private String updateBy;	// 更新者
	private String updateTime;	// 更新日期
	
	public DataEntity() {
		super();
	}
	
	public DataEntity(String createBy, String createTime, String updateBy,
			String updateTime) {
		super();
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
	}

	@Override
	public void preInsert() {
		setId(IdGen.uuid());
//		User user = UserUtil.getUser();
//		if (org.apache.commons.lang3.StringUtils.isNotBlank(user.getId())){
//			this.updateBy = user.getId();
//			this.createBy = user.getId();
//		}
		this.createTime = DateUtil.getTimeStr10();
		this.updateTime = this.createTime;
		setDelFlag(Global.DEL_FLAG_NORMAL);
	}
	
	@Override
	public void preUpdate() {
//		User user = UserUtil.getUser();
//		if (org.apache.commons.lang3.StringUtils.isNotBlank(user.getId())){
//			this.updateBy = user.getId();
//		}
		this.updateTime = DateUtil.getTimeStr10();
	}
	
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
