package com.ync365.seed.bussiness.modules.goods.entity;

import java.util.Date;
import java.util.List;

public class Feature {
	/**
	 * 属性主键
	 */
	private Integer featureId;

	/**
	 * 类别
	 */
	private Integer categoryId;
	
	/**
	 * 父级属性id
	 */
	private Integer parentId;
	
	/**
	 * 父级属性名
	 */
	private String parentName;
	
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Integer getParentId() {
		return parentId;
	}

	/**
	 * 类别名
	 */
	private String categoryName;
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * 属性名
	 */
	private String name;

	/**
	 * 是否允许别名
	 */
	private Short isAlias;

	/**
	 * 是否枚举属性
	 */
	private Short isEnum;

	/**
	 * 是否输入属性
	 */
	private Short isInput;

	/**
	 * 是否关键属性
	 */
	private Short isKey;

	/**
	 * 是否销售属性
	 */
	private Short isSales;

	/**
	 * 是否搜索字段
	 */
	private Short isQuery;

	/**
	 * 是否必须
	 */
	private Short isMust;

	/**
	 * 是否规格
	 */
	private Short isSpec;

	/**
	 * 是否多选
	 */
	private Short isMultiselect;

	/**
	 * 状态：
	 * 	默认值为0表示未审核
	 * 	审核通过、未上架状态均为1
	 * 	 审核不通过状态为 2
	 * 	已上架状态为3
	 * 	已下架状态为4
	 */
	private Short status;

	/**
	 * 排序
	 */
	private Integer seq;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 操作者
	 */
	private Integer optUser;

	public List<FeatureValue> getFeatureValues() {
		return featureValues;
	}

	public void setFeatureValues(List<FeatureValue> featureValues) {
		this.featureValues = featureValues;
	}

	/**
	 * 操作时间
	 */
	private Date optDate;

	/**
	 * 操作终端
	 */
	private String optTerm;
	
	/**
	 * 可选值
	 */
	private String optionals;
	
	/**
	 * 属性级别
	 */
	private short featureGrade;

	/**
	 * 属性值
	 */
	private List<FeatureValue> featureValues;

	public Integer getFeatureId() {
		return featureId;
	}

	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Short getIsAlias() {
		return isAlias;
	}

	public void setIsAlias(Short isAlias) {
		this.isAlias = isAlias;
	}

	public Short getIsEnum() {
		return isEnum;
	}

	public void setIsEnum(Short isEnum) {
		this.isEnum = isEnum;
	}

	public Short getIsInput() {
		return isInput;
	}

	public void setIsInput(Short isInput) {
		this.isInput = isInput;
	}

	public Short getIsKey() {
		return isKey;
	}

	public void setIsKey(Short isKey) {
		this.isKey = isKey;
	}

	public Short getIsSales() {
		return isSales;
	}

	public void setIsSales(Short isSales) {
		this.isSales = isSales;
	}

	public Short getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(Short isQuery) {
		this.isQuery = isQuery;
	}

	public Short getIsMust() {
		return isMust;
	}

	public void setIsMust(Short isMust) {
		this.isMust = isMust;
	}

	public Short getIsSpec() {
		return isSpec;
	}

	public void setIsSpec(Short isSpec) {
		this.isSpec = isSpec;
	}

	public Short getIsMultiselect() {
		return isMultiselect;
	}

	public void setIsMultiselect(Short isMultiselect) {
		this.isMultiselect = isMultiselect;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getOptUser() {
		return optUser;
	}

	public void setOptUser(Integer optUser) {
		this.optUser = optUser;
	}

	public Date getOptDate() {
		return optDate;
	}

	public void setOptDate(Date optDate) {
		this.optDate = optDate;
	}

	public String getOptTerm() {
		return optTerm;
	}

	public void setOptTerm(String optTerm) {
		this.optTerm = optTerm == null ? null : optTerm.trim();
	}

	public short getFeatureGrade() {
		return featureGrade;
	}

	public void setFeatureGrade(short featureGrade) {
		this.featureGrade = featureGrade;
	}

	public String getOptionals() {
		return optionals;
	}

	public void setOptionals(String optionals) {
		this.optionals = optionals;
	}
}