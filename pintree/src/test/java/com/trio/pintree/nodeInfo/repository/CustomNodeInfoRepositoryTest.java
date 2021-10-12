package com.trio.pintree.nodeInfo.repository;

import com.trio.pintree.nodeInfo.domain.CustomNodeInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomNodeInfoRepositoryTest {
    @Autowired
    private CustomNodeInfoRepository customNodeInfoRepository;

    @Test
    void save() throws Exception {
        CustomNodeInfo customNodeInfo = CustomNodeInfo.builder()
                                                      .nodeId(2L)
                                                      .title("제목")
                                                      .description("설명")
                                                      .date(LocalDateTime.now())
                                                      .build();

        customNodeInfoRepository.save(customNodeInfo);
        CustomNodeInfo findInfo = customNodeInfoRepository.findById(1L).orElseThrow(Exception::new);

        assertThat(findInfo).isEqualTo(customNodeInfo);
    }
}