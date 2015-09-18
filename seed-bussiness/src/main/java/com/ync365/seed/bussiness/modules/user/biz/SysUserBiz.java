package com.ync365.seed.bussiness.modules.user.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync365.seed.bussiness.modules.user.dao.SysUserInfoMapper;
import com.ync365.seed.bussiness.modules.user.dao.SysUserMapper;
import com.ync365.seed.bussiness.modules.user.entity.SysUser;

@Service
public class SysUserBiz {
	
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysUserInfoMapper sysUserInfoMapper;

	public SysUser selectByPrimaryKey(String userNum) {
		return null; //sysUserMapper.selectByPrimaryKey(userNum);
	}
	
	
	/**保存用户
	 * @author xieang
	 * 2015年9月7日
	 * @param sysUser
	 * @return
	 */
	public int insertSysUser(SysUser sysUser){
		return sysUserMapper.insert(sysUser);
	}
	
	/**根据主键选择性修改用户信息
	 * @author xieang
	 * 2015年9月7日
	 * @param sysUser
	 * @return
	 */
	public int updateSysUserByPrimaryKeySelective(SysUser sysUser){
		return sysUserMapper.updateByPrimaryKeySelective(sysUser);
	}
	
	/**保存user信息和详细信息
	 * @author xieang
	 * 2015年9月14日
	 * @param sysUser
	 */
	/*@Transactional
	public void updateSysUserAndInfoByUserNum(SysUser sysUser){
		sysUserMapper.updateByPrimaryKeySelective(sysUser);
		SysUserInfo sysUserInfo = sysUser.getSysUserInfo();
		if(StringUtils.isBlank(sysUserInfo.getUserNum())){
			sysUserInfo.setUserNum(sysUser.getUserNum());
			sysUserInfoMapper.insert(sysUserInfo);
		}else{
			sysUserInfo.setUserNum(sysUser.getUserNum());
			sysUserInfoMapper.updateByPrimaryKeySelective(sysUserInfo);
		}
		
		
	}*/
	
	/**分页查询
	 * @author xieang
	 * 2015年9月14日
	 * @param sysUser
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	/*public List<SysUser> selectSysUserByPage(SysUser sysUser,int startIndex, int pageSize){
		RowBounds rowBounds = new RowBounds(startIndex,pageSize);
		return sysUserMapper.selectSysUserByPage(sysUser, rowBounds);
	}*/
	/**分页查询
	 * @author xieang
	 * 2015年9月14日
	 * @param sysUser
	 * @return
	 */
	public long selectSysUserByPageCount(SysUser sysUser){
		return 0 ;//sysUserMapper.selectSysUserByPageCount(sysUser);
	}
	
	/**根据用户编号查询用户详细信息
	 * @author xieang
	 * 2015年9月14日
	 * @param userNum
	 * @return
	 */
	public SysUser selectSysUserByUserNum(String userNum){
		return null ;//sysUserMapper.selectSysUserByUserNum(userNum);
	}
}