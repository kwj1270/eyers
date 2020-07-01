package net.iwinv.eyers1.domain.file;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class File {

    @Id // DB에서 PK임을 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK가 INT 형이며 AUTO_INCREMENT 지원
    private long fileSeq;

    @Column(nullable = false) // SQL == ....not null unique
    private String fileName;


    @Column(nullable = false) // SQL == ....not null unique
    private String fileUrl;

    @Lob
    @Column(length=1024000)
    private byte[] fileData;


    @Builder // 생성자 위에 @Builder가 붙었다 이는 매개변수의 순서를 맞추지 않더라도 값을 할당받게 해준다.
    public File(long fileSeq, String fileName, byte[] fileData){

        this.fileSeq = fileSeq;
        this.fileName = fileName;
        this.fileData = fileData;
    }

    public File update(String fileName, byte[] fileData){
        this.fileName = fileName;
        this.fileData = fileData;
        return this;
    }
}
