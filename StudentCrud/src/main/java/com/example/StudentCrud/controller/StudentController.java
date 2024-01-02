package com.example.StudentCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.StudentCrud.domain.Student;
import com.example.StudentCrud.service.StudentService;


@Controller  //MVC (Model-View-Controller) 
public class StudentController {
	
	@Autowired //dependencies otomatik olarak enjekte edilmesini sağlar.
    private StudentService service; //StudentController sınıfının StudentService türündeki bir (dependency)i temsil eder.
	
	
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Student> liststudent = service.listAll();
        model.addAttribute("liststudent", liststudent);
        System.out.print("Get / ");    
        return "index";
    }
    @GetMapping("/new") //Bu @RequestMapping(method = RequestMethod.GET) gibi bir şeyin kısa versiyonudur.
    public String add(Model model) {
        model.addAttribute("student", new Student());
        return "new";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student std) {
        service.save(std);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");//ModelAndView verileri ve görünüm adını içeren bir yapıdır.html şablon
        Student std = service.get(id);
        mav.addObject("student", std);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }

}
