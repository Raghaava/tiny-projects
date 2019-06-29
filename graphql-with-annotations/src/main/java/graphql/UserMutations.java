package graphql;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import graphql.schema.DataFetchingEnvironment;

import javax.validation.constraints.NotNull;

@GraphQLName("mutation")
public class UserMutations {
  @GraphQLField
  public static User createUser(
      DataFetchingEnvironment env,
      @NotNull @GraphQLName("name") String name,
      @NotNull @GraphQLName("email") String email) {
    User user =
        new User.UserBuilder().id(Application.users.size() + 1L).email(email).name(name).build();
    Application.users.add(user);
    return user;
  }
}
