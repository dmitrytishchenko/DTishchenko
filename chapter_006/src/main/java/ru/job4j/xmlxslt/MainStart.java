package ru.job4j.xmlxslt;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainStart {
    private static File target = new File("target.xml");
    private static File target2 = new File("target2.xml");
    private static File scheme = new File(new ConvertXSQT().xsl);

    public static void main(String[] args) throws JAXBException, SAXException, IOException, ParserConfigurationException {
        Config config = new Config();
        StoreSQL st = new StoreSQL(config);
        //создание базы данных "magnit"
        st.createNewDatabase("magnit");
        //создание новой таблицы
        st.createTable();
        //генерация 5 записей
        st.generate(5);
        //создание списка элементов
        List <Entry> list = st.load();
        StoreXML storeXML = new StoreXML(target);
        //преобразование списка в файл .xml через JAXB
        storeXML.save(list);
        //второе преобразование в .xml через XSLT
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.convert(target, target2, scheme);
        //парсинг .xml
        SaxPars saxPars = new SaxPars(target2);
        saxPars.parsing();
        System.out.println(saxPars.getSum());
    }
}