package com.yangs.SpringBootDemo.mapper;



import com.yangs.SpringBootDemo.domain.Video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoMapper {
    private static Map<String, Video> videoMap = new HashMap<>();

    static {
        videoMap.put("1",new Video(1,"yang"));
        videoMap.put("2",new Video(2,"song"));
        videoMap.put("3",new Video(3,"yangs"));
        videoMap.put("4",new Video(4,"yangsong"));
    }

    public List<Video> listVideo(){
        List<Video> list = new ArrayList<>();
        list.addAll(videoMap.values());
        return list;

    }
}
