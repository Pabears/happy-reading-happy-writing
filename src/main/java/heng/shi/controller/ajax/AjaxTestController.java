package heng.shi.controller.ajax;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxTestController {
	@RequestMapping(value = "/test/", method = RequestMethod.POST)
	public String hello(String name) {
		return "hello," + name;
	}

	@RequestMapping(value = "/error/", method = RequestMethod.POST)
	public HttpServletResponse error(String name, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		System.out.println("error," + name);
		return response;
	}
}
