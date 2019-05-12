package ru.job4j.xmlxslt;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxPars extends DefaultHandler {
    String thisElement = " ";
    int sum = 0;
    File file;

    public SaxPars(File file) {
        this.file = file;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML");
    }

    /**
     * Receive notification of the start of an element.
     *
     * <p>By default, do nothing.  Application writers may override this
     * method in a subclass to take specific actions at the start of
     * each element (such as allocating a new tree node or writing
     * output to a file).</p>
     *
     * @param uri        The Namespace URI, or the empty string if the
     *                   element has no Namespace URI or if Namespace
     *                   processing is not being performed.
     * @param localName  The local name (without prefix), or the
     *                   empty string if Namespace processing is not being
     *                   performed.
     * @param qName      The qualified name (with prefix), or the
     *                   empty string if qualified names are not available.
     * @param attributes The attributes attached to the element.  If
     *                   there are no attributes, it shall be an empty
     *                   Attributes object.
     * @throws SAXException Any SAX exception, possibly
     *                      wrapping another exception.
     * @see ContentHandler#startElement
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if("field".equals(qName)) {
            sum += Integer.parseInt(attributes.getValue(0));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        thisElement = " ";
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Stop parse XML");
    }

    public void parsing() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SaxPars saxPars = new SaxPars(file);
        parser.parse("target2.xml", saxPars);
    }
}
