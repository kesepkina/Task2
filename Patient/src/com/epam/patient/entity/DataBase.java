package com.epam.patient.entity;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Patient> patients;

    public DataBase() {
        this.patients = new ArrayList<>();
    }

    public DataBase(List<Patient> patients) {
        this.patients = patients;
    }

    public DataBase addPatient(Patient newPatient){
        patients.add(newPatient);
        return this;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
