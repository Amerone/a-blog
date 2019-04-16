package cn.amarone.model.common.response;

import cn.amarone.model.common.bizEnum.CommEnum;
import lombok.Data;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月27日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@Data
public class CommRsp {

    private String code;
    private String msg;
    private String[] arg;

    public CommRsp(String code, String msg, String[] arg) {
        this.code = code;
        this.msg = msg;
        this.arg = arg;
    }

    public static CommRsp success() {
        return new CommRsp(CommEnum.success.getCode(), CommEnum.success.getMsg(), null);
    }

    public static CommRsp error() {
        return new CommRsp(CommEnum.error.getCode(), CommEnum.error.getMsg(), null);
    }

    public static CommRsp success(String msg) {
        return new CommRsp(CommEnum.success.getCode(), msg, null);
    }

    public static CommRsp error(String msg) {
        return new CommRsp(CommEnum.error.getCode(), msg, null);
    }

    public static CommRsp success(String msg, String[] arg) {
        return new CommRsp(CommEnum.success.getCode(), msg, arg);
    }

    public CommRsp error(String msg, String[] arg) {
        return new CommRsp(CommEnum.error.getCode(), msg, arg);
    }
}