package cn.xykoo.agent.common.image;

/**
 * 图片类型
 *
 * @author : J.Tang
 * @version : v1.0
 * @date : 2018/12/6
 * @email : seven_tjb@163.com
 **/
public enum ImgType {

    /**
     * 主图
     */
    MAIN_PIC(2,"/mainPic"),
    /**
     * 轮播图
     */
    ROUND_PIC(1,"/roundPic"),
    /**
     * 列表图
     */
    LIST_PIC(3,"/listPic");

    private final int code;
    private final String desc;


    ImgType(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
}
