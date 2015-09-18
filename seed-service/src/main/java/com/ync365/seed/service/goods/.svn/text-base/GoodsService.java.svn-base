package com.ync365.seed.service.goods;

import java.util.List;

import com.ync365.seed.dto.base.ResponseDTO;

/**
 * 商品接口
 * @ClassName: GoodsService
 * @Description: TODO
 * @author robo
 * @date 2015年9月18日 下午6:07:50
 *
 */
public interface GoodsService {

	/**
	 * 获得分类列表
	 * 
	 * @Title: getCategoryList
	 * @Description: TODO
	 * @return
	 * @return List<CategoryDTO>
	 * @throws
	 */
	public ResponseDTO  getCategoryList();
	
	/**
	 * 获得子分类列表
	 * 
	 * @Title: getChildCategoryList
	 * @Description: TODO
	 * @param categoryId   分类id
	 * @param layer        级别
	 * @return ResponseDTO
	 * @throws
	 */
	public ResponseDTO getChildCategoryList(Integer categoryId, int layer) ;
	
	/**
	 * 获得子分类列表
	 * 
	 * @Title: getChildCategoryList
	 * @Description: TODO
	 * @param categoryId        分类id
	 * @param layer             级别
	 * @param isAllChildren     是否包括全部子节点
	 * @return ResponseDTO
	 * @throws
	 */
	public ResponseDTO getChildCategoryList(Integer categoryId, int layer, boolean isAllChildren) ;

	/**
	 * 获得分类关联的品牌
	 * 
	 * @Title: getCategoryBrandList
	 * @Description: TODO
	 * @param categoryId    分类id
	 * @return List<BrandDTO>
	 * @throws
	 */
	public ResponseDTO getCategoryBrandList(Integer categoryId);
	
	/**
	 * 获得分类的属性列表
	 * @Title: getAttributeListByCategoryId
	 * @Description: 
	 * @param categoryId
	 * @return  ResponseDTO
	 * @throws
	 */
	public ResponseDTO getAttributeListByCategoryId(Integer categoryId) ;
	
	/**
	 * 获得商品信息
	 * @Title: getGoodsById
	 * @Description: TODO
	 * @param goodsId
	 * @return  ResponseDTO      
	 * @throws
	 */
	public ResponseDTO getGoodsById(Integer goodsId) ;
	
	/**
	 * 获得部分商品列表
	 * @Title: getPartProductList
	 * @Description: TODO
	 * @param pidList          商品id集合
	 * @return   ResponseDTO 
	 * @throws
	 */
	public ResponseDTO getPartProductList(String pidList);
	
	/**
	 * 获得分类商品列表
	 * @Title: getCategoryProductList
	 * @Description: TODO
	 * @param pageSize             每页数
	 * @param pageNumber           当前页数
	 * @param cateId               分类id
	 * @param brandId              品牌id
	 * @param filterPrice          筛选价格
	 * @param catePriceRangeList   分类价格范围列表
	 * @param attrValueIdList      属性值id列表
	 * @param onlyStock            是否只显示有货
	 * @param sortColumn           排序列
	 * @param sortDirection        排序方向
	 * @return ResponseDTO
	 *     
	 * @throws
	 */
	public ResponseDTO getCategoryProductList(int pageSize, int pageNumber, Integer categoryId, Integer brandId, int filterPrice, String[] catePriceRangeList, List<String> attrValueIdList, int onlyStock, int sortColumn, int sortDirection);
	
	/**
	 * 获得店铺分类商品列表
	 * @Title: getStoreClassProductList
	 * @Description: TODO
	 * @param pageSize              每页数
	 * @param pageNumber            当前页数
	 * @param storeCid              店铺id
	 * @param startPrice            开始价格
	 * @param endPrice              结束价格
	 * @param sortColumn            排序列
	 * @param sortDirection         排序方式
	 * @return   ResponseDTO 
	 *     
	 * @throws
	 */
	public ResponseDTO getStoreClassProductList(int pageSize, int pageNumber, int storeCid, int startPrice, int endPrice, int sortColumn, int sortDirection) ;
	
}
