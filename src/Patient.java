// Class for a patient
class Patient {
    private int patientId;
    private TestResult viralXTestResult;
    private TestResult genomicTestResult;
    private String[] symptoms;
    private String status;
    private HighRiskContact[] highRiskContacts;
    private int highRiskContactCount;
    private boolean deceased;

    public Patient(int patientId) {
        this.patientId = patientId;
        this.viralXTestResult = null;
        this.genomicTestResult = null;
        this.symptoms = new String[10]; // Arbitrary size of 10
        this.status = "Under Observation";
        this.highRiskContacts = new HighRiskContact[10]; // Arbitrary size of 10
        this.highRiskContactCount = 0;
        this.deceased = false;
        
    }

    public void addSymptom(String symptom) {
        
    }

    public void addHighRiskContact(HighRiskContact contact) {
        if (highRiskContactCount < highRiskContacts.length) {
            highRiskContacts[highRiskContactCount] = contact;
            highRiskContactCount++;
        } else {
            System.out.println("Cannot add more high-risk contacts. Array is full.");
        }
    }

    // Overloaded method to add multiple high-risk contacts at once
    public void addHighRiskContacts(HighRiskContact... contacts) {
        for (HighRiskContact contact : contacts) {
            addHighRiskContact(contact);
        }
    }

    // Getters and setters for the other attributes

    public void isConfirmedCase() {
        // if (viralXTestResult != null && viralXTestResult.getResult().equals("Positive")) {
        //     return true;
        // }
        // if (genomicTestResult != null && genomicTestResult.getResult().equals("Positive")) {
        //     return true;
        // }
        // return false;

        if(viralXTestResult != null && viralXTestResult.getResult().equals("Positive")){
            this.updateStatus("Infected");
            //admission to hospital
            
        }
        else if(genomicTestResult != null && genomicTestResult.getResult().equals("Positive")){
            //conduct viralxTest
        }
        else if(viralXTestResult != null && viralXTestResult.getResult().equals("Positive") 
                && genomicTestResult != null && genomicTestResult.getResult().equals("Negative")){
            this.updateStatus("Free");
        }

    }

    public String getStatus() {
        return status;
    }

    public static class TestResult {
        //private String testType;
        private String result;

        public TestResult( String result) {
            //this.testType = testType;
            this.result = result;
        }

        // Getters and setters for the attributes

        public String getResult(){
            return this.result;
        }
    }

    // Nested class for a high-risk contact
    public static class HighRiskContact {
        private int contactId;
        
        public HighRiskContact(int contactId) {
            this.contactId = contactId;
            //this.contactName = contactName;
        }

        // Getters and setters for the attributes

        public int getContactId(){
            return this.contactId;
        }
    }

    public void updateStatus(String status){
        this.status = status;
    }


    public void updateDeceased(boolean deceased){
        this.deceased = deceased;

    }

    public boolean getDeceased(){
        return this.deceased;
    }
}
