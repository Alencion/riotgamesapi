package org.cnu.realcoding.riotgamesapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiotGamesApiClient {

    @Autowired
    private RestTemplate restTemplate;
    private static String APIKEY;
    private String requestSummonerDTO;
    private String requestLeaguePositionDTO;


}
