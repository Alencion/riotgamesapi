package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiotGamesApiController {
    @Autowired
    private LeaguePositionService leaguePositionService;

    @GetMapping("/summoner")
    public LeaguePositionDTO getLeaguePositionDTO(@RequestParam String summonerName){
        return leaguePositionService.getLeaguePosition(summonerName);
    }
}
