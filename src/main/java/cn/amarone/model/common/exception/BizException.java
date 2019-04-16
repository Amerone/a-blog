package cn.amarone.model.common.exception;

import cn.amarone.model.common.bizEnum.CommEnum;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月26日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
public class BizException extends BaseException {

    public BizException(String code, String msg) {
        super(code, msg);
    }
    public BizException(String msg) {
        super(CommEnum.error.getCode(), msg);
    }
}