package com.ssyvsse.configuration.errHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author llb
 *
 * @Date 2018年3月24日 下午12:08:52
 */
@ControllerAdvice
public class ErrorExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(ErrorExceptionHandler.class);

	@ExceptionHandler({ RuntimeException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView processException(RuntimeException exception) {
		logger.info("自定义异常处理-500 " + exception.getMessage());
		exception.printStackTrace();
		ModelAndView m = new ModelAndView();
		m.setViewName("/err/500");
		return m;
	}

	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView processException(Exception exception) {
		logger.info("自定义异常处理-other exception" + exception.getMessage());
		exception.printStackTrace();
		ModelAndView m = new ModelAndView();
		m.setViewName("/err/500");
		return m;
	}
}
