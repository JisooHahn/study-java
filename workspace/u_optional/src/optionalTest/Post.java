package optionalTest;

import java.util.Objects;

public class Post {
	private Long id;
	   private String title;
	   private String content;
	   
	   public Post() {;}

	   public Post(Long id, String title, String content) {
	      super();
	      this.id = id;
	      this.title = title;
	      this.content = content;
	   }

	   public Long getId() {
	      return id;
	   }

	   public void setId(Long id) {
	      this.id = id;
	   }

	   public String getTitle() {
	      return title;
	   }

	   public void setTitle(String title) {
	      this.title = title;
	   }

	   public String getContent() {
	      return content;
	   }

	   public void setContent(String content) {
	      this.content = content;
	   }

	   @Override
	   public String toString() {
	      return "Post [id=" + id + ", title=" + title + ", content=" + content + "]";
	   }

	   @Override
	   public boolean equals(Object obj) {
	      if (this == obj)
	         return true;
	      if (obj == null)
	         return false;
	      if (getClass() != obj.getClass())
	         return false;
	      Post other = (Post) obj;
	      return Objects.equals(id, other.id);
	   }
}
