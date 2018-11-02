package br.com.ibm.dynapool.engine;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import br.com.ibm.dynapool.csv.Csv_Constructor;

public class Csv_Engine {

	public List<Csv_Constructor> readSpreadsheetCSV(String FilePath) {  
        List<Csv_Constructor> csvTest = null;

        try (Reader reader = Files.newBufferedReader(Paths.get(FilePath), Charset.defaultCharset())) {

            CsvToBean<Csv_Constructor> csvToBean = new CsvToBeanBuilder<Csv_Constructor>(reader)
                    .withType(Csv_Constructor.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            csvTest =  csvToBean.parse();

        } catch (IOException e) {
            System.out.println(e);
        }
        return csvTest;
    }
}
