package cn.xykoo.agent.common.http;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 键值结果
 *
 * @author : J.Tang
 * @version : v1.0
 * @email : seven_tjb@163.com
 * @create : 2018-06-05 11:18
 **/
@Data
public class KVResult<T> implements Serializable{

    private Integer key;

    private T val;

    public static <T> KVResult<T> put(Integer key, T val){
        KVResult result = new KVResult();
        result.setKey(key);
        result.setVal(val);
        return result;
    }

    public static <T> KVResult<T> put(HttpStatus status, T val){
        KVResult result = new KVResult();
        result.setKey(status.value());
        result.setVal(val);
        return result;
    }

    public static <T> KVResult<T> put(T val){
        KVResult result = new KVResult();
        result.setKey(HttpStatus.OK.value());
        result.setVal(val);
        return result;
    }

    public static <T> KVResult<T> put(HttpStatus status){
        KVResult result = new KVResult();
        result.setKey(status.value());
        result.setVal(status.getReasonPhrase());
        return result;
    }
}
