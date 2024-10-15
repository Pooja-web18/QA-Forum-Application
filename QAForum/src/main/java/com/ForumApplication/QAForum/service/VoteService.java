package com.ForumApplication.QAForum.service;

import com.ForumApplication.QAForum.model.Vote;

import java.util.List;

public interface VoteService {
    Vote saveVote(Vote vote);

    List<Vote> saveVotes(List<Vote> votes);

    Vote createVote(Vote vote);
    Vote getVoteById(Long voteId);
    List<Vote> getAllVotes();
    Vote updateVote(Vote vote);
    void deleteVote(Long voteId);
}
