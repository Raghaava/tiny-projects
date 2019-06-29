package graphql.components;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class PostResolver implements GraphQLQueryResolver {
  Post getPost(int id) {
    return null;
  }
}
