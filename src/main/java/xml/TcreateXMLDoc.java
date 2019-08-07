package xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class TcreateXMLDoc {
    public static void main(String[] args) throws IOException {
        XMLWriter writer = null;
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("book");
        root.addAttribute("id", "1");
        root.addElement("action").addAttribute("id", "1").addAttribute("name", "动作片").addText("精卫填海");
        String path="d:\\data\\createXml.xml";
        writer=new XMLWriter(new FileOutputStream(new File(path)), OutputFormat.createPrettyPrint());
        writer.write(document);
    }
}
