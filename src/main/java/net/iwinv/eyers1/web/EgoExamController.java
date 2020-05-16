package net.iwinv.eyers1.web;

import lombok.RequiredArgsConstructor;
import net.iwinv.eyers1.config.LoginUser;
import net.iwinv.eyers1.config.dto.SessionUser;
import net.iwinv.eyers1.domain.egoexam.EgoExam;
import net.iwinv.eyers1.service.egoexam.EgoExamService;
import net.iwinv.eyers1.service.file.FileService;
import net.iwinv.eyers1.web.dto.EgoExamResponseDto;
import net.iwinv.eyers1.web.dto.EgoExamsListResponseDto;
import net.iwinv.eyers1.web.dto.FileResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class EgoExamController {
    private final EgoExamService egoexamService; // @RequiredArgsConstructor 가 의존성 주입 시켜준다.
    private final FileService fileService;
    private final HttpSession httpSession;

    @RequestMapping("/egoexam")
    public String toegoexam(Model model, Pageable pageable, @LoginUser SessionUser user) {
        if (user != null) {
            Page<EgoExamsListResponseDto> egoexams = egoexamService.findAll(pageable);
            model.addAttribute("egoexams", egoexams);
            return "egoexam";
        } else {
            return "redirect:login";
        }
    }
    @RequestMapping("/egoexam/write")
    public String toWriteegoexam(@LoginUser SessionUser user) {
        if (user != null) {
            return "egoexam-write";
        } else {
            return "redirect:../login";
        }
    }
    @RequestMapping("/egoexam/{egoexamSeq}")
    public String toDetailegoexam(@PathVariable Long egoexamSeq,Model model, @LoginUser SessionUser user) {
        if (user != null) {
            EgoExamResponseDto egoExam = egoexamService.findById(egoexamSeq);
            FileResponseDto file = fileService.findById(egoExam.getEgoexamSeq());
            model.addAttribute("egoexam",egoExam);
            model.addAttribute("file", file);
            return "egoexam-detail";
        } else {
            return "redirect:../login";
        }
    }

    @RequestMapping("/egoexam/{egoexamSeq}/update")
    public String toUpdateegoexam(@PathVariable Long egoexamSeq,Model model, @LoginUser SessionUser user) {
        if (user != null) {
            EgoExamResponseDto egoExam = egoexamService.findById(egoexamSeq);
            FileResponseDto file = fileService.findById(egoExam.getEgoexamSeq());
            model.addAttribute("egoexam",egoExam);
            long fileSeq = file.getFileSeq();
            model.addAttribute("fileSeq", fileSeq);
            return "egoexam-update";
        } else {
            return "redirect:../../login";
        }
    }
}
