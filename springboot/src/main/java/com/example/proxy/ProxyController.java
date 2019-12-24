package com.example.proxy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    @ResponseBody
    @RequestMapping("/getWeather")
    public Map<String, Object> loginDefault(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        result.put("data", 123);
        return result;
    }

}
