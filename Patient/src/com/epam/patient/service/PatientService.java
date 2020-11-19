package com.epam.patient.service;

import com.epam.patient.entity.Hospital;
import com.epam.patient.entity.Diagnosis;
import com.epam.patient.entity.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.EnumSet;


public class PatientService {

    public Patient findPatientById(Hospital hospital, int id) {
        List<Patient> allPatients = hospital.getPatients();
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

    public List<Patient> findAllByDiagnosis(Hospital hospital, Diagnosis diagnosis) {
        List<Patient> desiredPatients = new ArrayList<>();
        List<Patient> allPatients = hospital.getPatients();
        EnumSet<Diagnosis> patientDiagnoses;
        for (Patient patient : allPatients) {
            patientDiagnoses = patient.getDiagnoses();
            if (!patientDiagnoses.isEmpty() && patientDiagnoses.contains(diagnosis)) {
                desiredPatients.add(patient);
            }
        }
        return desiredPatients;
    }

    public List<Patient> findAllByMedicalRecordsInInterval(Hospital hospital,
                                                           int firstNumberOfInterval,
                                                           int lastNumberOfInterval) {
        List<Patient> desiredPatients = new ArrayList<>();
        List<Patient> allPatients = hospital.getPatients();
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

    public int countPatientsWithoutDiagnosis(Hospital hospital) {
        int count = 0;
        List<Patient> allPatients = hospital.getPatients();
        for (Patient patient : allPatients) {
            if (patient.getDiagnoses().isEmpty()) {
                count++;
            }
        }
        return count;
    }


}
