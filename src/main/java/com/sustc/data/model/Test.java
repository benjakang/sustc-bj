package com.sustc.data.model;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<ns2:ECReports terminationCondition=\"DURATION\" totalMilliseconds=\"952\" ALEID=\"ETHZ-ALE-2123098753\" date=\"2019-05-28T10:47:16.398+08:00\" specName=\"EC\" xmlns:ns2=\"urn:epcglobal:ale:xsd:1\">\n" +
                "\t<reports>\n" +
                "\t\t<report>\n" +
                "\t\t\t<group>\n" +
                "\t\t\t\t<groupList>\n" +
                "\n" +
                "\t\t\t\t\t<member>\n" +
                "\t\t\t\t\t<epc>urn:epc:tag:sgtin-96:1.986572296660.2.88592133435</epc>\n" +
                "\t\t\t\t\t<rawHex>urn:epc:raw:96.x302396D12A475094A080AD3B</rawHex>\n" +
                "\t\t\t\t\t<rawDecimal>urn:epc:raw:96.14898305088499509444200148283</rawDecimal>\n" +
                "\t\t\t\t\t</member>\n" +
                "\n" +
                "\t\t\t\t\t<member>\n" +
                "\t\t\t\t\t<epc>urn:epc:tag:sgtin-96:1.447409.3305697.214938544959</epc>\n" +
                "\t\t\t\t\t<rawHex>urn:epc:raw:96.x3039B4EC4C9C38720B55EB3F</rawHex>\n" +
                "\t\t\t\t\t<rawDecimal>urn:epc:raw:96.14925043628061464399057382207</rawDecimal>\n" +
                "\t\t\t\t\t</member>\n" +
                "\n" +
                "\t\t\t\t</groupList>\n" +
                "\t\t\t</group>\n" +
                "\t\t</report>\n" +
                "\t</reports>\n" +
                "</ns2:ECReports>";

        List<Member> list = XmlToBeanUtil.xmlToBean(s);
        System.out.println(list.get(0).getEpc());
    }
}
