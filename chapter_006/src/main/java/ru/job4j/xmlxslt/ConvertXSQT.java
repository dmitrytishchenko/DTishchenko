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
    String xsl = "<?xml version=\"1.0\"?>\n" +
            "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n" +
            "<xsl:template match=\"/\">\n" +
            "<entries>" +
            "   <xsl:for-each select=\"storeSQL/list\">\n" +
            "       <entry>" +
            "           <xsl:attribute name=\"href\">" +
            "               <xsl:value-of select=\"field\"/>" +
            "           </xsl:attribute>" +
            "       </entry>\n" +
            "   </xsl:for-each>\n" +
            " </entries>\n" +
            "</xsl:template>\n" +
            "</xsl:stylesheet>\n";


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
