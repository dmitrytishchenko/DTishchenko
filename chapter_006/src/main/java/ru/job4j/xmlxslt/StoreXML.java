package ru.job4j.xmlxslt;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

/**
 * генерация XML из данных базы
 * target- файл в который будут сохраняться данные
 * для создания файла XML использовать технологию JAXB
 */
public class StoreXML {
    private File target;

    public StoreXML(File target) {
        this.target = target;
    }

    /**
     * метод save - сохраняет данные из list в target
     */
    public void save(List<Entry> list) throws JAXBException {
        try {
//     создание объекта Marshaller, который выполняет сериализацию
            JAXBContext jaxbContext = JAXBContext.newInstance(StoreSQL.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // сериализация
            jaxbMarshaller.marshal(new StoreSQL(list), target);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

