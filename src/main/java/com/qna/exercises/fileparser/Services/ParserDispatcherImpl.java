package com.qna.exercises.fileparser.Services;

import com.google.common.io.Files;
import com.qna.exercises.fileparser.Services.Exceptions.FileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ParserDispatcherImpl implements ParserDispatcher {

    private List<ParserService> parserServices;

    @Autowired
    public ParserDispatcherImpl(List<ParserService> parserServices) {
        this.parserServices = parserServices;
    }

    @Override
    public List<String[]> getFileFormat(String originalFilename, InputStream inputStream) throws FileException, IOException {
        String fileExtension = Files.getFileExtension(originalFilename);
        for (ParserService parserService : parserServices) {
            if (parserService.isSupportedFileExtension(fileExtension)) {
                return parserService.parseInput(inputStream);
            }
        }
        throw new FileException("Error: Unknown file format");
    }
}
