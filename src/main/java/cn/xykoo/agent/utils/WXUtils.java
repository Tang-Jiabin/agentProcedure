package cn.xykoo.agent.utils;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
/**
 * 微信
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/21
 * @email : seven_tjb@163.com
 **/
public class WXUtils {

    public static String getUserInfo(String encryptedData, String sessionKey, String iv) {
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);

        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String encryptedData = "2DyYXWkoOgTDTxf0Zajwr1DpO8koP1e3L9DedLKQ/eTYNPBQV+MmA9xt+GpYowGufftD0aU9+yjZl+hPFGQFbdJc8zyDdzhLeUYERtDcAewGj7IBJo8qV8//F2NtF5r7mQ+L9tcE/gtCGxtvSXNOAyfD+BOCu69wRN3O4extchjiCJGt6mtkfQRfq6kGDsspqO5zRPx9gi5MKkUDfuKgM2byVe23gg1BmitkNIZ7dAae14JJZiyBHpmlKCXrphacsQCZxlqWrl4pO8BtZKQ/iacTkNH2iUEw6VE2sburAT3s2nKrpBzRhF64UkUxQTzh0OaM9NkvqEvs+gbI3FYf9TyK0Majd1FAyTQF2QS2z98/Al9CrMgDzAvN4BlwJyLNRuYw9HyM7TqnSy/VhfjxWtnrIn8qh/A9n5IaRaSbCRMhdKtqEqTN6nsfpFjKwNgRRqY0RI9jXCtqNQy0XzLL4IMW9tL0McQTtRk+0gkM/+M=";
        String sessionKey = "5CiqdNgtIGj2ZLwvv3TPqw==";
        String iv = "J7BIxsMXL3ghywY8+cBq/g==";
        System.out.println(getUserInfo(encryptedData, sessionKey, iv));
    }

}
