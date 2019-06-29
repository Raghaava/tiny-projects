package graphql;

import com.google.common.collect.Lists;
import graphql.annotations.processor.GraphQLAnnotations;
import graphql.schema.GraphQLSchema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {
  public static List<User> users = Lists.newArrayList();

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public GraphQLSchema graphQLSchema() {
    return new GraphQLSchema.Builder()
        .query(GraphQLAnnotations.object(UserQuery.class))
        .mutation(GraphQLAnnotations.object(UserMutations.class))
        .build();
  }
}
