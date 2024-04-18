class State extends Region {
    private Hospital[] hospitals;
    private int hospitalCount;
    private int patientCount;
    private static final int MAXHOSPITALS =20;

    public State(String name) {
        super(name);
        this.hospitals = new Hospital[State.MAXHOSPITALS]; 
        this.hospitalCount = 0;
        this.patientCount = 0;
    }

    public void addHospital(Hospital hospital) {
        if (hospitalCount < hospitals.length) {
            hospitals[hospitalCount] = hospital;
            hospitalCount++;
        } 
    }

    
    public void addHospitals(Hospital... hospitals) {
        for (Hospital hospital : hospitals) {
            addHospital(hospital);
        }
    }

   
    
    public double calculateFatalityRate() {
        int deceased = 0, infected = 0;
        for(Hospital h : hospitals){
            deceased += h.getDeceased();
            infected += h.getInfected();
            Patient[] pat = h.getPatients();
            this.patientCount += pat.length;
        }


        return (double)deceased/infected;
    }

    // Implementation of the Displayable interface
    @Override
    public void displayData() {
        //System.out.println("State: " + name);
        System.out.println("Number of hospitals: " + hospitalCount);
        System.out.println("Number of patients: " + patientCount);

        System.out.println("Fatality rate: " + calculateFatalityRate());
}

}