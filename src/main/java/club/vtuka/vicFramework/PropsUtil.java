package club.vtuka.vicFramework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文档
     * @return
     */
    public static Properties loadProps(String fileName){
        Properties props = null;
        InputStream inputStream = null;
        inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        try{
            if(inputStream == null){
                throw new FileNotFoundException(fileName+" not found!");
            }
            props = new Properties();
            props.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("load properties fiel failure",e);
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOGGER.error("close properties file failure",e);
                }
            }
        }
        return props;
    }

    public static String getString(Properties properties,String key){
        return getString(properties,key,"");
    }

    public static String getString(Properties properties,String key,String defaultValue){
        if (properties.containsKey(key)){
            return properties.getProperty(key);
        }else {
            return defaultValue;
        }
    }

    public static int getInt(Properties properties, String key){
        return getInt(properties,key,0);
    }

    public static int getInt(Properties properties, String key,int defaultValue){
        if (properties.containsKey(key)){
            return CastUtil.castInt(properties.getProperty(key));
        }else {
            return defaultValue;
        }
    }

    public static boolean getBoolean(Properties properties, String key){
        return getBoolean(properties,key,false);
    }

    private static boolean getBoolean(Properties properties, String key, boolean defaultValue) {
        if(properties.containsKey(key)){
            return CastUtil.castBoolean(properties.getProperty(key));
        }else{
            return defaultValue;
        }
    }
}
