package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();

        studentManagement.addStudent(new Student(1, "PHAN BẢO TRUNG", "0123456789", 5));
        studentManagement.addStudent(new Student(2, "HÒ SĨ QUỐC", "0123456788", 6));
        studentManagement.addStudent(new Student(3, "PHAN NHẬT LINH", "0123456787", 4));
        studentManagement.addStudent(new Student(4, "TRẦN GIA BẢO", "0123456786", 7));
        studentManagement.addStudent(new Student(5, "TRẦN HÀ LINH", "0123456785", 10));

        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị sinh viên");
            System.out.println("3. Sắp xếp sinh viên theo điểm");
            System.out.println("4. Cập nhật điểm sinh viên");
            System.out.println("5. Xóa sinh viên");
            System.out.println("6. Xếp hạng sinh viên");
            System.out.println("7. Tìm kiếm sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            switch (choice) {
                case 1:
                    // Nhập thông tin sinh viên
                    System.out.print("Nhập ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ dòng thừa
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String contactNumber = scanner.nextLine();
                    System.out.print("Nhập điểm: ");
                    double score = scanner.nextDouble();

                    Student student = new Student(id, name, contactNumber, score);
                    studentManagement.addStudent(student);
                    break;

                case 2:
                    // Hiển thị danh sách sinh viên
                    studentManagement.displayStudents();
                    break;

                case 3:
                    // Sắp xếp sinh viên theo điểm
                    studentManagement.sortStudentsByScore();
                    break;

                case 4:
                    // Cập nhật điểm sinh viên
                    System.out.print("Nhập ID sinh viên cần cập nhật điểm: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Nhập điểm mới: ");
                    double newScore = scanner.nextDouble();
                    studentManagement.updateStudent(updateId, newScore);
                    break;

                case 5:
                    // Xóa sinh viên theo ID
                    System.out.print("Nhập ID sinh viên cần xóa: ");
                    int deleteId = scanner.nextInt();
                    studentManagement.deleteStudent(deleteId);
                    break;

                case 6:
                    // Xếp hạng sinh viên
                    studentManagement.displayRankings(); // Hiển thị xếp hạng cho tất cả sinh viên
                    break;

                case 7:
                    // Tìm kiếm sinh viên theo ID
                    System.out.print("Nhập ID sinh viên cần tìm: ");
                    int searchId = scanner.nextInt();
                    Student foundStudent = studentManagement.searchStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Tìm thấy sinh viên: " + foundStudent);
                    } else {
                        System.out.println("Không tìm thấy sinh viên với ID: " + searchId);
                    }
                    break;

                case 0:
                    // Thoát chương trình
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
