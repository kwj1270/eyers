package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.domain.file.File;
import net.iwinv.eyers1.domain.file.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the file upload page.
 */
@RequiredArgsConstructor
@Controller
public class FileController {

    @Autowired
    private final FileRepository ufr;


    @RequestMapping(value = "/upload")
    public String showUploadForm() {
        return "upload";
    }


    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam MultipartFile[] fileUpload) throws Exception {

        if (fileUpload != null && fileUpload.length > 0) {
            for (MultipartFile aFile : fileUpload){

                System.out.println("Saving file: " + aFile.getOriginalFilename());

                File uploadFile = new File();
                uploadFile.setFileName(aFile.getOriginalFilename());
                uploadFile.setFileData(aFile.getBytes());
                ufr.save(uploadFile);
            }
        }

        return "success";
    }
}
