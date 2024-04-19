import Location.Country;
import Location.Hospital;
import Location.State;
import Subject.Patient;
import utility.all_data;

public class Main {
    public static void main(String[] args) {
        all_data data = new all_data();
        Country country = data.getCountry();
        data.readInputFromFile("src/inputFiles/input.txt");
        data.readInputFromFile("src/inputFiles/hospital.txt", country);
        Patient[] patients = data.getPatients();
        Hospital[] hospitals = data.getHospitals();
        State[] states = data.getStates();

        System.out.println("Names of Patients:");
        for (Patient patient : patients) {
            if (patient != null) {
                System.out.println(patient.getName());
            }
        }

        System.out.println("\n\nNames of Hospitals:");
        for (Hospital hospital : hospitals) {
            if (hospital != null) {
                System.out.println(hospital.getName());
            }
        }

        System.out.println("\n\nNames of States:");
        for (State state : states) {
            if (state != null) {
                System.out.println(state.getName());
            }
        }
        int i = 0;
        int j = 0;
        // main logic to put patient in hospital
        while(i < hospitals.length)
        {
            //System.out.println("LAST KAAM BAAKI");
            while(j<patients.length)
            {
            if(patients[j] == null)
            {
                break;
            }
            patients[j].isConfirmedCase();
            if(patients[j].getStatus().equals("Infected") && !patients[j].getAdmitStatus())
            {
                if(hospitals[i].addPatient(patients[j])){
                System.out.println("ADMIT KIYA???");
                //hospitals[i].addPatient(patients[j]);
                patients[j].setAdmitStatus(true);
                j++;
                }
                else{
                break;
                }
            }
            }
            i++;
        }
        country.displayData();

        // Method to read input from file and create patients and contacts
    }
    
}
