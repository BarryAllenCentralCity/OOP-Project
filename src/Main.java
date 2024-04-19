public class Main {
    public static void main(String[] args) {
        Country country = new Country("India");

        State state1 = new State("Maharashtra");
        State state2 = new State("Karnataka");

        country.addSubRegion(state1);

        country.addSubRegion(state2);

        Hospital hospital1 = new Hospital("Apollo Hospital");


        Hospital hospital2 = new Hospital("Fortis Hospital");

        state1.addSubRegion(hospital1);
        state2.addSubRegion(hospital2);

        Patient patient1 = new Patient(1 , "Adit" , 23);
        patient1.addSymptom(new Symptom("cough", 3));
        patient1.addSymptom(new Symptom("fever", 2));
        //patient1.updateDeceased(true);
        patient1.isConfirmedCase();
        

        Patient patient2 = new Patient(2 , "Nihak" , 69);
        patient2.addSymptom(new Symptom("sore throat", 8));
        patient2.isConfirmedCase();

        Patient patient3 = new Patient(3 , "Hars" , 64);
        patient3.addSymptom(new Symptom("headache", 10));
        patient3.addSymptom(new Symptom("body ache", 2));
        patient3.isConfirmedCase();

        if (patient1.getStatus().equals("Infected")) {
            hospital1.addPatient(patient1);
        }

        if (patient2.getStatus().equals("Infected")) {
            hospital1.addPatient(patient2);
        }

        if (patient3.getStatus().equals("Infected")) {
            hospital1.addPatient(patient3);
        }

        country.displayData();
    }
}
