// Class for a patient
class Patient {
    private int patientId;
    private TestResult viralXTestResult;
    private TestResult genomicTestResult;
    private Symptom[] symptoms;
    private int symptomCount;
    private String status;
    // private HighRiskContact[] highRiskContacts;
    // private int highRiskContactCount;
    private boolean deceased;
    private Contact[] contacts;
    private int numContacts;
    //private boolean highRiskCon;
    private static final int MAX_NUM_CONTACT= 10;


    public void setHighRiskContacts(){
        if(this.getStatus().equals("Infected")){
            for(Contact c: contacts){
                if(c != null)
                    c.setHighRisk(true);
            }
        }
    }

    public void addContact(Contact contact){
        contacts[numContacts++] = contact;
    }

    public Contact[] getContacts(){
        return this.contacts;
    }



    public Patient(int patientId) {
        this.patientId = patientId;
        this.viralXTestResult = new TestResult("Untested");
        this.genomicTestResult = new TestResult("Untested");
        this.symptoms = new Symptom[10]; // Arbitrary size of 10
        this.status = "Under Observation";
        // this.highRiskContacts = new HighRiskContact[10]; // Arbitrary size of 10
        // this.highRiskContactCount = 0;
        this.deceased = false;
        this.symptomCount = 0;
        //this.highRiskCon = false;
        this.numContacts = 0;
        this.contacts = new Contact[MAX_NUM_CONTACT];
        
    }

    public void addSymptom(Symptom symptom) {
        this.symptoms[symptomCount++] = symptom;
    }

    // public void addHighRiskContact(HighRiskContact contact) {
    //     if (highRiskContactCount < highRiskContacts.length) {
    //         highRiskContacts[highRiskContactCount] = contact;
    //         highRiskContactCount++;
    //     } else {
    //         System.out.println("Cannot add more high-risk contacts. Array is full.");
    //     }
    // }

    // Overloaded method to add multiple high-risk contacts at once
    // public void addHighRiskContacts(HighRiskContact... contacts) {
    //     for (HighRiskContact contact : contacts) {
    //         addHighRiskContact(contact);
    //     }
    // }

    // Getters and setters for the other attributes

    public void isConfirmedCase() {
        // if (viralXTestResult != null && viralXTestResult.getResult().equals("Positive")) {
        //     return true;
        // }
        // if (genomicTestResult != null && genomicTestResult.getResult().equals("Positive")) {
        //     return true;
        // }
        // return false;

        // test logic
        genomicTestResult.conductTest(this.symptoms, 'G');
        viralXTestResult.conductTest(this.symptoms, 'V');
        //stores the test results..... 

        if(viralXTestResult != null && viralXTestResult.getResult().equals("Positive")){
            this.updateStatus("Infected");
            
            //admission to hospital
            
        }
        else if(genomicTestResult != null && viralXTestResult != null && viralXTestResult.getResult().equals("Negative") && genomicTestResult.getResult().equals("Positive")){
            //conduct viralxTest
            this.updateStatus("Infected");
            
        }
        else if(viralXTestResult != null && viralXTestResult.getResult().equals("Negative") 
                && genomicTestResult != null && genomicTestResult.getResult().equals("Negative")){
            this.updateStatus("Free");
           
        }

    }

    public String getStatus() {
        return status;
    }
    //*************************************************
    public static class TestResult {
        //private String testType;
        private String result;

        public TestResult(String result) {
            //this.testType = testType;
            this.result = result;
        }

        // Getters and setters for the attributes

        
        
        public void conductTest(Symptom[] symptoms, char testType)
        {
            System.out.println("ANDAR AA GYA");
            int totalSeverity = 0;
            boolean cold = false, cough = false, headache = false, chestpain = false;
            for(Symptom symptom : symptoms)
            {
                if(symptom == null)
                {
                    continue;
                }
                if(symptom != null && symptom.name.equals("cold"))
                {
                    cold = true;
                }
                else if(symptom != null && symptom.name.equals("cough"))
                {
                    cough = true;
                }
                else if(symptom != null && symptom.name.equals("headache"))
                {
                    headache = true;
                }
                else if(symptom != null && symptom.name.equals("chestpain"))
                {
                    chestpain = true;
                }
                totalSeverity += symptom.severity;
            }
            if(testType == 'G')
            {
                if(totalSeverity >= 8)
                {
                    this.result = "Positive";
                }
                else
                {
                    this.result = "Negative";
                }
            }
            else
            {
                if(totalSeverity >= 10)
                {
                    this.result = "Positive";
                }
                else
                {
                    this.result = "Negative";
                }
            }
        }

        public String getResult(){
            return this.result;
        }
    }
    /****************************************** */
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