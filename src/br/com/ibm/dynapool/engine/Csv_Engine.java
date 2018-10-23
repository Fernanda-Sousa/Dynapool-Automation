package br.com.ibm.dynapool.engine;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import br.com.ibm.dynapool.constructor.TestFields;

public class Csv_Engine {

	public List<TestFields> readSpreadsheetCSV(String FilePath) {  
        List<TestFields> csvTest = null;

        try (Reader reader = Files.newBufferedReader(Paths.get(FilePath), Charset.defaultCharset())) {

            CsvToBean<TestFields> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(TestFields.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            csvTest = csvToBean.parse();

        } catch (IOException e) {
            System.out.println(e);
        }
        return csvTest;
    }
}
