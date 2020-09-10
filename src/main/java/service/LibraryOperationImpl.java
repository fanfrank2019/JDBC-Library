package service;

import java.sql.*;
import java.util.*;

import model.Library;
import connecter.ConnectionData;

public class LibraryOperationImpl implements LibraryOperation{
	
	private Connection con;
	PreparedStatement stat;
	
	public LibraryOperationImpl() {
		ConnectionData c = ConnectionData.getObj();
		con = c.getConObj();
	}

	@Override
	public void insert(Library l) {
		try {
			stat = con.prepareStatement("insert into LibraryInfo values (?,?,?,?);");
			stat.setInt(1, l.getBook_id());
			stat.setString(2, l.getBook_name());
			stat.setNString(3, l.getBook_author());
			stat.setString(4, l.getBook_category());
			int x = stat.executeUpdate();
			if(x > 0) {
				System.out.println("Successfully inserted");
			}else {
				System.out.println("Failed when insert");
			}
		}catch(SQLException e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
	}

	@Override
	public void delete(int id) {
		try {
			stat = con.prepareStatement("delete from LibraryInfo where book_id = ?");
			stat.setInt(1, id);
			int x = stat.executeUpdate();
			if(x > 0) {
				System.out.println("Successfully deleted");
			}else {
				System.out.println("Failed when delete");
			}
		}catch(SQLException e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
	}

	@Override
	public List<Library> lst() {
		List<Library> lst = new ArrayList<>();
		try {
			stat = con.prepareStatement("select * from LibraryInfo");
			ResultSet rs = stat.executeQuery();
			while(rs.next()) {
				Library l = new Library();
				l.setBook_id(rs.getInt(1));
				l.setBook_name(rs.getString(2));
				l.setBook_author(rs.getString(3));
				l.setBook_category(rs.getString(4));
				lst.add(l);
			}
		}catch(SQLException e) {
			System.out.println("Exception: "+e.getMessage());
		}
		return lst;	 
	}

	@Override
	public void update(Library l) {
		try {
			stat = con.prepareStatement("update LibraryInfo set book_name = ?, book_author = ?, book_category = ? where book_id = ?");
			stat.setString(1, l.getBook_name());
			stat.setString(2, l.getBook_author());
			stat.setString(3, l.getBook_category());
			stat.setInt(4, l.getBook_id());
			int x = stat.executeUpdate();
			if(x > 0) {
				System.out.println("Successfully updated");
			}else {
				System.out.println("Failed when update");
			}
		}catch(SQLException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
	}

	@Override
	public void getData(int id) {
		try {
			stat = con.prepareStatement("select * from LibraryInfo where book_id = ?");
			stat.setInt(1, id);
			ResultSet rs = stat.executeQuery();
			while(rs.next()) {
				System.out.println("Book ID: "+rs.getInt(1));
				System.out.println("Book name: "+rs.getString(2));
				System.out.println("Book author: "+rs.getString(3));
				System.out.println("Book category: "+rs.getNString(4));
			}
		}catch(SQLException e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
	}
	
	
	
}
