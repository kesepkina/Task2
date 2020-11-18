package com.epam.patient.service;

import com.epam.patient.entity.DataBase;
import com.epam.patient.entity.Diagnosis;
import com.epam.patient.entity.Patient;

import java.util.*;

public class PatientService {

    public Patient findPatientById(DataBase dataBase, int id) {
        List<Patient> allPatients = dataBase.getPatients();
        Patient patient = null;
        int i = 0;
        while (i < allPatients.size()) {
            if (allPatients.get(i).getId() == id) {
                patient = allPatients.get(i);
                break;
            }
            i++;
        }
        return Optional.ofNullable(patient).orElseThrow(NoSuchElementException::new);
    }

    public List<Patient> findAllByDiagnosis(DataBase dataBase, Diagnosis diagnosis) {
        List<Patient> desiredPatients = new ArrayList<>();
        List<Patient> allPatients = dataBase.getPatients();
        EnumSet<Diagnosis> patientDiagnoses;
        for (Patient patient : allPatients) {
            patientDiagnoses = patient.getDiagnoses();
            if (!patientDiagnoses.isEmpty() && patientDiagnoses.contains(diagnosis)) {
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
            if (patient.getDiagnoses().isEmpty()) {
                count++;
            }
        }
        return count;
    }


}
