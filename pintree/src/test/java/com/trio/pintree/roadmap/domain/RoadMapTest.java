package com.trio.pintree.roadmap.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class RoadMapTest {

    @Test
    @DisplayName("로드맵은 반드시 제목을 포함한다.")
    void ShouldHaveTitle() {
        //given
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        String title = "제목1";

        //when
        RoadMap roadMap = RoadMap.from(title);
        Set<ConstraintViolation<RoadMap>> violations = validator.validate(roadMap);

        //then
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("로드맵의 제목은 빈칸을 허용하지 않는다.")
    void ShouldNotHaveBlank() {
        //given
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        String title = "";

        //when
        RoadMap roadMap = RoadMap.from(title);
        Set<ConstraintViolation<RoadMap>> violations = validator.validate(roadMap);

        //then
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("로드맵의 제목은 Null을 허용하지 않는다.")
    void ShouldNotHaveNull() {
        //given
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        String title = null;

        //when
        RoadMap roadMap = RoadMap.from(title);
        Set<ConstraintViolation<RoadMap>> violations = validator.validate(roadMap);

        //then
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("로드맵의 제목은 ' '을 허용하지 않는다.")
    void itShouldNotHaveOnlyWhiteSpace() {
        //given
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        String title = " ";

        //when
        RoadMap roadMap = RoadMap.from(title);
        Set<ConstraintViolation<RoadMap>> violations = validator.validate(roadMap);

        //then
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("로드맵의 공개여부 기본값은 비공개이다.")
    void itShouldSetDefaultToPrivate() {
        //given
        String title = "제목1";

        //when
        RoadMap roadMap = RoadMap.from(title);

        //then
        assertThat(roadMap.isPublic()).isFalse();
    }

    @Test
    @DisplayName("로드맵은 공개여부를 공개로 설정할 수 있다.")
    void itShouldSetPublic() {
        //given
        String title = "제목1";

        //when
        RoadMap roadMap = RoadMap.from(title);
        roadMap.setPublic();

        //then
        assertThat(roadMap.isPublic()).isTrue();
    }

    @Test
    @DisplayName("로드맵은 공개여부를 비공개로 설정할 수 있다.")
    void itShouldSetPrivate() {
        //given
        String title = "제목1";

        //when
        RoadMap roadMap = RoadMap.from(title);
        roadMap.setPrivate();

        //then
        assertThat(roadMap.isPublic()).isFalse();
    }
}
