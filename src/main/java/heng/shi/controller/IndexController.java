package heng.shi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public String index(HttpServletRequest request) {
        request.getSession();
        return "index";
    }

}
