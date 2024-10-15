package com.ForumApplication.QAForum.service.serviceImpl;

import com.ForumApplication.QAForum.model.Vote;
import com.ForumApplication.QAForum.repository.VoteRepository;
import com.ForumApplication.QAForum.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public Vote saveVote(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public List<Vote> saveVotes(List<Vote> votes) {
        return voteRepository.saveAll(votes); // Ensure this is a List<Vote>
    }


    @Override
    public Vote getVoteById(Long voteId) {
        return voteRepository.getById(voteId);
    }

    @Override
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    @Override
    public Vote updateVote(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public void deleteVote(Long voteId) {
        voteRepository.deleteById(voteId);
    }

}
