package com.trio.pintree.login.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trio.pintree.node.controller.NodeController;
import com.trio.pintree.node.domain.Node;
import com.trio.pintree.node.dto.CreateCustomNodeRequest;
import com.trio.pintree.node.dto.CreateNodeResponse;
import com.trio.pintree.node.dto.CreateOfficialNodeRequest;
import com.trio.pintree.node.service.NodeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NodeController.class)
class NodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private NodeService nodeService;

//    @Test
//    public void 오피셜노드를_생성한다() throws Exception {
//        // given
//        final String name = "HTML";
//        final Long parentId = null;
//        final boolean isMain = true;
//        final boolean isUp = true;
//        final long index = 100L;
//        final Long officialInfoId = null;
//        CreateOfficialNodeRequest request =
//                new CreateOfficialNodeRequest(name, parentId, isMain, isUp, index, officialInfoId);
//
//        final boolean isOfficial = true;
//        //TODO roadmap에 null 표시해놓음
//        Node createdOfficialNode = Node.createMainNode(null, name, index, isOfficial);
//
//        // when
//        when(nodeService.createOfficialNode(request))
//                .thenReturn(CreateNodeResponse.from(createdOfficialNode));
//        // then
//        this.mockMvc.perform(
//                post("/api/node/official")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(mapper.writeValueAsString(request))
//        ).andExpect(status().isOk());
//    }

//    @Test
//    public void 커스텀노드를_생성한다() throws Exception {
//        // given
//        final String name = "HTML";
//        final Long parentId = null;
//        final boolean isMain = true;
//        final boolean isUp = true;
//        final long index = 100L;
//        final String customInfo = "HTML(Hypertext Markup Language)은 웹 페이지와 그 내용 즉, 컨텐츠의 구조를 정의하는 마크업 언어입니다.";
//
//        CreateCustomNodeRequest request =
//                new CreateCustomNodeRequest(name, parentId, isMain, isUp, index, customInfo);
//
//        final boolean isOffical = false;
//        Node createdCustomNode = Node.createMainNode(name, index, isOffical);
//
//        // when
//        when(nodeService.createCustomNode(request))
//                .thenReturn(CreateNodeResponse.from(createdCustomNode));
//
//        // then
//        this.mockMvc.perform(
//                post("/api/node/custom")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(mapper.writeValueAsString(request))
//        ).andExpect(status().isOk());
//    }

}
