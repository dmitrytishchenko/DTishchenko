package ru.job4j.xmlxslt;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class ConvertXSQT {
    /**
     * элементарный пример из условия задачи
     * @param source - исходный файл .xml
     * @param dest   - полученный результат .xml
     * @param scheme - схема .xslt
     */

    public void convert(File source, File dest, File scheme) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(scheme));
            transformer.transform(new StreamSource(source), new StreamResult(dest));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
