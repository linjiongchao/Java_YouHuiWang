package com.springboot.YouHuiWang.Service;

import java.util.List;
import java.util.Map;

public interface SearchService {

    //联想词搜索
    public List<Map> getSearchSuggestion(String keyWords);

    //热搜
    public List<String> getHotSearch();
}
