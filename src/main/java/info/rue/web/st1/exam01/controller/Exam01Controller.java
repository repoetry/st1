/**
 * 
 */
package info.rue.web.st1.exam01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author rue
 *
 */
@Controller
public class Exam01Controller {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("title", "title입니다.");
        
        return "hello/aaa/bbb/ccc";
    }
}
