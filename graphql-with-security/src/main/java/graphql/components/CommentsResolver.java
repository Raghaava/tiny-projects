package graphql.components;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentsResolver implements GraphQLResolver<Post> {
  public List<Comment> getComments(Post post) {
    return post.comments;
  }
}
