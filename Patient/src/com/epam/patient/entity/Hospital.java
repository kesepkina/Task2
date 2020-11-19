package com.epam.patient.entity;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<Patient> patients;

    public Hospital() {
        this.patients = new ArrayList<>();
    }

    public Hospital(List<Patient> patients) {
        this.patients = new ArrayList<>();
        this.patients.addAll(patients);
    }

    public Hospital addPatient(Patient newPatient){
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
