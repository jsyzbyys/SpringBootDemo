package com.yangs.SpringBootDemo.service.impl;


import com.yangs.SpringBootDemo.domain.Video;
import com.yangs.SpringBootDemo.mapper.VideoMapper;
import com.yangs.SpringBootDemo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo(){
        return videoMapper.listVideo();
    }
}
