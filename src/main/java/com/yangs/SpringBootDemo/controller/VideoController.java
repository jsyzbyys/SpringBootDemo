package com.yangs.SpringBootDemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangs.SpringBootDemo.domain.Video;
import com.yangs.SpringBootDemo.service.VideoService;
import com.yangs.SpringBootDemo.service.impl.VideoServiceImpl;
import com.yangs.SpringBootDemo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    /*@RequestMapping(value="list",method= RequestMethod.GET)*/
    @GetMapping("list")
    public Object list() throws JsonProcessingException {
        List<Video> list = videoService.listVideo();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(list);
        System.out.println(jsonStr);
        System.out.println(1);
        System.out.println(2);
        List<Video> temp = objectMapper.readValue(jsonStr,List.class);
        return JsonData.buildSuccess(temp);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video){
        System.out.println(video.toString());
        return JsonData.buildSuccess(video);
    }

}
