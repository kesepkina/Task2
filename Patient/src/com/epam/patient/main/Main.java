package com.epam.patient.main;

import com.epam.patient.entity.DataBase;
import com.epam.patient.entity.Diagnosis;
import com.epam.patient.entity.Patient;
import com.epam.patient.exception.ValidationException;
import com.epam.patient.service.PatientService;
import com.epam.patient.show.ResultsPrinting;

public class Main {
    public static void main(String args[]) {
        DataBase dataBase = new DataBase();
        try {
            dataBase.addPatient(new Patient("Bobrov", "Igor", "Mihaylovich", "Nezavisimosti 120, 12",
                    "+375296472390", 12112001))
                    .addPatient(new Patient("Petrov", "Nikita", "Alexandrovich", "Mavra 14, 23",
                            "+375442349065", 12112034, Diagnosis.SCOLIOSIS))
                    .addPatient(new Patient("Dunay", "Ilya", "Maximovich", "Dzerzhinskaga 109, 9",
                            "80296790912", 12111560, Diagnosis.SCOLIOSIS))
                    .addPatient(new Patient("Vasiliev", "Mihail", "Vitalyevich", "Voyskovaya 3, 42",
                            "+375294565756", 12111823, Diagnosis.COVID_19))
                    .addPatient(new Patient("Valuyeva", "Alexandra", "Vitalyevna", "Tsimiryazeva 45, 30",
                            "+375443895675", 12115678, Diagnosis.COVID_19))
                    .addPatient(new Patient("Pirova", "Diana", "Arkadyevna", "Rakassouskaga 12, 3",
                            "80336239812", 12111732));
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        PatientService service = new PatientService();
        ResultsPrinting show = new ResultsPrinting();

        show.printAllPatients(dataBase.getPatients());
        show.printFoundById(2, service.findPatientById(dataBase, 2));
        show.printFoundByDiagnosis(Diagnosis.SCOLIOSIS.toString(), service.findAllByDiagnosis(dataBase, Diagnosis.SCOLIOSIS));
        show.printFoundByMedicalRecordsInInterval(12111700, 12112040,
                service.findAllByMedicalRecordsInInterval(dataBase, 12111700, 12112040));
        show.printNumberOfPatientsWithoutDiagnosis(service.countPatientsWithoutDiagnosis(dataBase));
    }
}
