package br.com.tr.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientController {

    @RequestMapping("/client")
    @ResponseBody
    public String getClient() {
        return "Hello World";
    }
}