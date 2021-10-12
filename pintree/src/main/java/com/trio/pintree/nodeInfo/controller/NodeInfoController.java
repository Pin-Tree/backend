package com.trio.pintree.nodeInfo.controller;

import com.trio.pintree.nodeInfo.dto.BookInfoRequestDto;
import com.trio.pintree.nodeInfo.dto.BookInfosDto;
import com.trio.pintree.nodeInfo.service.BookInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nodes")
@RequiredArgsConstructor
public class NodeInfoController {

    private final BookInfoService bookInfoService;

    // wishCount 고려안하고 저장
    @PostMapping("{nodeId}/bookInfo")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBookInfo(@PathVariable long nodeId, @RequestBody BookInfoRequestDto bookInfo) {
        bookInfoService.save(nodeId, bookInfo);
    }

    //BookInfoResponseDto로 변경해야함
    @GetMapping("{nodeId}/bookInfo")
    public BookInfosDto getBookInfoList(@PathVariable Long nodeId) {
        return bookInfoService.find(nodeId);
    }

}
