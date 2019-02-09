package com.qna.exercises.fileparser.Controllers;

import com.qna.exercises.fileparser.Services.ParserDispacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


@Controller
public class ParserController {

    private ParserDispacher parserDispacher;

    @Autowired
    public ParserController(ParserDispacher parserDispacher) {
        this.parserDispacher = parserDispacher;
    }

    @PostMapping("/parser")
    public List<String[]> parseFile(@RequestParam("file") MultipartFile file) {
        List<String[]> data = null;
        try {
            data = parserDispacher.getFileFormat(file.getOriginalFilename(), file.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
