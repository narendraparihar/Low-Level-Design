package StackOverflow;

import java.util.UUID;

public class Comment {
    private String commentId;
    private String content;
    private int votes;
    private User author;

    Comment(String content, User user) {
        this.commentId = UUID.randomUUID().toString();
        this.content = content;
        this.author = user;
    }

    public String getContent(String commentId) {
        return content;
    }

    public void addVote(Comment comment) {
        comment.votes += 1;
    }
}
