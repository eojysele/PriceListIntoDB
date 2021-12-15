package DataBase;


import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadCVS {

    public void uploadCVS(String fileName) throws IOException, CsvException {
        List<CSVPriseList> contentCSV = new CsvToBeanBuilder(new FileReader(fileName))
                .withSeparator(';')
                .withType(CSVPriseList.class)
                .build()
                .parse();

        DataBase dataBase = new DataBase();
        dataBase.insetrtIntoDB(contentCSV);


     }
}