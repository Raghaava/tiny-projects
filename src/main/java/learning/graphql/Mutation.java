//package learning.graphql;
//
//import com.coxautodev.graphql.tools.GraphQLMutationResolver;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Mutation implements GraphQLMutationResolver {
//  public Post writePost(String title, String text, String category) {
//    return new Post.PostBuilder()
//        .category(category)
//        .title(title)
//        .text(text)
//        .authorId("authorId-text")
//        .build();
//  }
//}
