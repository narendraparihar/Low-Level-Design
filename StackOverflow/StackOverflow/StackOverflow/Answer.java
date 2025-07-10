package StackOverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Answer implements Commentable {
    private String answerId;
    private String quetionId;
    private String content;
    private User author;
    private List<Comment> comments;
    private List<Votes> votes;

    Answer(User author, String questionId, String content) {
        this.answerId = UUID.randomUUID().toString();
        this.quetionId = questionId;
        this.author = author;
        this.content = content;
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addVote(VoteType voteType, User user) {
        votes.removeIf(v -> v.getVoter().getUserId().equals(user.getUserId()));
        votes.add(new Votes(user, voteType));
        author.updateReputation(voteType == voteType.UPVOTE ? 3 : -1);
    }

    // GETTERS
    public String getId() {
        return answerId;
    }

    public User getUser() {
        return author;
    }

    public String getContent() {
        return content;
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }
}
