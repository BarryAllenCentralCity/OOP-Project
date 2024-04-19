class Hospital extends Region {
    private Patient[] hospitalPatients;
    private int numHospitalPatients;

    public Hospital(String name) {
        super(name);
        this.hospitalPatients = new Patient[100];
        this.numHospitalPatients = 0;
    }

    @Override
    protected void admitToHospital(Patient patient) {
        if (this.numHospitalPatients < this.hospitalPatients.length) {
            this.hospitalPatients[this.numHospitalPatients] = patient;
            this.numHospitalPatients++;
        }
    }

    public Patient[] getHospitalPatients() {
        Patient[] hospitalPatientsCopy = new Patient[this.numHospitalPatients];
        System.arraycopy(this.hospitalPatients, 0, hospitalPatientsCopy, 0, this.numHospitalPatients);
        return hospitalPatientsCopy;
    }
}
