package mymockitodemos;

public class StudentService {
	

	    private StudentRepository studentRepository;

	    // Constructor injection
	    public StudentService(StudentRepository studentRepository) {
	        this.studentRepository = studentRepository;
	    }

	    public String getStudentById(int id) {
	        Student student = studentRepository.findById(id);
	        return student != null ? student.getName() : null;
	    }
	}


