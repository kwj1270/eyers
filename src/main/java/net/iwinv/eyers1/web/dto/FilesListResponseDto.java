package net.iwinv.eyers1.web.dto;

import lombok.Getter;
import net.iwinv.eyers1.domain.file.File;

@Getter
public class FilesListResponseDto {

    private long fileSeq;
    private String fileName; // 작성자
    private byte[] fileData; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다

    public FilesListResponseDto(File entity){
        this.fileSeq = entity.getFileSeq();
        this.fileName = entity.getFileName();
        this.fileData = entity.getFileData();
    }
}
