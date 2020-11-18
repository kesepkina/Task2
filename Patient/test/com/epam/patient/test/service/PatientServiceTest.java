package com.epam.patient.test.service;

import com.epam.patient.entity.DataBase;
import com.epam.patient.entity.Diagnosis;
import com.epam.patient.entity.Patient;
import com.epam.patient.exception.ValidationException;
import com.epam.patient.service.PatientService;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

public class PatientServiceTest {
    DataBase dataBase = new DataBase();
    PatientService service = new PatientService();
    Patient patient1, patient2, patient3, patient4, patient5, patient6;

    private void insertData() {
        try {
            patient1 = new Patient("Bobrov", "Igor", "Mihaylovich", "Nezavisimosti 120, 12",
                    "+375296472390", 12112001);
            patient2 = new Patient("Petrov", "Nikita", "Alexandrovich", "Mavra 14, 23",
                    "+375442349065", 12112034, Diagnosis.SCOLIOSIS);
            patient3 = new Patient("Dunay", "Ilya", "Maximovich", "Dzerzhinskaga 109, 9",
                    "80296790912", 12111560, Diagnosis.SCOLIOSIS);
            patient4 = new Patient("Vasiliev", "Mihail", "Vitalyevich", "Voyskovaya 3, 42",
                    "+375294565756", 12111823, Diagnosis.COVID_19);
            patient5 = new Patient("Valuyeva", "Alexandra", "Vitalyevna", "Tsimiryazeva 45, 30",
                    "+375443895675", 12115678, Diagnosis.COVID_19);
            patient6 = new Patient("Pirova", "Diana", "Arkadyevna", "Rakassouskaga 12, 3",
                    "80336239812", 12111732);
            dataBase.addPatient(patient1)
                    .addPatient(patient2)
                    .addPatient(patient3)
                    .addPatient(patient4)
                    .addPatient(patient5)
                    .addPatient(patient6);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countPatientsWithoutDiagnosisTest() {
        insertData();

        int expected = 2;
        int actual = service.countPatientsWithoutDiagnosis(dataBase);

        assertSame(expected, actual);
    }

    @Test
    public void findPatientByIdTest() {
        insertData();

        Patient actual = service.findPatientById(dataBase, 2);
        assertEquals(actual, patient2);
    }

    @Test
    public void findAllByDiagnosisTest() {
        insertData();

        List<Patient> expected = new ArrayList<>();
        expected.add(patient2);
        expected.add(patient3);
        List<Patient> actual = service.findAllByDiagnosis(dataBase, Diagnosis.SCOLIOSIS);
        assertEquals(actual, expected);
    }

    @Test
    public void findAllByMedicalRecordsInInterval() {
        insertData();

        List<Patient> expected = new ArrayList<>();
        expected.add(patient1);
        expected.add(patient2);
        expected.add(patient4);
        expected.add(patient6);
        List<Patient> actual = service.findAllByMedicalRecordsInInterval(dataBase,
                12111700, 12112040);
        assertEquals(actual, expected);
    }
}
