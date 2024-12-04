package org.example;

class StudentStack {
    private Node top; // Đỉnh của ngăn xếp
    private int size; // Kích thước ngăn xếp

    public StudentStack() {
        top = null; // Ngăn xếp ban đầu trống
        size = 0;   // Kích thước ban đầu là 0
    }

    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Đã thêm sinh viên: " + student);
    }

    public Student pop() {
        if (isEmpty()) {
            System.out.println("Ngăn xếp trống! Không có sinh viên nào để xóa.");
            return null;
        }
        Student poppedStudent = top.student;
        top = top.next;
        size--;
        return poppedStudent;
    }

    public Student peek() {
        if (isEmpty()) {
            System.out.println("Ngăn xếp trống!");
            return null;
        }
        return top.student;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void displayStudents() {
        if (isEmpty()) {
            System.out.println("Không có sinh viên trong ngăn xếp.");
            return;
        }

        System.out.println("Danh sách sinh viên trong ngăn xếp:");
        Node current = top;
        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }
}

class Node {
    Student student;
    Node next;

    public Node(Student student) {
        this.student = student;
    }
}
