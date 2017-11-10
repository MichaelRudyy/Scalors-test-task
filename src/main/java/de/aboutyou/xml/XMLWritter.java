package de.aboutyou.xml;

import de.aboutyou.holders.ProductHolder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * XMLWritter
 * Class that write data from ProductHolder instances to XML file
 *
 * @author Michael Rudyy
 * @version 1.2
 */
public class XMLWritter {

    private String path;
    private Document document;
    private Element currentElement;

    public XMLWritter(String path) {
        this.path = path;
    }

    public void start() {
        try {
            // создаем пустой объект Document, в котором будем
            // создавать наш xml-файл
            document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void end() {
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance()
                    .newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }

        DOMSource source = new DOMSource(document);
        StreamResult file = new StreamResult(new File(path));
        try {
            transformer.transform(source, file);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void addRootElement(String tagName) {
        currentElement = document.createElement(tagName);
        document.appendChild(currentElement);
    }

    public void addElement(ProductHolder product) {
        currentElement.appendChild(addProduct(product));
    }

    private Node addProduct(ProductHolder product) {
        Element offer = document.createElement("offer");
        offer.appendChild(getElement("name", product.getName()));
        offer.appendChild(getElement("brand", product.getBrand()));
        offer.appendChild(getElement("color", product.getColor()));
        offer.appendChild(getElement("price", product.getPrice()));
        offer.appendChild(getElement("initialPrice", product.getInitialPrice()));
        offer.appendChild(getElement("description", product.getDescription()));
        offer.appendChild(getElement("articleID", product.getArticleID()));
        offer.appendChild(getElement("shippingCost", product.getShippingCosts()));
        return offer;
    }

    private Node getElement(String name, String value) {
        Element node = document.createElement(name);
        node.appendChild(document.createTextNode(value));
        return node;
    }
}
