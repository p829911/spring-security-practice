package me.p829911.practice.spring.security.notice;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.p829911.practice.spring.security.note.NoteRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private NoticeService noticeService;

    @GetMapping
    public String findAll(Model model) {
        List<Notice> notices = noticeService.findAll();
        model.addAttribute("notice", notices);
        return "notice/index";
    }

    /**
     * 공지사항 등록
     *
     * @param noteDto 노트 등록 Dto
     * @return notice/index.html refresh
     */
    @PostMapping
    public String postNotice(@ModelAttribute NoteRegisterDto noteDto) {
        noticeService.saveNotice(noteDto.getTitle(), noteDto.getContent());
        return "redirect:notice";
    }

    /**
     * 공지사항 삭제
     *
     * @param id 공지사항 ID
     * @return notice/index.html refresh
     */
    @DeleteMapping
    public String deleteNotice(@RequestParam Long id) {
        noticeService.deleteNotice(id);
        return "redirect:notice";
    }
}
