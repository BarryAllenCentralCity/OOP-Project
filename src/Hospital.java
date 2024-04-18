class Hospital extends Region{
    private Patient[] patients;
    private int numPatients;
    private static final int MAX_NUM =100;
    private String name;
    private String location;

    public Hospital(String name, String location) {
        super(name);
        this.location = location;
        this.patients = new Patient[MAX_NUM];
    }

    
    public Hospital(String name, String location, Patient... patients) {
        super(name);
        this.location = location;
        addPatients(patients);
    }


    public String getName(){
        return this.name;
    }

    public String getlocation(){
        return this.location;
    }

    public Patient[] getPatients(){
        return this.patients;
    } 

    public void addPatient(Patient p){
        
        patients[numPatients] = p;
        numPatients++;
    }

    public double calculateFatalityRate(){
        double ans;
        double deceased = 0 , confirmedCases = 0;

        for(Patient pat: patients){
            if(pat!= null && pat.getDeceased() == true){
                deceased++; confirmedCases++;
            }
            if(pat!= null && pat.getDeceased() == false && pat.getStatus().equals("Infected")){
                confirmedCases++;
            }
        }

        ans = deceased/confirmedCases;
        return ans;
        
    }

    public void displayData(){

    }
}