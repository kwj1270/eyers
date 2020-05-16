package net.iwinv.eyers1.service.file;

import lombok.RequiredArgsConstructor;

import net.iwinv.eyers1.domain.file.File;
import net.iwinv.eyers1.domain.file.FileRepository;
import net.iwinv.eyers1.web.dto.FileUpdateRequestDto;
import net.iwinv.eyers1.web.dto.FilesListResponseDto;

import org.springframework.stereotype.Service;


import net.iwinv.eyers1.web.dto.FileResponseDto;
import net.iwinv.eyers1.web.dto.FileSaveRequestDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FileService {
    private final FileRepository fileRepository;

    @Transactional(readOnly = true)
    public List<FilesListResponseDto> findAll() {
        return fileRepository.findAll()
                .stream()
                .map(FilesListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public long save(FileSaveRequestDto requestDto){
        return fileRepository.save(requestDto.toEntity()).getFileSeq();
    }

    @Transactional // 유저 정보 삭제
    public FileResponseDto findById(Long fileSeq) {
        File entity = fileRepository.findById(fileSeq).orElseThrow(() -> new
                IllegalArgumentException("해당 공지가 없습니다. id=" + fileSeq));
        return new FileResponseDto(entity);
    }

    @Transactional  // 업데이트 하고 seq 값 반
    public Long update(Long fileSeq, FileUpdateRequestDto requestDto) { // 바꿀 대상이랑 매개변수 받기 (spring 컨테이너를 통한 객체 자동 생성 및 주입)
        File file = fileRepository.findById(fileSeq).orElseThrow(() -> // 람다식 사용 있으면 반환 없으면 던져라 (매개변수로 들어간 익명 객체)
                new IllegalArgumentException("해당 공지가 없습니다" + fileSeq)); //  없으면 null 안주고 에러 발생
        file.update(requestDto.getFileName(), requestDto.getFileData()); // update 객체를 이용한 update 진행
        return fileSeq;    // 에러가 없다면 pk를 보내 성공 여부 알려
    }

    @Transactional // 유저 정보 삭제
    public void delete(Long fileSeq) {
        File file = fileRepository.findById(fileSeq).orElseThrow(() -> new
                IllegalArgumentException("해당 공지가 없습니다. id=" + fileSeq));
        fileRepository.delete(file);
    }

}
