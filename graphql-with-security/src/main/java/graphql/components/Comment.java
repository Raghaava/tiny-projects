package graphql.components;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Comment {
    private int id;
    private String text;
}
