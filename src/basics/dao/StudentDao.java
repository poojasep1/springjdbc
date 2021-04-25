package basics.dao;

import basics.model.Student;

public interface StudentDao {
	public void insert(Student student);
	 void delRecordById(int _id) ;

}
