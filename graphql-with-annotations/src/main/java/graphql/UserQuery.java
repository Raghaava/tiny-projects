package graphql;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import graphql.schema.DataFetchingEnvironment;

import javax.validation.constraints.NotNull;
import java.util.List;

@GraphQLName("query")
public class UserQuery {
  @GraphQLField
  public static User retrieveUser(@NotNull @GraphQLName("id") String id, DataFetchingEnvironment env) {
    return Application.users.get(Integer.valueOf(id));
  }

  @GraphQLField
  public static List<User> listUsers(DataFetchingEnvironment env) {
    return Application.users;
  }
}
