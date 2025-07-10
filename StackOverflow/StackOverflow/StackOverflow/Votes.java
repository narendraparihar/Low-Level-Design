package StackOverflow;

public class Votes {
    private String voteId;
    private User voter;
    private VoteType type;

    Votes(User user, VoteType type) {
        this.voter = user;
        this.type = type;
    }

    public User getVoter() {
        return voter;
    }

    public VoteType getVoteType() {
        return type;
    }

}
