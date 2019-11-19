package com.springboot.YouHuiWang.Service.impl;

import com.springboot.YouHuiWang.Service.SearchService;
import com.springboot.YouHuiWang.Util.CodeUtil;
import com.springboot.YouHuiWang.Util.DaTaoKeApi;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {


    @Override
    public List<Map> getSearchSuggestion(String keyWords) {
        String json = DaTaoKeApi.getSearchSuggestion(keyWords);
        List searchSuggestionList = new ArrayList();
        if (CodeUtil.isSuccessForDaTaoKe(json)) {
            JSONArray dataArray = JSONObject.fromObject(json).getJSONArray("data");

            for (Object temp : dataArray) {

                JSONObject item = JSONObject.fromObject(temp);

                Map map = new HashMap();
                map.put("kw", item.getString("kw"));
                map.put("total", item.getInt("total"));

                searchSuggestionList.add(map);
            }

        }

        return searchSuggestionList;
    }


    @Override
    public List<String> getHotSearch() {
        String json = DaTaoKeApi.getHotSearch();
        System.out.println(json);
        List<String> hotSearchList = new ArrayList<>();

        if (CodeUtil.isSuccessForDaTaoKe(json)) {
            JSONObject data = JSONObject.fromObject(json).getJSONObject("data");
            JSONArray hotWorlds = data.getJSONArray("hotWords");

            hotSearchList.addAll(hotWorlds);
        }

        return hotSearchList;
    }
}
