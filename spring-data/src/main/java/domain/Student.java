package domain;

import java.io.Serializable;


import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="student_id")
    private Long studentId;

	@Column(name = "studen_tname")
    private String studentName;   

	@Column(name = "roll_no")
    private int rollNo;   

	@Column(name = "email")
    private String email;
	

	@OneToOne
	private Address address;
    
	public Student(){
		System.out.println("in user model - default ctor");
	}
	
	public Student(Student student) {
		super();
		this.studentName = student.studentName;
		this.rollNo = student.rollNo;
		this.email = student.email;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", rollNo=" + rollNo + ", email="
				+ email + " address + address+]";
	}

}