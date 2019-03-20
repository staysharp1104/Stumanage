package com.unis.util.validate;

public class ValidateUtils {
	/**
	 * 验证数据是否为空
	 * @param data
	 * @return
	 */
	public static boolean validateEmpty(String data) {
		if(data == null || "".equals(data)) {
			return false;
		}
		return true;
	}
}
