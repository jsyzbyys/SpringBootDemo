package com.yangs.SpringBootDemo.mapper;



import com.yangs.SpringBootDemo.domain.video;

import java.util.HashMap;
import java.util.Map;

public class videoMapper {
    private static Map<String, video> videoMap = new HashMap<>();

    static {
        videoMap.put("1",new video(1,"yang"));
        videoMap.put("2",new video(2,"song"));
        videoMap.put("3",new video(3,"yangs"));
        videoMap.put("4",new video(4,"yangsong"));
    }
}
