package com.ssyvsse.configuration.errHandle;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author llb
 *
 * @Date 2018年3月24日 下午12:11:27
 */
@Controller
public class MainsiteErrorController implements ErrorController {

	private static final String ERROR_PATH = "/error";

	@RequestMapping(value = ERROR_PATH)
	public String handleError(HttpServletResponse response) {
		return "err/404";
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}
