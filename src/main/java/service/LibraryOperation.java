package service;

import java.util.List;

import model.Library;

public interface LibraryOperation {
	public void insert(Library l);
	public void delete(int id);
	public List<Library> lst();
	public void update(Library l);
	public void getData(int id);
}
