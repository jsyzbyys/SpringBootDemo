package com.yangs.SpringBootDemo.controller;

import com.yangs.SpringBootDemo.domain.Video;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    /*@RequestMapping(value="list",method= RequestMethod.GET)*/
    @GetMapping("list")
    public Object list(){
        Map<String,String> listMap = new HashMap<>();
        listMap.put("1","123");
        listMap.put("2","456");
        listMap.put("3","789");
        return listMap;
    }

}
