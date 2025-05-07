// ���������IO��HttpClient���
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.impl.client.CloseableHttpClient;  // �ɹرյ�HTTP�ͻ��˽ӿ�
import org.apache.http.client.methods.CloseableHttpResponse; // �ɹرյ�HTTP��Ӧ����
import org.apache.http.impl.client.HttpClients;             // HttpClient������
import org.apache.http.client.methods.HttpGet;              // HTTP GET������

public class HTTPClient {
    public static void main(String[] args) throws IOException {
        // 1. ����Ĭ�����õ�HTTP�ͻ���ʵ��
        // (ʹ��try-with-resources����ȫ�����˴�Ϊԭʼд��)
        CloseableHttpClient client = HttpClients.createDefault();
        
        // 2. ����ָ��Ŀ��URL��GET�������
        HttpGet request = new HttpGet("http://www.cs.nuim.ie");
        
        // 3. ִ�����󲢻�ȡ��Ӧ����
        CloseableHttpResponse response = client.execute(request);
        
        // 4. ����Ӧʵ���л�ȡ����������װ�ɻ����ȡ��
        // ע�⣺δָ���ַ����루Ĭ��ʹ��ϵͳ���룩
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        
        // 5. ���ж�ȡ��Ӧ���ݲ���ӡ
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
        
        // 6. �ֶ��ر���Դ���Ƽ�ʹ��try-with-resources�Զ��رգ�
        response.close();  // �ر���Ӧ
        client.close();    // �رտͻ�������
    }
}

/* ����ִ������˵����
   1. ����HTTP�ͻ��� -> 2. ����GET���� -> 3. �������� -> 4. ��ȡ��Ӧ��
   -> 5. ������� -> 6. ������Դ

   Ǳ�ڸĽ��㣺
   - ���HTTP״̬���飨��200 OK��
   - ʹ��try-with-resources�Զ��ر���Դ
   - ָ���ַ����루��UTF-8��
   - ����쳣�����߼�
   - ���ó�ʱʱ�������
   - ������ܵ�SSL/TLS֤������
*/