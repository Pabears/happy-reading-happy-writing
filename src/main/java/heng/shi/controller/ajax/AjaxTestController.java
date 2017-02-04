package heng.shi.controller.ajax;


import heng.shi.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@RestController
public class AjaxTestController {

	@RequestMapping(value = "/test/", method = RequestMethod.POST)
	public User hello(String name) {
		User user = new User();
		user.setUsername(name);
		return user;
	}

	@RequestMapping(value = "/error/", method = RequestMethod.POST)
	public HttpServletResponse error(String name, HttpServletResponse response) throws IOException {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		String error = "error," + name;
		int length = error.length();
		response.setContentLength(length);
		Writer writer = response.getWriter();
		System.out.println(error);
		return response;
	}
}
