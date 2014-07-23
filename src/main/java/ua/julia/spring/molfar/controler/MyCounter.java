package ua.julia.spring.molfar.controler;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by julia
 */
//@Controller
public class MyCounter {
    @RequestMapping(value = "/count.htm", method = RequestMethod.POST)
    public @ResponseBody
    String add(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Integer i = null;
        try {
            i = Integer.parseInt(request.getParameter("index"));
        } catch (NumberFormatException e) {
            i = 0;
        }

        System.out.println(i);

        return (++i).toString();
    }

    @RequestMapping({"/", "/home"})
    public String home(org.springframework.ui.Model model){
        return "ajaxexample";
    }
}
