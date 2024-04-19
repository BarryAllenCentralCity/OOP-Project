public class Main {
    public static void main(String[] args) {
        // Create patients
        Patient patient1 = new Patient(1);
        Patient patient2 = new Patient(2);
        
        // Create contacts
        Contact contact1 = new Contact(1, "John", patient1);
        Contact contact2 = new Contact(2, "Alice", patient1);
        
        // Add contacts to patients
        patient1.addContact(contact1);
        patient1.addContact(contact2);
        
        patient1.addSymptom(new Symptom("cough", 3)); // Patient 1 has a cough with severity 3
        patient1.addSymptom(new Symptom("fever", 2)); // Patient 1 has a fever with severity 2
        
        // Add symptoms to patient 2
        patient2.addSymptom(new Symptom("cold", 8)); 

        patient1.isConfirmedCase();
        
        // Get contacts for patient 1
        patient1.setHighRiskContacts();
        
        Contact[] patient1Contacts = patient1.getContacts();
        
        // Print patient 1's contacts
        System.out.println("Patient 1's Contacts:");
        for (Contact contact : patient1Contacts) {
            if (contact != null) {
                boolean high = contact.isHighRisk();
                System.out.println("Contact ID: " + contact.getId() + ", Name: " + contact.getName() +", High Risk" + high);
            }
        }
        
        // Add contacts to patient 2
        patient2.addContact(new Contact(3, "Bob", patient2));
        patient2.addContact(new Contact(4, "Eve", patient2));
        patient2.isConfirmedCase();
        patient2.setHighRiskContacts();
        // Get contacts for patient 2
        Contact[] patient2Contacts = patient2.getContacts();
        
        // Print patient 2's contacts
        System.out.println("\nPatient 2's Contacts:");
        for (Contact contact : patient2Contacts) {
            if (contact != null) {
                boolean high = contact.isHighRisk();
                System.out.println("Contact ID: " + contact.getId() + ", Name: " + contact.getName() +", High Risk" + high);
            }
        }
    }
}
