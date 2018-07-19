package task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(
			name = "getAllmessages",
			query = "SELECT  m FROM message AS m ORDER BY m DESC"

			)
})
@Table(name = "messages")


public class message {
   @Id
   @Column(name = "tasks", length = 200, nullable = false)
   private String tasks;

   @Column(name = "content", length = 250, nullable = false)
   private String content;

   public String getTasks() {
	   return  tasks;
   }

   public void setTasks(String tasks) {
	   this.tasks = tasks;
   }

   public String getContent(){
	   return content;
   }

   public void setContent(String content) {
	   this.content = content;
   }
}
