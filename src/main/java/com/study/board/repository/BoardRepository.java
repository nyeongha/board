package com.study.board.repository;

import com.study.board.entity.board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<board,Integer> {
    //<>안에는 엔티티 클래스 이름과 ID 필드 타입이 지정된다.
    // 주의할 점은 "기본형의 경우, 래퍼 클래스를 지정한다는 점이다.
    // 샘플 SampleEntity 클래스는 long 형을 ID를 지정하고 있기 때문에,
    // 여기에서는 <SampleEntity, Long>라고 작성을 한다.
}
