package org.example;

class Student {
    private int id;
    private String name;
    private String contactNumber;
    private double score;  // Thêm thuộc tính điểm

    public Student(int id, String name, String contactNumber, double score) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", score=" + score +
                '}';
    }
}
