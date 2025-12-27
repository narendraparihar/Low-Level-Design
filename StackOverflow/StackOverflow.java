package StackOverflow;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverflow {
    static StackOverflow instance;
    final Map<String, User> users;
    final Map<String, Quetion> quetions;
    final Map<String, Answer> answers;
    final Map<String, Tag> tags;

    private StackOverflow() {
        users = new ConcurrentHashMap<>();
        quetions = new ConcurrentHashMap<>();
        answers = new ConcurrentHashMap<>();
        tags = new ConcurrentHashMap<>();
    }

    static synchronized StackOverflow getInstance() {

        if (instance == null) {
            instance = new StackOverflow();
        }
        return instance;
    }

    User createUser(String userName, String email) {
        User user = new User(userName, email);
        return user;
    }

    Quetion postQuestion(User user, String title, String content, List<Tag> tagsList) {
        for (Tag qTag : tagsList) {
            tags.put(qTag.getTagID(), qTag);
        }
        Quetion quetion = new Quetion(title, content, user, tagsList);
        quetions.put(quetion.getQuetionId(), quetion);
        user.updateReputation(0);
        return quetion;

    }

    Answer postAnswer(User user, String content, String quetionId) {
        Quetion quetion = quetions.get(quetionId);
        Answer answer = new Answer(user, quetionId, content);
        quetion.addAnswer(answer);
        answers.put(answer.getId(), answer);
        return answer;
    }

    List<Quetion> searchQuetions(String query) {
        return quetions.values().stream()
                .filter(q -> q.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        q.getContent().toLowerCase().contains(query.toLowerCase()) ||
                        q.getTags().stream().anyMatch(t -> t.getTagName().equalsIgnoreCase(query.toLowerCase())))
                .collect(Collectors.toList());

    }

    public List<Quetion> getQuetionsByUser(User user) {
        return quetions.values().stream()
                .filter(q -> q.getUser().getUserId().equals(user.getUserId()))
                .collect(Collectors.toList());
    }

}
