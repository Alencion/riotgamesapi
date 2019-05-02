package org.cnu.realcoding.riotgamesapi.repository;

import org.cnu.realcoding.riotgamesapi.domain.LeaguePositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

@Repository
public class CurrentSummonerScoreRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    //Do insert SummonerScore to MongoDB
    void insertCurrentSummonerScore(LeaguePositionDTO leaguePositionDTO) {
        mongoTemplate.insert(leaguePositionDTO);
    }

    //Update Method in MongoDB
    void updateCurrentSummonerScore(LeaguePositionDTO leaguePositionDTO) {
        String updateName;
        for (int idx = 0; idx < leaguePositionDTO.getArray().size(); idx++) {
            LeaguePositionDTO.LeaguePosition chageObj = leaguePositionDTO.getArray().get(idx);
            updateName = chageObj.getSummonerName();

            Query query = new Query();
            query.addCriteria(Criteria.where("summonerId").is(updateName));
            Update update = new Update();
            update.set("tier",chageObj.getTier())
                    .set("wins",chageObj.getWins())
                    .set("losses",chageObj.getLosses())
                    .set("rank",chageObj.getRank())
                    .set("leagueName",chageObj.getLeagueName())
                    .set("leaguePoints",chageObj.getLeaguePoints());

            mongoTemplate.updateFirst(query,update,LeaguePositionDTO.class);
        }
    }
}
