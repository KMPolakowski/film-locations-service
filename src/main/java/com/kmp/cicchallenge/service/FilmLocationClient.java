package com.kmp.cicchallenge.service;

import com.kmp.cicchallenge.domain.FilmLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class FilmLocationClient {

    private RestTemplate template;

    private final String url;

    private final Integer fetchLimit;

    public FilmLocationClient(RestTemplate template, @Value("${api.url}") String url, @Value("${api.fetch.limit}") Integer fetchLimit) {
        this.template = template;
        this.url = url;
        this.fetchLimit = fetchLimit;
    }

    public FilmLocation[] fetchFilmLocations() throws RestClientException {

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(url)
                .queryParam("$query", "select *, :id order by `title` asc limit " + fetchLimit);

        return template.getForObject(
                URLDecoder.decode(builder.toUriString(), StandardCharsets.UTF_8),
                FilmLocation[].class
        );
    }
}
