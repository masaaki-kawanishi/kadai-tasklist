package validators;

import java.util.ArrayList;
import java.util.List;

import task.tasks;

public class TasksValidator {
  public static List<String> validate(tasks m) {
	  List<String> errors = new ArrayList<String>();

	  String taskname_error = _validateTaskname(m.getTaskname());
	  if(!taskname_error.equals("")) {
		  errors.add(taskname_error);
	  }

	  String content_error = _validateContent(m.getContent());
	  if(!taskname_error.equals("")) {
		  errors.add(content_error);
	  }

	  return errors;
  }

  private static String _validateTaskname(String taskname) {
	  if(taskname == null || taskname.equals("")) {
		  return "タスクを入力してください。";
	  }

	  return "";
  }

  private static String _validateContent(String content) {
	  if(content == null || content.equals("")){
		  return "内容を入力してください。";
	  }

	  return "";
  }
}
