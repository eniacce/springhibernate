package com.jq.controller;

import com.jq.daoImpl.DataDaoImpl;
import com.jq.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by n2015 on 21.03.2015.
 */

@Controller
public class HomePageController {


    @Autowired
    DataDaoImpl dataDao;





    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.dataDao.getList());
        return "welcome";

    }



    //For add and update person both
    @RequestMapping(value= "/person/add", method = RequestMethod.GET)
    public String addPerson(@ModelAttribute("person") Person p){
        Logger logger = Logger.getLogger("addPerson method called");
        if(p.getId() == 0){
            //new person, add it
            this.dataDao.insertPerson(p);
        }else{
            //existing person, call update
            this.dataDao.updatePerson(p);
        }

        return "redirect:/list";

    }

}
