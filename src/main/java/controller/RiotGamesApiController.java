package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiotGamesApiController {
    @Autowired
    private LeaguePositionService leaguePositionService;
}
