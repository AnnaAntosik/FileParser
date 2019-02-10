package com.qna.exercises.fileparser.Services;

import com.qna.exercises.fileparser.Services.Exceptions.FileException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface ParserDispatcher {

    List<String[]> getFileFormat(String originalFilename, InputStream inputStream) throws FileException, IOException;
}
