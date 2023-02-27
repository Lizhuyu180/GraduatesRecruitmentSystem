package com.web.recruit.controller.news;

import com.web.recruit.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toNews")
public class NewsController extends BaseController {

    @RequestMapping("/news")
    public String toNews() {
        return "user/news";

    }

    @RequestMapping("/guide")
    public String toGuide() {
        return "user/guide";
    }





}
