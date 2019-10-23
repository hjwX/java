package com.yuu.test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.text.StringSubstitutor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.yuu.util.PrintTool;

public class DOMTest {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			URI uri = DOMTest.class.getResource("/DOM_test.xml").toURI();
			String fileContent = new String(Files.readAllBytes(new File(uri).toPath()));
			PrintTool.printWithWrap("before fileContent", fileContent);
			System.setProperty("test", "2019年10月21日14:37:46");
			fileContent = StringSubstitutor.replaceSystemProperties("${test}");
			System.out.println(fileContent);
			System.out.println(new File(uri).toPath());
			Document document = builder.parse(new File(uri));
			Element element = document.getDocumentElement();
			NodeList properties = element.getElementsByTagName("properties");
			Element proElement = (Element) properties.item(0);
			System.out.println(proElement.getAttribute("lange"));
			System.out.println(proElement.getChildNodes().getLength());
			NodeList properNodeList = proElement.getChildNodes();
			for(int i = 0; i < properNodeList.getLength(); i++) {
				Node node = properNodeList.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element onePro = (Element) node;
					String content = onePro.getTextContent();
					PrintTool.printWithWrap("", content.trim());
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
