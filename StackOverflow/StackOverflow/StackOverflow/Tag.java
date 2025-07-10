package StackOverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Tag {
    private String tagId;
    private String tagName;
    private List<Quetion> questions;

    Tag(String tagName) {
        this.tagId = UUID.randomUUID().toString();
        this.tagName = tagName;
        questions = new ArrayList<>();
    }

    public void addQuestion(Quetion quetion) {
        questions.add(quetion);
    }

    public String getTagName() {
        return tagName;
    }

    public String getTagID() {
        return tagId;
    }

    public List<Quetion> getQuestions() {
        return questions;
    }
}
