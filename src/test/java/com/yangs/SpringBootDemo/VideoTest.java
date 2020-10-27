package com.yangs.SpringBootDemo;

import com.yangs.SpringBootDemo.domain.Video;
import com.yangs.SpringBootDemo.service.VideoService;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootDemoApplication.class})
@AutoConfigureMockMvc
public class VideoTest {
    @Autowired
    private VideoService videoService;
    @Autowired
    private MockMvc mockMvc;
    @Before
    public void testOne(){
        System.out.println("这是before");
    }

    @Test
    public void testVideoListApi() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

   /* @Test
    public void testTwo(){

        System.out.println("这是Test");
        TestCase.assertEquals(1,2);
    }

    @Test
    public void testFour(){
        System.out.println("这是Test2");
    }*/

    @Test
    public void testVideoList(){
        List<Video> videoList = videoService.listVideo();
        TestCase.assertTrue(videoList.size()>0);
    }

    @After
    public void testThree(){
        System.out.println("这是after");
    }
}
