package com.ykai.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ykai.blog.entity.Word;
import com.ykai.blog.service.WordService;
import com.ykai.blog.mapper.WordMapper;
import org.springframework.stereotype.Service;

/**
* @author Ykai
* @description 针对表【tb_word】的数据库操作Service实现
* @createDate 2023-02-07 15:12:25
*/
@Service
public class WordServiceImpl extends ServiceImpl<WordMapper, Word>
    implements WordService{

}




