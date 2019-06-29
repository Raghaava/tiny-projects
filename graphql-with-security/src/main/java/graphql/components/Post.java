package graphql.components;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Data
public class Post {
  protected int id;
  protected String text;


  protected ArrayList<Comment> comments;
}
