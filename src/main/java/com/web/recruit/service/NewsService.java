package com.web.recruit.service;

import java.util.List;
import com.web.recruit.entity.News;

public interface NewsService {

    News getNewsById(Integer id);

    List<News> getNewsByKey(String key);

    List<News> getAllNews();
}