package com.zlj.cloudmusic.controllers;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class LyricController {

    @GetMapping("/lyric/{id}")
    public String getLyric(@PathVariable("id") String id) {

        String url = "http://music.163.com/api/song/lyric?id=" + id + "&lv=1&kv=1&tv=-1";
        String res = new RestTemplate().getForObject(url, String.class);
        JSONObject result = JSON.parseObject(res);
        JSONObject lrc = result.getJSONObject("lrc");
        String lyric = lrc.getString("lyric");
        return lyric;
    }
}
