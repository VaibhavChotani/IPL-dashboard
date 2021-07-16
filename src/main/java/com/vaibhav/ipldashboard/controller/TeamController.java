package com.vaibhav.ipldashboard.controller;

import com.vaibhav.ipldashboard.model.Team;
import com.vaibhav.ipldashboard.repository.MatchRepository;
import com.vaibhav.ipldashboard.repository.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    // public TeamController(TeamRepository teamRepository) {
    // this.teamRepository = teamRepository;
    // }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team team = teamRepository.findByTeamName(teamName);

        team.setMatches(matchRepository.findlatestMatchesByTeam(teamName, 4));

        return team;
    }

}
