package com.epam.patient.service;

import com.epam.patient.entity.DataBase;
import com.epam.patient.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientService {

    public Patient findPatientById(DataBase dataBase, int id) {
        List<Patient> allPatients = dataBase.getPatients();
        for (Patient patient : allPatients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public List<Patient> findAllByDiagnosis(DataBase dataBase, String diagnosis) {
        List<Patient> desiredPatients = new ArrayList<>();
        List<Patient> allPatients = dataBase.getPatients();
        String patientDiagnosis;
        for (Patient patient : allPatients) {
            patientDiagnosis = patient.getDiagnosis();
            if (patientDiagnosis != null && patientDiagnosis.equals(diagnosis)) {
                desiredPatients.add(patient);
            }
        }
        return desiredPatients;
    }

    public List<Patient> findAllByMedicalRecordsInInterval(DataBase dataBase,
                                                           int firstNumberOfInterval,
                                                           int lastNumberOfInterval) {
        List<Patient> desiredPatients = new ArrayList<>();
        List<Patient> allPatients = dataBase.getPatients();
        int numberOfMedicalRecord;
        for (Patient patient : allPatients) {
            numberOfMedicalRecord = patient.getNumberOfMedicalRecord();
            if (numberOfMedicalRecord > firstNumberOfInterval &&
                    numberOfMedicalRecord < lastNumberOfInterval) {
                desiredPatients.add(patient);
            }
        }
        return desiredPatients;
    }

    public int countPatientsWithoutDiagnosis(DataBase dataBase) {
        int count = 0;
        List<Patient> allPatients = dataBase.getPatients();
        for (Patient patient : allPatients) {
            if (patient.getDiagnosis() == null) {
                count++;
            }
        }
        return count;
    }


}
