package com.yoland.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Administrator on 2014/12/15.
 */
public class UUIDGenerator {


    /** The FieldPosition. */
    private static final FieldPosition HELPER_POSITION = new FieldPosition(0);

    /** This Format for format the data to special format. */
    private final static Format dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    private final static Format projectDateFormat = new SimpleDateFormat("yyyyMMdd");

    /** This Format for format the number to special format. */
    private final static NumberFormat numberFormat = new DecimalFormat("0000");

    private final static NumberFormat projectNumberFormat = new DecimalFormat("000000");

    private static int projectSeq = 1;

    private static final int MAX = 9999;

    public UUIDGenerator() {
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return temp;
    }
    public static String getUserID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return temp;
    }

    //获得指定数量的UUID
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }

    /**
     * 返回日期+number位随机数
     * @param number
     * @return
     */
    public static String getDateUUID(int number){
        String uuidStr=UUID.randomUUID().toString().substring(0,number);
        String dateStr= DateUtil.getCurrentDateTime();
        return dateStr+uuidStr;
    }
    
    /**
     * 返回日期+hashcode
     * @return
     */
    private static String getUUidCode() {
		int hashCode = UUID.randomUUID().toString().hashCode();
		if (hashCode < 0) {
			hashCode = -hashCode;
		}
		Calendar cal = Calendar.getInstance();
		Date currDate = cal.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = format.format(currDate);
		return str+ String.format("%012d", hashCode);
	}
    
    public static String generatorRandomMathNum(String type){
        String num = null;
        if(type == null){
        	
        }else{
        	num = type + getUUidCode();//FAI 生成随机申请编号、HT 生成随机合同编号、AIMV 生成随机资产编号、9 生成随机协议编号
        }
        return num;
    }
    
    public static String generatorRandomMathNum(String type, int number){
        String num = null;
        if(type == null){
        	
        }else{
        	num = type + UUIDGenerator.getDateUUID(number);//FAI 生成随机申请编号、HT 生成随机合同编号、AIMV 生成随机资产编号、9 生成随机协议编号
        }
        return num;
    }

    /**
     *
     * <pre>
     * 生成项目编号 yyyyMMdd+000001
     * </pre>
     *
     * @return
     */
    public static synchronized String generateProjectNoSequence() {
        Calendar rightNow = Calendar.getInstance();

        StringBuffer sb = new StringBuffer();
        dateFormat.format(rightNow.getTime(), sb, HELPER_POSITION);
        projectNumberFormat.format(projectSeq, sb, HELPER_POSITION);
        if (projectSeq == MAX) {
            projectSeq = 1;
        } else {
            projectSeq++;
        }
        return sb.toString();
    }

    /**
     * 生成唯一编号
     * @param preCode 生成编码的前缀
     * @param number 随机数位数
     * @return
     */
    public static String generateSequence(String preCode,int number){
        if (StringUtils.isBlank(preCode)){
            return "";
        }
        if (number == 0){
            number = 4;
        }
        return (new StringBuffer(preCode).append(getDateUUID(number))).toString();
    }
    
    
    /**
     * 生成6位数数字验证码
     * @return
     */
    public static String code(){
    	String code = String.valueOf(new Random().nextInt(899999) + 100000);
    	return code ;
    }
    
    
    public static void main(String[] args){
        String a = getDateUUID(6);
        System.out.println(a);
        //generateSequence("SYSUSER",4);
        System.out.println(generateSequence("SYSUSER",4));
    }

}
