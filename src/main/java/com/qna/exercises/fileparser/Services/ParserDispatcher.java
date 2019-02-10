package com.qna.exercises.fileparser.Services;

import java.io.InputStream;
import java.util.List;

public interface ParserDispatcher {

    List<String[]> getFileFormat(String originalFilename, InputStream inputStream) throws Exception;
}
