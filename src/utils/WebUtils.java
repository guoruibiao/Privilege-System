package utils;

import java.util.UUID;

/**
 * 创建出插入数据库的UUID工具类
 * 
 * @author Administrator
 *
 */
public class WebUtils {

	public static String makeUUID() {
		return UUID.randomUUID().toString();
	}

}
