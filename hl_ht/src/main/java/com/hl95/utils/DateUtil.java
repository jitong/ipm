package com.hl95.utils;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 
 * 时间工具类
 * @author chenyan
 *
 */
public class DateUtil {

	
	/**
	 * 把时间字串修改为标准时间字串
	 * @param dateStr 源时间字串  (格式：yyyyMMDDHHmmss)
	 * @return 标准时间字串 (格式YYYY-MM-DD HH:mi:ss)
	 */
	public static String dateStrValidate(String dateStr){
		
		String year = dateStr.substring(0,4);
		String month = dateStr.substring(4,6);
		String day = dateStr.substring(6,8);
		String hour = dateStr.substring(8,10);
		String minutes = dateStr.substring(10,12);
		String second = dateStr.substring(12,14);
		
		
		return year+"-"+month+"-"+day+" "+hour+":"+minutes+":"+second;
	}
	
	
	/**
	 * 把时间字串转换为时间
	 * @param dateStr 标准时间字串 (格式yyyy-MM-dd HH:mm:ss)
	 * @return java.util.Date
	 */
	public static Date castStringToDate(String dateStr){
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date= null;
		try {
			date = simpleDate.parse(dateStr);
		} catch (ParseException e) {
			System.out.println("");
		}
		return date;
	}
	
	
	/**
	 * 把时间紫川转换为时间戳
	 * @param dateStr  源时间字串  (格式：yyyyMMDDHHmmss)
	 * @return java.sql.Date
	 */
	public static Timestamp convertStrToSqlDate(String dateStr){
		
		Date date = castStringToDate(dateStrValidate(dateStr));
		
		
		return new Timestamp(date.getTime());	
	}
	
	/**
	 * 获取当前时间，
	 * @return 时间戳类型
	 */
	public static Timestamp getCurrentTimeStamp() {
		
		return new Timestamp(System.currentTimeMillis());
	}
	/**
	 * 获取当前时间的字串
	 * @return 时间字串（格式为yyyyMMdd）
	 */
	@SuppressWarnings("all")
	public static String getNowDateFormartyyyyMMdd(){
		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(calendar.YEAR);
		int month = calendar.get(calendar.MONTH)+1;
		int day = calendar.get(calendar.DAY_OF_MONTH);
		
		String monthStr = month<10?"0"+month:month+"";
		String dayStr = day<10?"0"+day:day+"";
		
		return year+""+monthStr+""+dayStr;
	}
	
	/**
	 * 获取当前时间的字串
	 * @return 时间字串（格式为yyyyMMdd）
	 */
	@SuppressWarnings("all")
	public static String getNowDateFormartyyyyMMddHHmm(){
		
		Date data = new Date();
		
		String year = (1900+data.getYear())+"";
		String month = data.getMonth()>=9?(data.getMonth()+1)+"":"0"+(data.getMonth()+1);
		String day = data.getDate()>9?data.getDate()+"":"0"+data.getDate();
		
		String hours = data.getHours()>9?data.getHours()+"":"0"+data.getHours();
		String minutes = data.getMinutes()>9?data.getMinutes()+"":"0"+data.getMinutes();
		
		return year+""+month+""+day+""+hours+""+minutes;
	}
	
	/**
	 * 
	 * @Title: getTimeStamp  
	 * @Description: 时间转换为时间戳
	 * @return
	 *
	 */
	public static Timestamp convertDateToTimeStamp(Date date) {
		
		if(date==null) {
			return null;
		}
		
		return new Timestamp(date.getTime());		
	}

	
	public static void main(String[] args) {
		
		System.out.println(getNowDateFormartyyyyMMddHHmm());
	}
	
}
