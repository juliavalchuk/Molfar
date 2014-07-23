package ua.julia.spring.molfar.controler;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.julia.spring.molfar.domain.Account;

import javax.validation.Valid;

/**
 * Created by julia
 */
@RestController
@RequestMapping("/signup")
public class UserControler {

    @RequestMapping(method = RequestMethod.GET)
    public String createNewUser(Model model){
        model.addAttribute("user", new Account());
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postNewUser(@Valid Account account, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "registration";
        }


        return "index";
    }


}
