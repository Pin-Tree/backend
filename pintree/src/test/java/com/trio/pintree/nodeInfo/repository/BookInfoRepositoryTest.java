package com.trio.pintree.nodeInfo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookInfoRepositoryTest {

   @Autowired
   private BookInfoRepository bookInfoRepository;

    @Test
    void save(){
        //BookInfo bookInfo = new BookInfo(2L, "제목","설명", LocalDateTime.now(),"thumb",0,"url","publisher","author", 1000);
        //bookInfoRepository.save(bookInfo);
    }

}