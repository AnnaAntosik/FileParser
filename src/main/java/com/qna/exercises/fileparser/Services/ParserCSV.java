package com.qna.exercises.fileparser.Services;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.List;


@Service
public class ParserCSV implements ParserService {

    @Override
    public boolean isSupportedFileExtension(String fileExtension) {
        return "csv".equalsIgnoreCase(fileExtension);
    }

    @Override
    public List<String[]> parseInput(InputStream input) throws IOException {
        CSVReader csvReader = new CSVReader(new InputStreamReader(input), ',', '"', 0);
        List<String[]> allRows = csvReader.readAll();
        return allRows;
    }
}
