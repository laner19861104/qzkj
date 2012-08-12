package com.bip.common.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

public class XMLUtil {

	public static Document readDocumentFromFile(String filePath)
			throws IOException {
		return readDocumentFromFile(new File(filePath));
	}

	public static Document readDocumentFromFileStr(String text)
			throws IOException {
		try {
			System.out.println(text);
			return DocumentHelper.parseText(text);
		} catch (DocumentException e) {

			e.printStackTrace();
			return null;
		}
	}

	public static Document readDocumentFromFile(File file) throws IOException {
		try {
			// if (fileExist(filePath))
			// return null;
			SAXReader builder = new SAXReader(false);
			Document FileDocument = builder.read(new FileInputStream(file));
			return FileDocument;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException(e.getMessage());
		}
	}

	public static void addContent(Element e, String elementName, String value) {
		e.addElement(elementName).attributeValue("VAL", value);

	}

	public static void setAttribute(Element e, String elementName, String value) {
		e.element(elementName).attributeValue("VAL", value);
	}

	public static String getAttributeValue(Element e, String elementName,
			String nameValue) {
		if (elementName == null)
			return "";
		return getAttributeValue(e.element(elementName), nameValue);

	}

	public static String getAttributeValue(Element e, String nameValue) {
		if (e == null)
			return "";
		return e.attributeValue(nameValue);
	}

	public static void outputDocumentToFile(Document document,
			String encodingMode) throws IOException {
		Writer out = new OutputStreamWriter(new FileOutputStream(document
				.getPath()), encodingMode);
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out, format);
		writer.write(document);

		out.close();
	}

	public static org.w3c.dom.Document parse(Document doc)
			throws ParserConfigurationException, SAXException, IOException {
		if (doc == null) {
			return (null);
		}
		java.io.StringReader reader = new java.io.StringReader(doc.asXML());
		org.xml.sax.InputSource source = new org.xml.sax.InputSource(reader);
		javax.xml.parsers.DocumentBuilderFactory documentBuilderFactory = javax.xml.parsers.DocumentBuilderFactory
				.newInstance();
		javax.xml.parsers.DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		return (documentBuilder.parse(source));
	}

}
