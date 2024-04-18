import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        // Create a new hospital object
        Hospital hospital = new Hospital("Mercy General Hospital", "INdia");

        // Add patients to the hospital
        Patient p1 = new Patient(12345);
        p1.updateDeceased(true);
        hospital.addPatient( p1);
        Patient p2 = new Patient(1235);
        p2.updateStatus("Infected");
        Patient p3 = new Patient(345);
        p3.updateStatus("Infected");
        //Patient p1 = new Patient(12345);
        hospital.addPatient(p2);
        hospital.addPatient(p3);

        // Perform the testing process for the first patient using test results from a file
        // try {
        //     hospital.getPatients(0).performTestsFromFile(12345, "test_results.txt");
        // } catch (FileNotFoundException e) {
        //     System.out.println("Error: File not found.");
        // }

        // Print the number of confirmed cases in the hospital
        // System.out.println("Number of Confirmed Cases: " + hospital.getConfirmedCases());

        // // Print the number of cured patients in the hospital
        // System.out.println("Number of Cured Patients: " + hospital.getCuredPatients());

        // // Print the number of deceased patients in the hospital
        // System.out.println("Number of Deceased Patients: " + hospital.getDeceasedPatients());

        // Print the fatality rate of the hospital
        double ans = hospital.calculateFatalityRate();
        System.out.println("Fatality Rate: " + ans);
    }
}
