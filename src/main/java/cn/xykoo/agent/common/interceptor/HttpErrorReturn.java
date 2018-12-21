package cn.xykoo.agent.common.interceptor;

import cn.xykoo.agent.utils.GsonUtils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author J.Tang
 */
public class HttpErrorReturn {

    public static void writeNoLogin(OutputStream outputStream) throws IOException {
        outputStream.write(GsonUtils.create().toJson(new HttpReturnModel(401, "Not login")).getBytes("UTF-8"));
    }


}
