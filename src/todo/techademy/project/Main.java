package todo.techademy.project;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

	private static HashMap<String,User> users = new HashMap<String,User>();
	private static User loggedUser = null;
	private static void usrReg(Scanner sc){
		System.out.print("Enter the name of the person: ");
		String name, username, password;
		name = sc.nextLine();
		System.out.print("Enter the userID of the person: ");
		username = sc.nextLine();
		System.out.println("Enter the password of the person:");
		password = sc.nextLine();
		User u = new User(name,username,password);
		if(!users.containsKey(name)) users.put(username,u);
		else System.out.println("USER ID ALREADY EXISTS PLEASE RETRY");
	}
	private static void usrLog(Scanner sc){
		System.out.println("Enter your username: ");
		String username = sc.nextLine();
		if(users.containsKey(username)){
			User curr = users.get(username);
			System.out.print("Welcome "+curr.getName()+"! kindly enter your password: ");
			String password = sc.nextLine();
			if (password.equals(curr.getPassword())){
				System.out.println("You have been successfully logged in");
				loggedUser = curr;
			}else
				System.out.println("Password incorrect! Please retry!");
		}else{
			System.out.println("No User found!!");
		}
		
	}
	private static void usrTodo(Scanner sc){
		// Checks if there is user logged in or not. 
		if(loggedUser!=null){
			while(true){
				// Code for printing menu screen
				int option;
				System.out.println(loggedUser.getName()+"'s todos list is: ");
				loggedUser.printList();
				System.out.println("What would you like to do: ");
				System.out.println("1. Add new entry? ");
				System.out.println("2. Add todo at a position: ");
				System.out.println("3. Edit an todo");
				System.out.println("4. Delete todo at a position");
				System.out.println("5. Mark a todo as completed ");
				System.out.println("Press any key to return to main menu and log out!");
				// Takes the input
				try{
					option = Integer.parseInt(sc.nextLine());
				}catch(Exception e){
					loggedUser = null;
					return;
				}
				switch(option){
				case 1: System.out.println("Please write your todo: ");
				loggedUser.usrTodo.add(sc.nextLine());
				loggedUser.isCompleted.add("Pending");
				break;
				case 2: System.out.print("Please enter the position you want to add at: ");
				int pos = Integer.parseInt(sc.nextLine())-1;
				System.out.println("Please enter the text: ");
				String text = sc.nextLine();
				loggedUser.usrTodo.add(pos,text);
				loggedUser.isCompleted.add(pos,"Pending");
				break;
				case 3: System.out.print("Enter the postion of the Todo you wish to edit: ");
				pos = Integer.parseInt(sc.nextLine())-1;
				System.out.println("Please enter the new todo: ");
				loggedUser.usrTodo.add(pos,sc.nextLine());
				loggedUser.usrTodo.remove(pos+1);
				break;
				
				case 4: System.out.print("Enter the postion you want to delete");
				pos = Integer.parseInt(sc.nextLine())-1;
				loggedUser.usrTodo.remove(pos);
				loggedUser.isCompleted.remove(pos);
				System.out.println("Text as pos "+(pos+1)+" removed!");
				break;
				case 5: System.out.println("Enter the postion of the completed todo: ");
				pos = Integer.parseInt(sc.nextLine())-1;
				loggedUser.isCompleted.add(pos, "Completed");
				loggedUser.isCompleted.remove(pos+1);
				System.out.println("Okay! your todo "+loggedUser.usrTodo.get(pos)+" has been marked completed");
				break;
				}
			}
		}else System.out.println("No User logged in currently. Kindly log in first");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true){
			int option = 0;
			System.out.println("Enter the one the option given below");
			System.out.println("1.User registration");
			System.out.println("2.User login");
			System.out.println("3.Enter todo");
			System.out.println("Use Any key to logout the user and exit the application");
			System.out.println("NOTE:After exiting all data will be lost");
			try{
			option = Integer.parseInt(sc.nextLine());
			}catch(Exception e){
				System.out.println("Bye Bye!");
				System.exit(0);
			}
			switch(option){
			case 1: usrReg(sc); break;
			case 2: usrLog(sc); break;
			case 3: usrTodo(sc); break;
			}
		}
	}
}