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

    @PostMapping("{categoryId}/bookInfo")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBookInfo(@PathVariable Long categoryId, @RequestBody BookInfoRequestDto bookInfo) throws Exception {
        bookInfoService.save(categoryId, bookInfo);
    }

    @GetMapping("{categoryId}/bookInfo")
    public BookInfosDto getBookInfoList(@PathVariable Long categoryId) {
        return bookInfoService.findAllByOfficialCategoryId(categoryId);
    }

    @GetMapping("{categoryId}/bookInfo/{infoId}")
    public BookInfoDto getBookInfo(@PathVariable Long categoryId, @PathVariable Long infoId) throws Exception {
        return bookInfoService.findByOfficialCategoryId(categoryId, infoId);
    }

    @DeleteMapping("bookInfo/{infoId}")
    public void deleteBookInfo(@PathVariable Long infoId) throws Exception {
        bookInfoService.deleteByInfoId(infoId);
    }

    // 아직 미완
    @PutMapping("{categoryId}/bookInfo/{infoId}")
    public void modifyBookInfo(@PathVariable Long categoryId, @PathVariable Long infoId, @RequestBody BookInfoRequestDto bookInfo) throws Exception {
        bookInfoService.update(categoryId, infoId, bookInfo);
    }
}
