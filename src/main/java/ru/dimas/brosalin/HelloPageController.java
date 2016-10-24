/**
 * Created by DmitriyBrosalin on 12/09/16.
 */

package ru.dimas.brosalin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloPageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(@RequestParam(value = "name",
            required = false, defaultValue = "World !") String name, Model model){

        model.addAttribute("name", name);
        return ("hello");

    }

}
