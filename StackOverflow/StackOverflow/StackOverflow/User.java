package StackOverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String userId;
    private final String userName;
    private final String email;
    private int Reputation;
    private List<Quetion> Quetions;
    private List<Answer> Answers;
    private List<Comment> Comments;
    private int QUESTION_UPDATE_REPUTAION = 5;
    private int ANSWER_UPDATE_REPUTAION = 10;
    private int COMMENT_UPDATE_REPUTAION = 2;

    User(String userName, String email) {
        userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.email = email;
        Quetions = new ArrayList<>();
        Answers = new ArrayList<>();
        Comments = new ArrayList<>();
    }

    public void addQuetion(Quetion quetion) {
        updateReputation(QUESTION_UPDATE_REPUTAION);
        Quetions.add(quetion);
    }

    public void addAnswer(Answer answer) {
        updateReputation(ANSWER_UPDATE_REPUTAION);
        Answers.add(answer);
    }

    public synchronized void updateReputation(int reputation) {
        this.Reputation += reputation;
        if (reputation < 0) {
            reputation = 0;
        }
    }

    // GETTERS
    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public List<Quetion> getQuetions() {
        return Quetions;
    }

    public List<Answer> getAnswer() {
        return Answers;
    }

    public List<Comment> getComments() {
        return Comments;
    }

    public int getReputation() {
        return Reputation;
    }

}
