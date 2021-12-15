package Сonfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    //Путь к конфиг-файлу
    public static final String pahtToConfig = "src/main/resources/config.properties";

    public String getValue(String key) {
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            //Обращаемся к конфиг-файлу
            fileInputStream = new FileInputStream(pahtToConfig);
            prop.load(fileInputStream);
            //Получаем значение в соответствии с указанным ключем
            String value = prop.getProperty(key);
            return (value);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }
}