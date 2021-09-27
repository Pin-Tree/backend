package com.trio.pintree.roadmap.controller;

import com.trio.pintree.login.resolver.LoginMemberArgumentResolver;
import com.trio.pintree.roadmap.domain.RoadMap;
import com.trio.pintree.roadmap.dto.RoadMapLookUpResponse;
import com.trio.pintree.roadmap.service.RoadMapService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Method;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(RoadMapController.class)
class RoadMapControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoadMapService roadMapService;

    @MockBean
    private LoginMemberArgumentResolver loginMemberArgumentResolver;

    @Test
    void 로드맵_조회를_확인해본다() throws Exception {
        //given
        RoadMap roadMap = RoadMap.from("제목1");
        Method privateSetter = RoadMap.class.getDeclaredMethod("setId", Long.class);
        privateSetter.setAccessible(true);
        privateSetter.invoke(roadMap, 1L);

        long roadMapId = 1L;

        //when
        when(roadMapService.findRoadMapById(roadMapId)).thenReturn(RoadMapLookUpResponse.from(roadMap));

        //then
        mockMvc.perform(get("/api/roadmap/{roadMapId}", roadMapId)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andDo(print());
    }
}
