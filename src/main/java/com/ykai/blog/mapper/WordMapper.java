package com.ykai.blog.mapper;

import com.ykai.blog.entity.Word;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Ykai
* @description 针对表【tb_word】的数据库操作Mapper
* @createDate 2023-02-07 15:12:25
* @Entity com.ykai.blog.entity.Word
*/
@Repository
public interface WordMapper extends BaseMapper<Word> {

}




