package com.railyatri.model;

public class Passenger {
    private String name;
    private int age;
    private String gender;
    private String idProofType;
    private String idProofNumber;
    private String classType;
    private String quota;
    private String status;
    private String seatNumber;

    public Passenger() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getIdProofType() { return idProofType; }
    public void setIdProofType(String idProofType) { this.idProofType = idProofType; }
    public String getIdProofNumber() { return idProofNumber; }
    public void setIdProofNumber(String idProofNumber) { this.idProofNumber = idProofNumber; }
    public String getClassType() { return classType; }
    public void setClassType(String classType) { this.classType = classType; }
    public String getQuota() { return quota; }
    public void setQuota(String quota) { this.quota = quota; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
}
