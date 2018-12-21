package cn.xykoo.agent.common.interceptor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther by Smile on 17/4/25.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpReturnModel {

    private int status = 200;
    private String message = "SUCCESS";

}
