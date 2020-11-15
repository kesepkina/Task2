package com.epam.patient.main;

import com.epam.patient.entity.DataBase;
import com.epam.patient.entity.Patient;
import com.epam.patient.exception.ValidationException;
import com.epam.patient.service.PatientService;
import com.epam.patient.show.ResultsPrinting;

public class Main {
    public static void main(String args[]) {
        DataBase dataBase = new DataBase();
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

        PatientService service = new PatientService();
        ResultsPrinting show = new ResultsPrinting();

        show.foundById(2, service.findPatientById(dataBase, 2));
        show.foundByDiagnosis("Scoliosis", service.findAllByDiagnosis(dataBase, "Scoliosis"));
        show.foundByMedicalRecordsInInterval(12111700, 12112040,
                service.findAllByMedicalRecordsInInterval(dataBase, 12111700, 12112040));
        show.numberOfPatientsWithoutDiagnosis(service.countPatientsWithoutDiagnosis(dataBase));
    }
}
