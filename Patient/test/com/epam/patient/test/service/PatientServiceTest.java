package com.epam.patient.test.service;

import com.epam.patient.entity.DataBase;
import com.epam.patient.entity.Patient;
import com.epam.patient.exception.ValidationException;
import com.epam.patient.service.PatientService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertSame;

public class PatientServiceTest {
    DataBase dataBase = new DataBase();
    PatientService service = new PatientService();

    @Test
    public void countPatientsWithoutDiagnosisTest(){
        try {
            dataBase.addPatient(new Patient(1, "Bobrov", "Igor", "Mihaylovich", "Nezavisimosti 120, 12",
                    "+375296472390", 12112001))
                    .addPatient(new Patient(2, "Petrov", "Nikita", "Alexandrovich", "Mavra 14, 23",
                            "+375442349065", 12112034, "Scoliosis"))
                    .addPatient(new Patient(3, "Dunay", "Ilya", "Maximovich", "Dzerzhinskaga 109, 9",
                            "80296790912", 12111560, "Scoliosis"))
                    .addPatient(new Patient(4, "Vasiliev", "Mihail", "Vitalyevich", "Voyskovaya 3, 42",
                            "+375294565756", 12111823, "COViD 19"))
                    .addPatient(new Patient(5, "Valuyeva", "Alexandra", "Vitalyevna", "Tsimiryazeva 45, 30",
                            "+375443895675", 12115678, "COViD 19"))
                    .addPatient(new Patient(6, "Pirova", "Diana", "Arkadyevna", "Rakassouskaga 12, 3",
                            "80336239812", 12111732));
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        int expected = 2;
        int actual = service.countPatientsWithoutDiagnosis(dataBase);

        assertSame(expected, actual);
    }
}
