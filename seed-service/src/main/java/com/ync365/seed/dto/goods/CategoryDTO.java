package com.ync365.seed.dto.goods;

import java.util.Date;

/**
 * 分类DTO
 * 
 * @ClassName: CategoryDTO
 * @Description: TODO
 * @author robo
 * @date 2015年9月18日 下午4:17:44
 *
 */
public class CategoryDTO {

	/**
	 * 主键
	 */
	private Integer brandId;

	/**
	 * 品牌名称(中文)
	 */
	private String chName;

	/**
	 * 品牌缩写(英文)
	 */
	private String enName;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 图片的ID
	 */
	private String uuid;

	/**
	 * 图片的Logo
	 */
	private String logo;

	/**
	 * 排序
	 */
	private Short seq;

	/**
	 * 是否显示
	 */
	private Short status;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 品牌故事 
	 */
	private String story;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Short getSeq() {
		return seq;
	}

	public void setSeq(Short seq) {
		this.seq = seq;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
