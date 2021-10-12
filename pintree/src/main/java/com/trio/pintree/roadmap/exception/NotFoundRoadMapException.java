package com.trio.pintree.roadmap.exception;

public class NotFoundRoadMapException extends RuntimeException {

    private static final String NOT_FOUND_ROADMAP_MESSAGE = "해당 로드맵을 찾을 수 없습니다.";

    public NotFoundRoadMapException() {
        super(NOT_FOUND_ROADMAP_MESSAGE);
    }
}
