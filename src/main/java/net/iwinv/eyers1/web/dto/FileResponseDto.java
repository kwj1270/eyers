package net.iwinv.eyers1.web.dto;

import lombok.Getter;
import net.iwinv.eyers1.domain.file.File;
import net.iwinv.eyers1.domain.freeboard.Freeboard;

// 데이터베이스로부터 하나의 데이터를 가져올 때 사용하는 클래스
@Getter
public class FileResponseDto {

    private long fileSeq;
    private String fileName; // 작성자
    private byte[] fileData;

    public FileResponseDto(File entity){
        this.fileSeq = entity.getFileSeq();
        this.fileName = entity.getFileName();
        this.fileData = entity.getFileData();
    }
}
