package club.vtuka.vicFramework;

import org.apache.commons.lang3.StringUtils;

public class CastUtil {

    public static String castString(Object object){
        return CastUtil.castString(object,"");
    }

    private static String castString(Object object, String defaultValue) {
        return object != null?String.valueOf(object):defaultValue;
    }

    public static int castInt(Object object){
        return castInt(object,0);
    }

    public static int castInt(Object object,int defaultValue){
        int value = defaultValue;
        if(object != null){
            String objectStr = castString(object);
            if(StringUtils.isNotEmpty(objectStr)){
                try {
                    value = Integer.parseInt(objectStr);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    public static double castDouble(Object object){
        return castDouble(object,0);
    }

    public static double castDouble(Object object, double defaultValue){
        double value = defaultValue;
        if(object != null){
            String objectStr = castString(object);
            if(StringUtils.isNotEmpty(objectStr)){
                try {
                    value = Double.parseDouble(objectStr);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    public static long castLong(Object object){
        return castLong(object,0L);
    }

    public static Long castLong(Object object, long defaultValue){
        long value = defaultValue;
        if(object != null){
            String objectStr = castString(object);
            if(StringUtils.isNotEmpty(objectStr)){
                try {
                    value = Long.parseLong(objectStr);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    public static boolean castBoolean(Object object) {
        return castBoolean(object, false);
    }

    public static boolean castBoolean(Object object, boolean defaultValue) {
        boolean value = defaultValue;
        if(object != null){
            String objectStr = castString(object);
            if(StringUtils.isNotEmpty(objectStr)){
                try {
                    value = Boolean.valueOf(objectStr);
                } catch (NumberFormatException e) {
                    value = defaultValue;
                }
            }
        }
        return value;
    }
}
