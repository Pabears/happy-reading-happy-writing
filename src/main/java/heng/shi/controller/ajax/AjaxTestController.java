package heng.shi.controller.ajax;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AjaxTestController {
    @RequestMapping(value = "/test/", method = {RequestMethod.POST, RequestMethod.GET})
    public String hello(String name) {
        return "hello," + name;
    }

    @RequestMapping(value = "/err/", method = {RequestMethod.POST, RequestMethod.GET})
    public HttpServletResponse error(String name, HttpServletResponse response) {
//        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.setStatus(404);
        System.out.println("error," + name);
        return response;
    }
}
