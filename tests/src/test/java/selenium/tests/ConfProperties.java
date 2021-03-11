package selenium.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Чтение конфигурации настройки файла.
 */



public class ConfProperties {

    private static FileInputStream fileInputStream;
    private static Properties Properties;
    //
    static {

        try {
            Properties = new Properties();
            fileInputStream = new FileInputStream("src/test/resources/conf.properties");
            Properties.load(fileInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     * @param key поиск свойства в файле properties.
     * @return значение нужного свойства.
     */
    protected static String getProperty(String key) {
        return Properties.getProperty(key);
    }
}

