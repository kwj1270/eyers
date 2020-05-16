package net.iwinv.eyers1.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.iwinv.eyers1.domain.file.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Getter
@Setter
@NoArgsConstructor
public class FileSaveRequestDto {

    private String fileName; // 작성자
    private byte[] fileData; // 대신 포멧을 데이트형식으로 넣고 데이트형식을 스트링으로 뺀다

    @Builder
    public FileSaveRequestDto(String fileName, byte[] fileData){
        this.fileName = fileName;
        this.fileData = fileData;
    }

    public FileSaveRequestDto(MultipartFile file) throws IOException {
        this.fileName = file.getOriginalFilename();
        this.fileData = file.getBytes();
    }

    public File toEntity(){
        return File.builder()
                .fileName(this.fileName)
                .fileData(this.fileData)
                .build();
    }
}
