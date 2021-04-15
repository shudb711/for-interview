//package all.javalearn;
//
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.web.client.RequestCallback;
//import org.springframework.web.client.ResponseExtractor;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//import java.net.URI;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
///**
// * 配置RestTemplate
// * Created by jianmin on 2017/11/16.
// */
//@Configuration
//public class RestTemplateConfig {
//    Logger logger = LoggerFactory.getLogger(RestTemplateConfig.class);
//
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(){
//        RestTemplate restTemplate= new RestTemplate();
//        return restTemplate;
//    }
//
//
//
//
//}
