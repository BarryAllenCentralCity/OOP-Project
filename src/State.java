class State extends Region {
    public State(String name) {
        super(name);
    }

    @Override
    public void displayData() {
        System.out.println("State: " + getName());
        System.out.println("Total patients: " + getTotalPatients());
        System.out.println("Total infected: " + getTotalInfected());
        System.out.println("Total recovered: " + getTotalRecovered());
        System.out.println("Total deceased: " + getTotalDeceased());
        System.out.println("Fatality rate: " + calculateFatalityRate());

        // Display data for each hospital in the state
        System.out.println("Hospitals:");
        for (Region region : getSubRegions()) {
            region.displayData();
        }
    }
}