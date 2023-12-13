package com.example.doan2.Controller;

import com.example.doan2.Dto.ReadingFileDto;
import com.example.doan2.Entities.ReadingQuesEntity;
import com.example.doan2.Service.ReadingQuesService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.ui.Model; // Import the correct Model class
import com.example.doan2.Dto.PassageDto;
import com.example.doan2.Entities.PassageEntity;
import com.example.doan2.Service.PassageService;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class ReadingController {
    @Autowired
    PassageService passageService;
    @Autowired
    ReadingQuesService readingQuesService;

    @GetMapping("reading/upload")
    public String upload(Model model) {
        PassageEntity passage = new PassageEntity();
        ReadingQuesEntity readingQues = new ReadingQuesEntity();
        // Set the ID for the PassageEntity (you should get a valid ID here)
        // passage.setId(your_id_here);

        // Add the "passage" to the model
        model.addAttribute("passage", passage);

        return "/jsp/admin/reading/uppassage.jsp";
    }

    @PostMapping(value = "reading/save")
    public String save(PassageDto passageDto, PassageEntity passage, Model model, MultipartFile file) throws IOException {
        Integer id = passageService.saveAndReturnId(passageDto).getId();
        model.addAttribute("file", file);
        PassageEntity passageEntity = passageService.findById(id);

        // Pass the PassageEntity to the save method in ReadingQuesService
        readingQuesService.save(file, passageEntity);
        System.out.println("da thanh cong");
        if (id != null) {
            return "redirect:/admin/reading/upload/" + id;
        } else {
            // Handle the case where id is null, e.g., by redirecting to an error page or taking appropriate action.
            return "redirect:/error"; // Change this to your error page URL
        }
//    }
//
//    @GetMapping("reading/upload/{id}")
//    public String uploadQuestion(@PathVariable Integer id, Model model){
//        PassageEntity passage=passageService.findById(id);
//        model.addAttribute("passage", passage);
//        return ("/jsp/admin/reading/upquestion.jsp");
//    }
//    @PostMapping("reading/question/upload")
//        public String uploadQues(MultipartFile file) throws IOException {
//            readingQuesService.save(file);
//        System.out.println("thanh cong");
//            return " thanh cong";
//        }

    }
}
