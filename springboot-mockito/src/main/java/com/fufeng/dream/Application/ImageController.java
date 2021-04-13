package com.fufeng.dream.Application;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author luocy
 * @description TODO
 * @program Java-group
 * @create 2021-03-30
 * @since 1.0
 */
@Controller
@RequestMapping("/image")
public class ImageController {

    @GetMapping("/")
    public void hand(HttpServletResponse response) throws IOException {
        //String url = "http://47.114.166.33:9000/demo001/%E5%B9%BF%E5%8F%91%E7%B3%BB%E7%BB%9F%E5%8A%9F%E8%83%BD%E7%82%B9.png?Content-Disposition=attachment%3B%20filename%3D%22%E5%B9%BF%E5%8F%91%E7%B3%BB%E7%BB%9F%E5%8A%9F%E8%83%BD%E7%82%B9.png%22&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20210330%2F%2Fs3%2Faws4_request&X-Amz-Date=20210330T044454Z&X-Amz-Expires=432000&X-Amz-SignedHeaders=host&X-Amz-Signature=a4584a2aebc9e34b849a81edfd132181301ec2d89aa8971355f2a7876ce3178c";
        String url = "https://mmbiz.qpic.cn/mmbiz_jpg/yvBJb5IiafvnniaWKsv7ArCIZNTHM038xgcoYUicxImXQ8btBlmiblsia0siaFiabGq0r3tz2H9wmfK1QaT99alIY5ndw/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1";
        final byte[] bytes = doGetTestOne(url);
        response.setContentType("image/png");
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        ServletOutputStream out = response.getOutputStream();
        out.write(bytes);
    }

    /**
     * GET---无参测试
     *
     * @date 2018年7月13日 下午4:18:50
     */
    public byte[] doGetTestOne(String url) {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet(url);

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                //System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
                //File file = new File("./1.png");
                //FileOutputStream fos = new FileOutputStream(file);
                final InputStream content = responseEntity.getContent();
                final byte[] bytes = content.readAllBytes();
                //fos.write(bytes);
                return bytes;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
