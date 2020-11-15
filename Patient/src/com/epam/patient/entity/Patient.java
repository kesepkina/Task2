package com.epam.patient.entity;

import com.epam.patient.exception.ValidationException;

import java.util.Objects;

public class Patient {
    private final int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private String phoneNumber;
    private int numberOfMedicalRecord;
    private String diagnosis;

    public Patient(int id, String lastName, String firstName, String patronymic, String address,
                   String phoneNumber, int numberOfMedicalRecord, String diagnosis) throws ValidationException {
        if (!checkPhoneNumber(phoneNumber)) {
            throw new ValidationException("wrong phoneNumber");
        }
        if (!checkNumberOfMedicalRecord(numberOfMedicalRecord)){
            throw new ValidationException("wrong number of medical record");
        }
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.numberOfMedicalRecord = numberOfMedicalRecord;
        this.diagnosis = diagnosis;
    }

    public Patient(int id, String lastName, String firstName, String patronymic, String address,
                   String phoneNumber, int numberOfMedicalRecord) throws ValidationException {
        if (!checkPhoneNumber(phoneNumber)) {
            throw new ValidationException("wrong phoneNumber");
        }
        if (!checkNumberOfMedicalRecord(numberOfMedicalRecord)){
            throw new ValidationException("wrong number of medical record");
        }
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.numberOfMedicalRecord = numberOfMedicalRecord;
        this.diagnosis = null;
    }

    private boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\+?\\d+");
    }

    private boolean checkNumberOfMedicalRecord(int numberOfMedicalRecord) {
        return String.valueOf(numberOfMedicalRecord).matches("\\d{8}");
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumberOfMedicalRecord() {
        return numberOfMedicalRecord;
    }

    public void setNumberOfMedicalRecord(int numberOfMedicalRecord) {
        this.numberOfMedicalRecord = numberOfMedicalRecord;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                numberOfMedicalRecord == patient.numberOfMedicalRecord &&
                Objects.equals(lastName, patient.lastName) &&
                Objects.equals(firstName, patient.firstName) &&
                Objects.equals(patronymic, patient.patronymic) &&
                Objects.equals(address, patient.address) &&
                Objects.equals(phoneNumber, patient.phoneNumber) &&
                Objects.equals(diagnosis, patient.diagnosis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, patronymic, address, phoneNumber, numberOfMedicalRecord, diagnosis);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Patient{");
        sb.append("id=").append(id);
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", patronymic='").append(patronymic).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", numberOfMedicalRecord=").append(numberOfMedicalRecord);
        sb.append(", diagnosis='").append(diagnosis).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
