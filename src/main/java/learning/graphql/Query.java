//package learning.graphql;
//
//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
//import com.google.common.collect.Lists;
//import lombok.Builder;
//import lombok.Data;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class Query implements GraphQLQueryResolver {
//  public List<Post> recentPosts(int count, int offset) {
//    return Lists.newArrayList(
//        new Post.PostBuilder()
//            .category("category-text")
//            .title("title-text")
//            .text("text-text")
//            .authorId("authorId-text")
//            .build());
//  }
//}
//
//@Data
//@Builder
//class Post {
//  private String id;
//  private String title;
//  private String text;
//  private String category;
//  private String authorId;
//}
