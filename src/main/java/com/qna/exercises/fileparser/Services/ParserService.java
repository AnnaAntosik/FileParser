package com.qna.exercises.fileparser.Services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface ParserService {

    boolean isSupportedFileExtension(String fileExtension);

    List<String[]> parseInput(InputStream input) throws IOException;
}
