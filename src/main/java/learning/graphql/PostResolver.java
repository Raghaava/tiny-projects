//package learning.graphql;
//
//import com.coxautodev.graphql.tools.GraphQLResolver;
//import com.google.common.collect.Lists;
//import lombok.Builder;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class PostResolver implements GraphQLResolver<Post>{
//    public Author getAuthor(Post post)
//    {
//      return new Author.AuthorBuilder()
//              .id(post.getAuthorId())
//              .name("author-test")
//              .posts(Lists.newArrayList(post,new Post.PostBuilder().text("I am there too!").build()))
//              .thumbnail("thumbnail-test")
//              .build();
//    }
//}
//
//@Builder
//class Author
//{
//    private String id;
//    private String name;
//    private String thumbnail;
//    private List<Post> posts;
//}
