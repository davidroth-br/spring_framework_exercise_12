package com.montrealcollege.exercise12.controller;

import com.montrealcollege.exercise12.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/create")
public class EmployeeController {

    @Autowired
    private Employee employee;

    @GetMapping("/{name}")
    public String createEmployee(@PathVariable String name, ModelMap modelMap) {
        employee.setFirstName(name);
        modelMap.addAttribute("message", "Employee created with name " + employee.getFirstName());
        return "hello";
    }

    @GetMapping("salary")
    public String createEmployee(@RequestParam("firstname") String name, @RequestParam("lastname") String lastName, @RequestParam("salary") Integer salary, ModelMap modelMap){
        employee.setFirstName(name);
        employee.setLastName(lastName);
        employee.setSalary(salary);

        modelMap.addAttribute("message", "Employee created with name " + employee.getFirstName() + " " + employee.getLastName() + " and salary " + employee.getSalary());
        return "hello";
    }
}
