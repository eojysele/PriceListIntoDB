import DataBase.DataBase;
import DataBase.ReadCVS;
import Mail.Mail;
import com.opencsv.exceptions.CsvException;

import javax.mail.*;
import java.io.IOException;

public class Main {
    static String fileName;
    public static void main(String[] args) throws MessagingException, IOException, CsvException {
        Mail mail = new Mail();
        fileName = mail.MailList();
        System.out.println("MAIN: "+fileName);
        ReadCVS readcvs = new ReadCVS();
        readcvs.uploadCVS(fileName);
    }
}