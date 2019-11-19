package com.springboot.YouHuiWang.Service.impl;

import com.springboot.YouHuiWang.Pojo.SubCidTable;
import com.springboot.YouHuiWang.Mapper.SubCidTableMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.YouHuiWang.Service.SubCidTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lin
 * @since 2019-10-14
 */
@Service
public class SubCidTableServiceImpl extends ServiceImpl<SubCidTableMapper, SubCidTable> implements SubCidTableService {

    @Autowired
    private SubCidTableMapper subCidTableMapper;

    public void get() {
        SubCidTable subCidTable = new SubCidTable();
        subCidTable.setId(1);
        subCidTable.setSubcid(1);

        int i = subCidTableMapper.insertAllColumn(subCidTable);
        System.out.println("insert:" + i);
    }
}
