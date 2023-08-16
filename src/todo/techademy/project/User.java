package todo.techademy.project;
import java.util.ArrayList;

/*
 * This class encapsulates each user who are using the todo application. 
 * Each User object will contain name, username and password and a collection of todos in an ArrayList
 * 
 * */
public class User {
	private String name,usrname, password;
	public ArrayList<String> usrTodo;
	public ArrayList<String> isCompleted;
	//Constructor called when user is used
	public User(String name, String usrname, String password) {
		// TODO Auto-generated constructor stub
		usrTodo = new ArrayList<String>();
		isCompleted = new ArrayList<String>();
		this.name = name;
		this.password = password;
		this.usrname = usrname;
		
	}
	public String getUserId(){
		return this.usrname;
	}
	public String getName(){
		return this.name;
	}
	public String getPassword(){
		return this.password;
	}
	public void printList(){
		System.out.print("[");
		if(usrTodo.size()>0)
			System.out.println();
		for(int i=0;i<usrTodo.size();i++)
			System.out.println((i+1)+"."+usrTodo.get(i)+"\t"+isCompleted.get(i));
		System.out.println("]");
	}
	@Override
	public String toString(){
		return "Name of User: "+name+"\nuser ID: "+usrname;
	}
//	@Override 
//	public boolean equals(Object otherObj){
//		if(this==otherObj) return true;
//		
//		User obj = (User) otherObj;
//		return this.usrname.equals(obj.usrname);
//	}
	
}
