abstract class Region implements Display {
    private String name;
    private Region[] subRegions;
    private int numSubRegions;
    private Patient[] patients;
    private int numPatients;

    protected Region(String name) {
        this.name = name;
        this.subRegions = new Region[10];
        this.numSubRegions = 0;
        this.patients = new Patient[100];
        this.numPatients = 0;
    }

    public void addSubRegion(Region subRegion) {
        if (this.numSubRegions < this.subRegions.length) {
            this.subRegions[this.numSubRegions] = subRegion;
            this.numSubRegions++;
        }
    }

    public void addPatient(Patient patient) {
        if (this.numPatients < this.patients.length) {
            this.patients[this.numPatients] = patient;
            this.numPatients++;
            if (patient.getStatus().equals("Infected")) {
                admitToHospital(patient);
            }
        }
    }

    protected void admitToHospital(Patient patient) {
        // Do nothing by default
    }

    public String getName() {
        return this.name;
    }

    public Region[] getSubRegions() {
        Region[] subRegionsCopy = new Region[this.numSubRegions];
        System.arraycopy(this.subRegions, 0, subRegionsCopy, 0, this.numSubRegions);
        return subRegionsCopy;
    }

    public Patient[] getPatients() {
        Patient[] patientsCopy = new Patient[this.numPatients];
        System.arraycopy(this.patients, 0, patientsCopy, 0, this.numPatients);
        return patientsCopy;
    }

    public int getTotalPatients() {
        int total = 0;
        for (int i = 0; i < this.numPatients; i++) {
            Patient patient = this.patients[i];
            if (patient.getStatus().equals("Infected") || patient.getStatus().equals("Recovered") || patient.getStatus().equals("Deceased")) {
                total++;
            }
        }
        for (int i = 0; i < this.numSubRegions; i++) {
            Region subRegion = this.subRegions[i];
            total += subRegion.getTotalPatients();
        }
        return total;
    }

    public int getTotalInfected() {
        int total = 0;
        for (int i = 0; i < this.numPatients; i++) {
            Patient patient = this.patients[i];
            if (patient.getStatus().equals("Infected")) {
                total++;
            }
        }
        for (int i = 0; i < this.numSubRegions; i++) {
            Region subRegion = this.subRegions[i];
            total += subRegion.getTotalInfected();
        }
        return total;
    }

    public int getTotalRecovered() {
        int total = 0;
        for (int i = 0; i < this.numPatients; i++) {
            Patient patient = this.patients[i];
            if (patient.getStatus().equals("Infected") && patient.getAge() < 65) {
                total++;
            }
        }
        for (int i = 0; i < this.numSubRegions; i++) {
            Region subRegion = this.subRegions[i];
            total += subRegion.getTotalRecovered();
        }
        return total;
    }

    public int getTotalDeceased() {
        int total = 0;
        for (int i = 0; i < this.numPatients; i++) {
            Patient patient = this.patients[i];
            if (patient.getStatus().equals("Infected") && patient.getAge() > 65) {
                total++;
            }
        }
        for (int i = 0; i < this.numSubRegions; i++) {
            Region subRegion = this.subRegions[i];
            total += subRegion.getTotalDeceased();
        }
        return total;
    }

    public double calculateFatalityRate() {
        int totalInfected = this.getTotalInfected();
        int totalDeceased = this.getTotalDeceased();
        if (totalInfected == 0) {
            return 0.0;
        } else {
            return (double) totalDeceased / totalInfected;
        }
    }

    @Override
    public void displayData() {
        System.out.println("Name: " + this.name);
        System.out.println("Total patients: " + this.getTotalPatients());
        System.out.println("Total infected: " + this.getTotalInfected());
        System.out.println("Total recovered: " + this.getTotalRecovered());
        System.out.println("Total deceased: " + this.getTotalDeceased());
        System.out.println("Fatality rate: " + this.calculateFatalityRate());
        for (int i = 0; i < this.numSubRegions; i++) {
            Region subRegion = this.subRegions[i];
            subRegion.displayData();
        }
    }
}
