package wechat.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Huang_Shuxing 2016年7月10日 下午3:43:49
 */
public class DateUtil {

	public static int START_YEAR = 2002;
	public static int END_YEAR;
	private static List<String> START_YEAR_LIST;
	private static List<String> END_YEAR_LIST;

	static {
		Calendar c = Calendar.getInstance();
		END_YEAR = c.get(Calendar.YEAR);
	}

	public static List<String> getInUniversityDateList() {
		if (START_YEAR_LIST == null || START_YEAR_LIST.size()<= 0) {
			List<String> list = new ArrayList<String>();
			Calendar c = Calendar.getInstance();
			int end = END_YEAR;
			for (int start = START_YEAR; start <= end; start++) {
				list.add(String.valueOf(start));
			}
			START_YEAR_LIST = list;
		}
		return START_YEAR_LIST;
	}

	/**
	 * 获取毕业日期
	 * 
	 * @author Huang_Shuxing 2016年7月10日 下午4:03:01
	 * @return
	 */
	public static List<String> getOutUniversityDateList() {
		if (END_YEAR_LIST == null || END_YEAR_LIST.size() <= 0) {
			List<String> list = new ArrayList<String>();

			int end = END_YEAR + 4;
			for (int start = START_YEAR + 4; start <= end; start++) {
				list.add(String.valueOf(start));
			}
			END_YEAR_LIST = list;
		}
		return END_YEAR_LIST;
	}
	/**
	 * 将yyyy-mm-dd转成date
	 * @author Huang_Shuxing
	 * 2016年7月16日 下午12:48:24
	 * @return
	 */
	public static Date getDateByString(String dateStr){
		return new Date(dateStr);
	}
}
