package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentManagement {
    private final ArrayList<Student> students;


    public StudentManagement() {
        students = new ArrayList<>();
    }
    public boolean isValidId(int id) {
        return id > 0; // Kiểm tra ID phải lớn hơn 0
    }
    // Log errors
    public void logError(String errorMessage) {
        System.err.println("LOG: " + errorMessage);
    }





    // Thêm sinh viên
// Add a new student with unique ID
    public void addStudent(Student student) {
        if (!isValidId(student.getId())) {
            return;
        }
        if (!isValidScore(student.getScore())) {
            System.out.println("Error: Invalid score. Score must be between 0 and 10.");
            return;
        }
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("Error: Student with ID " + student.getId() + " already exists.");
                return;
            }
        }
        students.add(student);
        System.out.println("Successfully added student: " + student);
    }



    // Sửa thông tin  viên theo ID
    public void updateStudent(int id, double newScore) {
        try {
            if (!isValidScore(newScore)) {
                return;
            }
            Student student = searchStudentById(id);
            if (student == null) {
                throw new Exception("Student with ID " + id + " not found.");
            }
            student.setScore(newScore);
            System.out.println("Successfully updated student: " + student);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private boolean isValidScore(double newScore) {
        if (newScore <= 0) {
            System.out.println("Error: Score must be greater than 0.");
            return false;
        }
        if (newScore > 10) {
            System.out.println("Error: Score must not exceed 10.");
            return false;
        }
        return true;
    }

    // Xóa sinh viên theo ID
    public void deleteStudent(int id) {
        boolean removed = students.removeIf(student -> student.getId() == id);
        if (removed) {
            System.out.println("Đã xóa sinh viên có ID: " + id);
        } else {
            System.out.println("Không tìm thấy sinh viên với ID: " + id);
        }
    }

    // Tìm kiếm sinh viên theo ID
    public Student searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        System.out.println("Error: Student with ID " + id + " not found.");
        return null;
    }

    // Sắp xếp sinh viên theo điểm
    public void sortStudentsByScore() {
        Collections.sort(students, Comparator.comparingDouble(Student::getScore));
        System.out.println("Đã sắp xếp sinh viên theo điểm.");
    }

    // Hiển thị tất cả sinh viên
    public void displayStudents() { // Đổi tên phương thức cho phù hợp
        if (students.isEmpty()) {
            System.out.println("Không có sinh viên.");
        } else {
            System.out.println("Danh sách sinh viên:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Xếp hạng sinh viên theo điểm
    public String getRanking(double score) {
        if (score < 5.0) return "Thất bại";
        else if (score < 6.5) return "Trung bình";
        else if (score < 7.5) return "Tốt";
        else if (score < 9.0) return "Rất tốt";
        else return "Xuất sắc";
    }

    // Hiển thị xếp hạng của sinh viên theo điểm
    public void displayRankings() {
        for (Student student : students) {
            System.out.println("Sinh viên: " + student.getName() + " - Xếp hạng: " + getRanking(student.getScore()));
        }
    }

}
