package com.yangs.SpringBootDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/video")
public class videoController {

    @RequestMapping("list")
    public Object list(){
        Map<String,String> listMap = new HashMap<>();
        listMap.put("1","123");
        listMap.put("2","456");
        listMap.put("3","789");
        return listMap;
    }
}
