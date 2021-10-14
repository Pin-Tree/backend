package com.trio.pintree.nodeInfo.controller;

import com.trio.pintree.nodeInfo.dto.BookInfoDto;
import com.trio.pintree.nodeInfo.dto.BookInfoRequestDto;
import com.trio.pintree.nodeInfo.dto.BookInfosDto;
import com.trio.pintree.nodeInfo.service.BookInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nodes")
@RequiredArgsConstructor
public class BookInfoController {

    private final BookInfoService bookInfoService;

    @PostMapping("{nodeId}/bookInfo")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBookInfo(@PathVariable Long nodeId, @RequestBody BookInfoRequestDto bookInfo) throws Exception {
        bookInfoService.save(nodeId, bookInfo);
    }

    @GetMapping("{nodeId}/bookInfo")
    public BookInfosDto getBookInfoList(@PathVariable Long nodeId) {
        return bookInfoService.findByNodeId(nodeId);
    }

    @GetMapping("{nodeId}/bookInfo/{infoId}")
    public BookInfoDto getBookInfo(@PathVariable(name = "nodeId") Long nodeId, @PathVariable(name = "infoId") Long infoId) throws Exception {
        return bookInfoService.findByNodeIdAndInfoId(nodeId, infoId);
    }

    @DeleteMapping("bookInfo/{infoId}")
    public void deleteBookInfo(@PathVariable(name = "infoId") Long infoId) throws Exception {
        bookInfoService.deleteByInfoId(infoId);
    }

    // 아직 미완
    @PutMapping("{nodeId}/bookInfo/{infoId}")
    public void modifyBookInfo(@PathVariable long nodeId, @PathVariable long infoId, @RequestBody BookInfoRequestDto bookInfo) throws Exception {
        bookInfoService.update(nodeId, infoId, bookInfo);
    }
}
