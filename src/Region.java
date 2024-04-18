abstract class Region implements Display{
    private String name;
    static final int maxPatients = 100;
    private Patient[] patients;
    private int patientCount;
    private int deceased;
    private int infected;

    Region(String name){
        this.name = name;
        this.patients = new Patient[Region.maxPatients];
        this.patientCount = 0;
        this.deceased = 0;
        this.infected = 0;

    }


    public void addPatient(Patient patient){
        //boolean t = true;
        if(this.patientCount < Region.maxPatients ){
            patients[patientCount] = patient;
            patientCount++;
            //return t;
        }

        //return false;
    }

    public void addPatients(Patient ...pat){
        for(Patient p : pat){
            addPatient(p);
        }
    }

    public abstract double calculateFatalityRate();
    
    public int getDeceased(){
        for(Patient p : patients){
            if(p.getDeceased() == true){
                this.deceased++;
            }
        }

        return this.deceased;
    }
    public int getInfected(){
        for(Patient p : patients){
            if(p.getStatus().equals("Infected")){
                this.infected++;
            }
        }
        return this.infected;
    }

}