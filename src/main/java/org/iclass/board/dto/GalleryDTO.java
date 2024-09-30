package org.iclass.board.dto;


import lombok.*;
import org.iclass.board.entity.GalleryEntity;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GalleryDTO {
    private int idx;
    private String title;
    private String fileNames;     // 테이블에는 업로드파일의 파일명만 저장
    private String writer;
    private LocalDateTime createdAt;

    // 업로드파일을 저장하기 위한 객체
    private MultipartFile file;   // ● 꼭 있어야 하는 부분
    
    // GalleryDTO of() : entity 인자로 DTO 생성하기
    // - 조회 find~~ 메서드 사용, 결과 리턴타입이 entity
    public static GalleryDTO of(GalleryEntity entity) {
        return GalleryDTO.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .fileNames(entity.getFileNames())
                .writer(entity.getWriter())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    // 인스턴스객체/toEntity() : 현재 객체를 인스턴스 값으로 entity 객체 생성하기
    // - save, saveAll, deleteAll 메서드 인자가 entity
    public GalleryEntity toEntity() {
        return GalleryEntity.builder()
                .idx(this.idx)
                .title(this.title)
                .writer(this.writer)
                .fileNames(this.fileNames)
                .build();
        // ● createdAt 만 빼기
    }
}