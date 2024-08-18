package com.ConsumingRestAPI.ConsumingRestAPI.services;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class AppService {

    private final RestTemplate restTemplate;

    String baseUrl = "https://jsonplaceholder.typicode.com";
    StringBuilder stringBuilder = new StringBuilder(baseUrl);

    String POST = "/posts";
    String POSTBYID = "/posts/";

    @Autowired
    public AppService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> getPosts(){

        HttpEntity <Void> httpEntity = new HttpEntity<>(getHttpHeaders());

        String url = stringBuilder.append(POST).toString();

        val response =  restTemplate.exchange(
                url,
                HttpMethod.GET,
                httpEntity,
                List.class
        );
        return response.getBody();
    }

    public Map<String, Object> getPostsById(int id){

        HttpEntity <Void> httpEntity = new HttpEntity<>(getHttpHeaders());

        String url = stringBuilder.append(POSTBYID).append(id).toString();

        val response =  restTemplate.exchange(
                url,
                HttpMethod.GET,
                httpEntity,
                Map.class
        );
        return response.getBody();
    }

    public Map<String, Object> insertPosts(Map<String, Object> payload){

        HttpEntity <Map<String,Object>> httpEntity = new HttpEntity<>(payload, getHttpHeaders());

        String url = stringBuilder.append(POST).toString();

        val response =  restTemplate.exchange(
                url,
                HttpMethod.POST,
                httpEntity,
                Map.class
        );
        return response.getBody();
    }

    public Map<String, Object> updatePost(Map<String, Object> payload , int id){

        HttpEntity <Map<java.lang.String, java.lang.Object>> httpEntity = new HttpEntity<>(payload, getHttpHeaders());

        java.lang.String url = stringBuilder.append(POSTBYID).append(id).toString();

        val response =  restTemplate.exchange(
                url,
                HttpMethod.PUT,
                httpEntity,
                Map.class
        );
        return response.getBody();
    }

    public Map<String, Object> deletePostByID(int id) {
        HttpEntity <Map> httpEntity = new HttpEntity<>(getHttpHeaders());

        String url = stringBuilder.append(POSTBYID).append(id).toString();

        val response =  restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                httpEntity,
                Map.class
        );
        return response.getBody();
    }

    private HttpHeaders getHttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }


}
