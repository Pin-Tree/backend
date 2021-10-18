package com.trio.pintree.nodeInfo.service;

import com.trio.pintree.node.repository.NodeRepository;
import com.trio.pintree.nodeInfo.domain.BookInfo;
import com.trio.pintree.nodeInfo.domain.OfficialCategory;
import com.trio.pintree.nodeInfo.dto.BookInfoDto;
import com.trio.pintree.nodeInfo.dto.BookInfoRequestDto;
import com.trio.pintree.nodeInfo.dto.BookInfosDto;
import com.trio.pintree.nodeInfo.repository.BookInfoRepository;
import com.trio.pintree.nodeInfo.repository.OfficialCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookInfoService {
    private final BookInfoRepository bookInfoRepository;
    private final NodeRepository nodeRepository;
    private final OfficialCategoryRepository officialCategoryRepository;

    public void save(Long officialCategoryId, BookInfoRequestDto infoDto) throws Exception {
        OfficialCategory findCategory = officialCategoryRepository.findById(officialCategoryId).orElseThrow(Exception::new);
        ;
        BookInfo info = BookInfoRequestDto.of(findCategory, infoDto);

        bookInfoRepository.save(info);
    }

    public BookInfosDto findAllByOfficialCategoryId(Long officialCategoryId) {
        List<BookInfo> bookInfoList = bookInfoRepository.findByOfficialCategoryId(officialCategoryId);
        List<BookInfoDto> bookInfoListDto = bookInfoList.stream().map(BookInfoDto::from).collect(Collectors.toList());
        return BookInfosDto.from(bookInfoListDto);
    }

    public BookInfoDto findByOfficialCategoryId(Long officialCategoryId, Long infoId) throws Exception {
        BookInfo bookInfo = bookInfoRepository.findByOfficialCategoryIdAndInfoId(officialCategoryId, infoId).orElseThrow(Exception::new);
        return BookInfoDto.from(bookInfo);
    }

    public void deleteByInfoId(Long infoId) {
        bookInfoRepository.deleteByInfoId(infoId);
    }

    public void update(Long officialCategoryId, Long infoId, BookInfoRequestDto bookInfo) throws Exception {
        BookInfo findBookInfo = bookInfoRepository.findByOfficialCategoryIdAndInfoId(officialCategoryId, infoId).orElseThrow(Exception::new);
        // setter 써야하나?
    }
}

