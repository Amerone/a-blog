package cn.amarone.model.sys.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import cn.amarone.model.sys.common.response.CommRsp;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: Amarone
 * @Created Date: 2019年03月27日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error("系统操作异常", e);
        ModelAndView mav = new ModelAndView();
        mav.addObject("result", CommRsp.error());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error/500");
        return mav;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BizException.class)
    public CommRsp bizErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error("业务操作异常", req.getRequestURL());
        e.printStackTrace();
        return CommRsp.error(e.toString());
    }
}