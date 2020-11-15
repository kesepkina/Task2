package com.epam.patient.show;

import com.epam.patient.entity.Patient;

import java.util.List;

public class ResultsPrinting {

    public void foundById(int id, Patient patient) {
        System.out.println("Info about patient with id = " + id + ":\n" + patient.toString() + "\n");
    }

    public void foundByDiagnosis(String diagnosis, List<Patient> patients) {
        System.out.println("All patients with diagnosis \"" + diagnosis + "\":");
        for (Patient patient : patients) {
            System.out.println(patient.toString());
        }
        System.out.println();
    }

    public void foundByMedicalRecordsInInterval(int firstNumberOfInterval,
                                                int lastNumberOfInterval, List<Patient> patients) {
        System.out.println("All patients with medical record's number between " + firstNumberOfInterval
                + " and " + lastNumberOfInterval + ":");
        for (Patient patient : patients) {
            System.out.println(patient.toString());
        }
        System.out.println();
    }

    public void numberOfPatientsWithoutDiagnosis (int counted){
        System.out.println("There are " + counted + " patients without diagnosis.");
    }
}
