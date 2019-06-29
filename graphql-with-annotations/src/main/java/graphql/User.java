package graphql;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import lombok.Builder;
import lombok.Data;

@GraphQLName("user")
@Data
@Builder
public class User {
  @GraphQLField private Long id;
  @GraphQLField private String name;
  @GraphQLField private String email;
}
