package StackOverflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Quetion implements Commentable {
    private String quetionId;
    private String title;
    private String content;
    private User author;
    private final Date creationDate;
    private List<Answer> answers;
    private List<Comment> comments;
    private List<Votes> votes;
    private List<Tag> tag;

    Quetion(String title, String content, User author, List<Tag> tag) {
        this.quetionId = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
        this.author = author;
        answers = new ArrayList<>();
        comments = new ArrayList<>();
        votes = new ArrayList<>();
        this.creationDate = new Date();
        this.tag = tag;
    }

    public synchronized void addVote(VoteType voteType, User user) {
        votes.removeIf(v -> v.getVoter().getUserId().equals(user.getUserId()));
        votes.add(new Votes(user, voteType));
        author.updateReputation(voteType == voteType.UPVOTE ? 5 : -2);

    }

    public synchronized void addAnswer(Answer answer) {
        answers.add(answer);
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    // GETTERS

    public User getUser() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    public List<Tag> getTags() {
        return tag;
    }

    public String getQuetionId() {
        return quetionId;
    }

    public int getVoteCount() {
        return votes.size();
    }

    public List<Votes> getVotes() {
        return votes;
    }

    public User getAuthor() {
        return author;
    }
}
