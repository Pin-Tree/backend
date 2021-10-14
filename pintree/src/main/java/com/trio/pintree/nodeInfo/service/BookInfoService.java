package com.trio.pintree.nodeInfo.service;

import com.trio.pintree.node.domain.Node;
import com.trio.pintree.node.repository.NodeRepository;
import com.trio.pintree.nodeInfo.domain.BookInfo;
import com.trio.pintree.nodeInfo.dto.BookInfoDto;
import com.trio.pintree.nodeInfo.dto.BookInfoRequestDto;
import com.trio.pintree.nodeInfo.dto.BookInfosDto;
import com.trio.pintree.nodeInfo.repository.BookInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookInfoService {
    private final BookInfoRepository bookInfoRepository;
    private final NodeRepository nodeRepository;

    public void save(Long nodeId, BookInfoRequestDto infoDto) throws Exception {

        Node findNode = nodeRepository.findById(nodeId).orElseThrow(Exception::new);
        BookInfo info = BookInfoRequestDto.of(findNode, infoDto);

        bookInfoRepository.save(info);
    }

    public BookInfosDto findByNodeId(Long nodeId) {
        List<BookInfo> bookInfoList = bookInfoRepository.findByNodeId(nodeId);
        List<BookInfoDto> bookInfoListDto = bookInfoList.stream().map(BookInfoDto::from).collect(Collectors.toList());
        return BookInfosDto.from(bookInfoListDto);
    }

    public BookInfoDto findByNodeIdAndInfoId(Long nodeId, Long infoId) throws Exception {
        BookInfo bookInfo = bookInfoRepository.findByNodeIdAndInfoId(nodeId, infoId).orElseThrow(Exception::new);
        return BookInfoDto.from(bookInfo);
    }

    public void deleteByInfoId(Long infoId) {
        bookInfoRepository.deleteByInfoId(infoId);
    }

    public void update(long nodeId, long infoId, BookInfoRequestDto bookInfo) throws Exception {
        BookInfo findBookInfo = bookInfoRepository.findByNodeIdAndInfoId(nodeId, infoId).orElseThrow(Exception::new);
        // setter 써야하나?
    }
}

