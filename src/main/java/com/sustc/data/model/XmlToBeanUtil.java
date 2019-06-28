package com.sustc.data.model;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

public class XmlToBeanUtil {

    public static List<Member> xmlToBean(String xml){
        List<Member> list = null;
        try {
            list = start(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static ECReport xmlToBean1(String xml){
        ECReport ecReport = new ECReport();
        ecReport.setMemberList(xmlToBean(xml));
        return ecReport;
    }
    public static Document getDocument(String xml) throws DocumentException {
        StringReader read = new StringReader(xml);
        InputSource source = new InputSource(read);
        SAXReader sb = new SAXReader();
        Document doc = sb.read(source);
        return doc;
    }
    private static List<Member> start(String xml) throws Exception {
        Document doc = getDocument(xml);
        List<Node> listepc = doc.selectNodes("//ECReports/reports/report/group/groupList/member/epc");
        List<Node> listraw = doc.selectNodes("//ECReports/reports/report/group/groupList/member/rawHex");
        List<Node> listdec = doc.selectNodes("//ECReports/reports/report/group/groupList/member/rawDecimal");
        List<Member> list = new LinkedList<>();
        for(int i=0;i<listepc.size();i++){
            Member member = new Member(listepc.get(i).getText(),listraw.get(i).getText(),listdec.get(i).getText());
            list.add(member);
        }
        return list;
    }
}
