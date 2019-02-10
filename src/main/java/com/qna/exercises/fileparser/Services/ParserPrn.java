package com.qna.exercises.fileparser.Services;

import com.qna.exercises.fileparser.Configuration.PrnProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParserPrn implements ParserService {

    private PrnProperties properties;

    @Autowired
    public ParserPrn(PrnProperties properties) {
        this.properties = properties;
    }

    @Override
    public boolean isSupportedFileExtension(String fileExtension) {
        return "prn".equalsIgnoreCase(fileExtension);
    }

    @Override
    public List<String[]> parseInput(InputStream input) throws IOException {
        List<String> allLines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String str;
        while ((str = reader.readLine()) != null) {
            allLines.add(str);
        }

        int[] divisionArr = properties.getSplitter();
        List<String[]> fileList = new ArrayList<>();

        for (int rowIdx = 0; rowIdx < allLines.size(); rowIdx++) {
            String[] rowArr = new String[divisionArr.length];
            int startingShift = 0;
            for (int cellIdx = 0; cellIdx < rowArr.length; cellIdx++) {
                rowArr[cellIdx] = allLines.get(rowIdx).substring(divisionArr[cellIdx] + startingShift, divisionArr[cellIdx + 1]);
                startingShift = 1;
            }
            fileList.add(rowArr);
        }

        return fileList;
    }
}
