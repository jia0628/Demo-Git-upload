package org.iclass.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Builder
@Data   // ● 불변객체와 관련된 메서드만 재정의, 생성자는 따로 설정해주어야한다. (getter / setter /toString)
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class GalleryEntity {
// Entity : JPA 기능을 이용해서 테이블을 만들기 위한 클래스

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 정수 primary key
    private int idx;

    @Column(nullable = false)  // not null 설정
    private String title;

    private String fileNames;
    private String writer;

    @CreatedDate
    private LocalDateTime createdAt;
}

/*
create table GALLERY_ENTITY(
	IDX NUMBER(5) primary key,
	TITLE VARCHAR2(40) not null,
	createAt DATE,
	FILENAMES VARCHAR2(200),
	WRITER VARCHAR2(50)
)

 */
