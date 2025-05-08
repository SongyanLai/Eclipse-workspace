import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class TrainTimeParser {
    public static void main(String[] args) throws Exception {
        String station = "DCE";      // 车站代码，可按需修改
        int minutes = 720;           // 720 分钟 = 12 小时
        String api = "http://api.irishrail.ie/realtime/realtime.asmx/"
                   + "getStationDataByCodeXML_WithNumMins"
                   + "?StationCode=" + station
                   + "&NumMins=" + minutes;

        // 1. 获取 XML 原始字符串
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(
                 new InputStreamReader(new URL(api).openStream(), "UTF-8"))) {
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
        }

        // 2. 解析 XML，显式关闭命名空间支持
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(false);        // 忽略 xmlns，按本地名查找
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(
            new ByteArrayInputStream(sb.toString().getBytes("UTF-8"))
        );

        // 3. 获取所有 objStationData 节点
        NodeList nl = doc.getElementsByTagName("objStationData");

        // 4. 输出最简单的 HTML 表格
        try (PrintWriter out = new PrintWriter("output.html", "UTF-8")) {
            out.println("<html><body>");
            out.println("<h3>Station: " + station + "</h3>");
            out.println("<table border=\"1\">");
            out.println("<tr><th>Arr</th><th>Orig</th><th>Dest</th><th>Dep</th><th>Last</th></tr>");

            for (int i = 0; i < nl.getLength(); i++) {
                Element e = (Element) nl.item(i);
                String arr  = getText(e, "ExpArrival");
                String orig = getText(e, "Origin");
                String dest = getText(e, "Destination");
                String dep  = getText(e, "ExpDepart");
                String last = getText(e, "LastLocation");
                out.printf(
                  "<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>%n",
                  arr, orig, dest, dep, last
                );
            }

            out.println("</table>");
            out.println("</body></html>");
        }

        System.out.println("✅ output.html 已生成，打开即可查看未来12小时数据");
    }

    private static String getText(Element e, String tag) {
        NodeList list = e.getElementsByTagName(tag);
        if (list.getLength() == 0) return "";
        return list.item(0).getTextContent().trim();
    }
}
