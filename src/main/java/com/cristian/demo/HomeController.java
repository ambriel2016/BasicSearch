package com.cristian.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String index(Model model){
        Person person1 = new Person();
        person1.setName("Rey");
        person1.setAge("28");
        person1.setHeight("5, 11\"");

        Person person2 = new Person();
        person2.setName("Carlos");
        person2.setAge("32");
        person2.setHeight("5, 10\"");

        Person person3 = new Person();
        person3.setName("Cris");
        person3.setAge("40");
        person3.setHeight("5, 10\"");

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);

        model.addAttribute("people", personRepository.findAll());
        return "index";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("search") String search, Model model){
        model.addAttribute("peopleSearch", personRepository.findByName(search));
        return "searchList";
    }
}
