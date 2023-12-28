package mmilan.MilanWebsite.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.sql.Clob;

@Entity
public class ActivityPost {
//PostID
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Getter
  @Setter
  private Long postID;

//AuthorID
  @Getter
  @Setter
  private Long authorID;

//Content
  @Getter
  @Setter
  private Clob content;

}
