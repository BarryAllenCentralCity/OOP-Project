public class Contact extends Person {
    private Patient patient;
    private boolean highRisk;

    public Contact(int id, String name,int age, Patient patient) {
        super(id, name ,age);
        this.patient = patient;
        this.highRisk = false;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public boolean isHighRisk() {
        return highRisk;
    }

    public void setHighRisk(boolean highRisk) {
        this.highRisk = highRisk;
    }

    



}
