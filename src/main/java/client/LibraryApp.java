package client;

import service.LibraryOperationImpl;
import java.util.*;
import model.Library;

public class LibraryApp {
	
	private LibraryOperationImpl lib;
	private static Scanner sc;
	private List<Library> lst;
	
	public LibraryApp() {
		lib = new LibraryOperationImpl();
		sc = new Scanner(System.in);
	}
	
	public void insert() {
		Library l = new Library();
		System.out.println("Enter book id: ");
		l.setBook_id(sc.nextInt());
		System.out.println("Enter book name: ");
		l.setBook_name(sc.next());
		System.out.println("Enter book author: ");
		l.setBook_author(sc.next());
		System.out.println("Enter book category: ");
		l.setBook_category(sc.next());
		lib.insert(l);
	}
	
	public void delete() {
		System.out.println("Enter the id of the record you want to delete: ");
		int id = sc.nextInt();
		lib.delete(id);
	}
	
	public void retrieve() {
		lst = lib.lst();
		for(Library l : lst) {
			System.out.println("Book id: "+l.getBook_id());
			System.out.println("Book name: "+l.getBook_name());
			System.out.println("Book author: "+l.getBook_author());
			System.out.println("Book category: "+l.getBook_category());
		}
	}
	
	public void update() {
		Library l = new Library();
		System.out.println("Enter book id that you want to update: ");
		l.setBook_id(sc.nextInt());
		System.out.println("Enter book name: ");
		l.setBook_name(sc.next());
		System.out.println("Enter book author: ");
		l.setBook_author(sc.next());
		System.out.println("Enter book category: ");
		l.setBook_category(sc.next());
		lib.update(l);
	}
	
	public void display() {
		System.out.println("What is the book id you want to look up: ");
		lib.getData(sc.nextInt());
	}
	
	public static void main(String [] args) {
		LibraryApp app = new LibraryApp();
		String command = "";
		while(!command.equals("quit")) {
			System.out.println("Enter command: insert/search/delete/retrieve/update/quit");
			command = sc.next();
			if(command.equals("insert")) {
				app.insert();
			}else if(command.equals("search")) {
				app.display();
			}else if(command.equals("delete")) {
				app.delete();
			}else if(command.equals("retrieve")) {
				app.retrieve();
			}else if(command.equals("update")) {
				app.update();
			}else if(command.equals("quit")){
				System.exit(0);
			}else {
				System.out.println("command not recognized");
			}
		}
	}
}
