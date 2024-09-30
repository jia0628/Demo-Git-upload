package org.iclass.board.controller;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.iclass.board.dto.GalleryDTO;
import org.iclass.board.repository.GalleryUploadRepository;
import org.iclass.board.service.GalleryUploadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
@Controller
@Slf4j
public class GalleryUploadController {

    private final GalleryUploadService uploadService;

    @GetMapping("/gallery")
    public String gallery(Model model) {
        GalleryDTO dto = uploadService.one(1);
        model.addAttribute("dto", dto);
        return "gallery";
    }

    @PostMapping("/gallery")
    public String upload(GalleryDTO dto) throws IOException {
        MultipartFile file = dto.getFile();  // ● gallery.html 에서 <input type="file" accept="image/*" name="file"> 이걸 받아감
        log.info("===> 파일명: {}", file.getOriginalFilename());
        log.info("===> 파일크기: {}", file.getSize());

        uploadService.uploadGallery(dto);

        return "redirect:/gallery";
    }

}
