package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.service.egoexam.EgoExamService;
import net.iwinv.eyers1.service.file.FileService;
import net.iwinv.eyers1.web.dto.EgoExamResponseDto;
import net.iwinv.eyers1.web.dto.EgoExamSaveRequestDto;
import net.iwinv.eyers1.web.dto.EgoExamUpdateRequestDto;
import net.iwinv.eyers1.web.dto.FileSaveRequestDto;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@RequiredArgsConstructor
@RestController
public class EgoExamApiController {
    private final String fileUrl = "/Users/gim-ujae/Documents/git/book/projects/eyers/src/main/resources/file";
    private final EgoExamService egoexamService;
    private final FileService fileService;

    @PostMapping("/api/v1/egoexam")
    public Long save(@RequestBody EgoExamSaveRequestDto requestDto) throws Exception {
        return egoexamService.save(requestDto);
    }

    @PostMapping("/api/v1/file")
    public Long save(@RequestParam MultipartFile file) throws Exception {
        IOUtils.copy(file.getInputStream(),new FileOutputStream(new File(fileUrl,file.getOriginalFilename())));
        FileSaveRequestDto savefile = new FileSaveRequestDto(file);
        long egoexamFile = fileService.save(savefile);
        return egoexamFile;
    }

    @PutMapping("/api/v1/egoexam/{egoexamSeq}")
    public Long update(@PathVariable Long egoexamSeq, @RequestBody EgoExamUpdateRequestDto requestDto){
        return egoexamService.update(egoexamSeq,requestDto);
    }

    @GetMapping("/api/v1/egoexam/{egoexamSeq}")
    public EgoExamResponseDto findById (@PathVariable Long egoexamSeq) {
        return egoexamService.findById(egoexamSeq);
    }

    @DeleteMapping("/api/v1/egoexam/{egoexamSeq}")
    public Long delete(@PathVariable Long egoexamSeq){
        egoexamService.delete(egoexamSeq);
        return egoexamSeq;
    }

    @DeleteMapping("/api/v1/file/{fileSeq}")
    public Long deleteFile(@PathVariable Long fileSeq){
        fileService.delete(fileSeq);
        return fileSeq;
    }

}
