class Country extends Region {
    public Country(String name) {
        super(name);
    }

    @Override
    public void displayData() {
        System.out.println("Country: " + getName());
        System.out.println("Total patients: " + getTotalPatients());
        System.out.println("Total infected: " + getTotalInfected());
        //System.out.println("Total recovered: " + getTotalRecovered());
        System.out.println("Total deceased: " + getTotalDeceased());
        System.out.println("Fatality rate: " + calculateFatalityRate());

       //disaplay for each state
        System.out.println("States:");
        for (Region region : getSubRegions()) {
            region.displayData();
        }
    }
}