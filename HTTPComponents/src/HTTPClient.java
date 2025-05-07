// 导入所需的IO和HttpClient类库
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.impl.client.CloseableHttpClient;  // 可关闭的HTTP客户端接口
import org.apache.http.client.methods.CloseableHttpResponse; // 可关闭的HTTP响应对象
import org.apache.http.impl.client.HttpClients;             // HttpClient工厂类
import org.apache.http.client.methods.HttpGet;              // HTTP GET请求类

public class HTTPClient {
    public static void main(String[] args) throws IOException {
        // 1. 创建默认配置的HTTP客户端实例
        // (使用try-with-resources更安全，但此处为原始写法)
        CloseableHttpClient client = HttpClients.createDefault();
        
        // 2. 创建指向目标URL的GET请求对象
        HttpGet request = new HttpGet("http://www.cs.nuim.ie");
        
        // 3. 执行请求并获取响应对象
        CloseableHttpResponse response = client.execute(request);
        
        // 4. 从响应实体中获取输入流，包装成缓冲读取器
        // 注意：未指定字符编码（默认使用系统编码）
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        
        // 5. 逐行读取响应内容并打印
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
        
        // 6. 手动关闭资源（推荐使用try-with-resources自动关闭）
        response.close();  // 关闭响应
        client.close();    // 关闭客户端连接
    }
}

/* 代码执行流程说明：
   1. 创建HTTP客户端 -> 2. 构建GET请求 -> 3. 发送请求 -> 4. 读取响应流
   -> 5. 输出内容 -> 6. 清理资源

   潜在改进点：
   - 添加HTTP状态码检查（如200 OK）
   - 使用try-with-resources自动关闭资源
   - 指定字符编码（如UTF-8）
   - 添加异常处理逻辑
   - 设置超时时间等配置
   - 处理可能的SSL/TLS证书问题
*/