package task;

import javax.persistence.Column;

public class message {
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
