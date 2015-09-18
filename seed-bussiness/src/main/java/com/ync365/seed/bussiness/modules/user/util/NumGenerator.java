package com.ync365.seed.bussiness.modules.user.util;

import java.util.UUID;
/**
 * 生成各种编号
 * @author duan.zhao.qian
 * @date 2015年9月9日 下午5:19:10
 */
public class NumGenerator {
	/**
	 * 获取用户编号
	 * @return
	 */
	public static String getUserNum() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
	/**
	 * 获取POP商家编号
	 * @return
	 */
	public static String getPoPNum() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
	/**
	 * 获取群组编号
	 * @return
	 */
	public static String getGroupNum() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
	/**
	 * 获取角色编号
	 * @return
	 */
	public static String getRoleNum() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
	/**
	 * 获取权限编号
	 * @return
	 */
	public static String getModuleNum() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
}
