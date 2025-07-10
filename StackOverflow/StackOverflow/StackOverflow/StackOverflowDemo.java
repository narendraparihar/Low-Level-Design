package StackOverflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StackOverflowDemo {

    public static void main(String[] args) {
        System.out.println("Stack overflow LLD");
        run();
    }

    public static void run() {
        StackOverflow stackOverflow = StackOverflow.getInstance();

        User ajay = stackOverflow.createUser("Ajay", "ajay@gmail.com");
        User vijay = stackOverflow.createUser("Vijay", "vijay@gmail.com");
        User sujay = stackOverflow.createUser("Sujay", "sujay@gmail.com");

        Quetion javaQuetion = stackOverflow.postQuestion(ajay, "What is abstraction in Java?",
                "Some content", Arrays.asList(new Tag("JAVA"), new Tag("OOPS")));
        Quetion OOPsQuetion = stackOverflow.postQuestion(ajay, "What's OOPS", "OOPS q content",
                Arrays.asList(new Tag("OOPS"), new Tag("LLD")));

        Answer VijayAnswer = stackOverflow.postAnswer(vijay,
                "abstraction is hiding implementaion details and displaying only necessary details",
                javaQuetion.getQuetionId());

        javaQuetion.addComment(new Comment("Great Question", sujay));
        VijayAnswer.addComment(new Comment("Great Answer", sujay));

        javaQuetion.addVote(VoteType.UPVOTE, sujay);
        VijayAnswer.addVote(VoteType.UPVOTE, sujay);

        System.out.println("Quetion :" + javaQuetion.getTitle());

        System.out.println("Asked By :" + javaQuetion.getAuthor().getUserName());
        System.out
                .println("Tags : " + javaQuetion.getTags().stream().map(Tag::getTagName).reduce((a, b) -> a + "," + b));
        System.out.println("Answer By :" + VijayAnswer.getUser().getUserName());
        System.out.println("Answer :" + VijayAnswer.getContent());
        System.out.println("Comments :" + VijayAnswer.getComments().size());

        System.out.println("\nUser Reputaion");
        System.out.println("ajay :" + ajay.getReputation());
        System.out.println("vijay :" + vijay.getReputation());
        System.out.println("sujay :" + sujay.getReputation());

        System.out.println("\nSearch Result for JAVA :");
        List<Quetion> quetions = stackOverflow.searchQuetions("in");
        for (int i = 0; i < quetions.size(); i++) {
            System.out.println(quetions.get(i).getTitle());
        }

        System.out.println("\n Get ajay's quetions :");
        List<Quetion> ajayQuetions = stackOverflow.getQuetionsByUser(ajay);
        for (int i = 0; i < ajayQuetions.size(); i++) {
            System.out.println(ajayQuetions.get(i).getTitle());
        }

    }
}
