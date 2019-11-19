package com.springboot.YouHuiWang.Mapper;

import com.springboot.YouHuiWang.Pojo.SubCidTable;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lin
 * @since 2019-10-14
 */
@Mapper
public interface SubCidTableMapper extends BaseMapper<SubCidTable> {

    //批量插入subcit
    int insertAllSubCid(List<SubCidTable> subCidTableList);

    //批量更新subcit
    int updateAllSubCidById(List<SubCidTable> subCidTableList);

    //批量删除subcit
    int deleteAllSubCidById(List<Integer> goodsListId);

}
