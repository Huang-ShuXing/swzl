package wechat.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Huang_Shuxing 2016年6月30日 下午1:22:22
 */
public class PropertiesUtil {
	/**
	 * 根据key获得值
	 * @author Huang_Shuxing
	 * 2016年6月30日 下午1:23:06
	 * @param filePath
	 * @param key
	 * @return
	 */
	public static String GetValueByKey(String filePath, String key) {
		Properties pps = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(filePath));
			pps.load(in);
			String value = pps.getProperty(key);
			System.out.println(key + " = " + value);
			return value;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取properties 文件
	 * @author Huang_Shuxing
	 * 2016年6月30日 下午1:25:01
	 * @param filePath
	 * @return
	 */
	public static Properties getProperties(String filePath){
		Properties pps = new Properties();
		try {
			InputStream in = PropertiesUtil.class.getResourceAsStream(filePath);
			
			pps.load(in);
			return pps;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
