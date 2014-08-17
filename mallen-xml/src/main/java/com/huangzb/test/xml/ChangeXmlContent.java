package com.huangzb.test.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class ChangeXmlContent {
	public static void main(String[] args) {
		File bpmn = new File("d:/changeprocessid.bpmn");
		File file = changeId(bpmn);
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(file);
			Element root = document.getRootElement();
			Element processElement = root.element("process");
			String processId = processElement.attribute("id").getText();
			System.out.println("id is " + processId);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	private static File changeId(File bpmn) {
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(bpmn);
			Element root = document.getRootElement();
			Element processElement = root.element("process");
			String processId = processElement.attribute("id").getText();
			processElement.attribute("id").setText(processId + "-hz");
			saveXml(document);
			
			return new File("d:/dom4jTest.xml");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private static void saveXml(Document document) {
		OutputFormat outputFormat = OutputFormat.createPrettyPrint();
		outputFormat.setLineSeparator("\r\n");// 这是为了换行操作
		Writer writer;
		try {
			writer = new FileWriter("d:/dom4jTest.xml");
			XMLWriter outPut = new XMLWriter(writer, outputFormat);
			outPut.write(document);
			outPut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
