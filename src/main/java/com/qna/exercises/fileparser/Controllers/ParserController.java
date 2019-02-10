package com.qna.exercises.fileparser.Controllers;

import com.qna.exercises.fileparser.Services.Exceptions.FileException;
import com.qna.exercises.fileparser.Services.ParserDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Controller
public class ParserController {

    private ParserDispatcher parserDispatcher;

    @Autowired
    public ParserController(ParserDispatcher parserDispatcher) {
        this.parserDispatcher = parserDispatcher;
    }

    @PostMapping("/parser")
    public String parseFile(@RequestParam("file") MultipartFile file, Model model) {
        List<String[]> data;
        try {
            data = parserDispatcher.getFileFormat(file.getOriginalFilename(), file.getInputStream());
        } catch (FileException e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
            return "errorView";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Error - other reason: " + e.getMessage());
            return "errorView";
        }
        model.addAttribute("rows", data);
        return "dataView";
    }
}
