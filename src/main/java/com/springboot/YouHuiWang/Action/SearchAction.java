package com.springboot.YouHuiWang.Action;

import com.springboot.YouHuiWang.Service.SearchService;
import com.springboot.YouHuiWang.Util.CodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "搜索")
public class SearchAction extends MyAction{

    @Autowired
    private SearchService searchService;

    private String keyWords;


    //联想词搜索
    @GetMapping(value="search/getSearchSuggestion.action")
    @ApiOperation(value = "查询联想词",notes = "通过keyWords获取关键词")
    @ApiImplicitParam(name = "keyWords", dataType = "string", value = "关键字", paramType = "query",required = true)
    public String getSearchSuggestion(){
        if (keyWords!=null && keyWords!=""){
            List<Map>  suggestionMap =  searchService.getSearchSuggestion(keyWords);
            response.put("result", CodeUtil.success(suggestionMap));
        }else{
            response.put("result", CodeUtil.error(-1,"输入错误"));
        }
        return SUCCESS;
    }

    //热搜
    @GetMapping(value="search/getHotSearch.action")
    @ApiOperation(value = "获取热搜",notes = "获取热搜")
    public String getHotSearch(){
        response.put("result", CodeUtil.success(searchService.getHotSearch()));
        return SUCCESS;
    }


    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
