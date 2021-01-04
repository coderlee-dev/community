package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/find")
    @ResponseBody
    public String testController() {
        return alphaService.find();
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String student(@PathVariable("id") int id) {
        return "a student";
    }

    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String student(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "successed";
    }

    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp() {
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", 22);
        emp.put("salary", 2000.00);
        return emp;
    }

    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps() {
        List<Map<String, Object>> listEmps = new ArrayList<>();
        Map<String, Object> emps = new HashMap<>();
        emps.put("name", "张三");
        emps.put("age", 22);
        emps.put("salary", 2000.00);
        listEmps.add(emps);

        emps.put("name", "李四");
        emps.put("age", 25);
        emps.put("salary", 4000.00);
        listEmps.add(emps);
        return listEmps;
    }

}
