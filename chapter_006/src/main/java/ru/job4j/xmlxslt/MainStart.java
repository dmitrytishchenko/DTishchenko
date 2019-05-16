package ru.job4j.xmlxslt;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainStart {
    private static File target = new File("target.xml");
    private static File target2 = new File("target2.xml");
    private static File scheme = new File("xsl.xsl");

    public static void main(String[] args) throws JAXBException, IOException, SAXException, ParserConfigurationException {
        //создание базы данных "magnit"
        long startApplication = System.currentTimeMillis();
        Config config = new Config();
        StoreSQL st = new StoreSQL(config);
        //создание новой таблицы
        st.createTable();
        //генерация 5 записей
        st.generate(1000000);
        //создание списка элементов
        List<Entry> list = st.load();
        StoreXML storeXML = new StoreXML(target);
        //преобразование списка в файл .xml через JAXB
        storeXML.save(list);
        //второе преобразование в .xml через XSLT
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.convert(target, target2, scheme);
        //парсинг .xml
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SaxPars saxPars = new SaxPars(target2);
        parser.parse(target2, saxPars);
        System.out.println(saxPars.getSum());
        System.out.println(System.currentTimeMillis() - startApplication);
    }
}