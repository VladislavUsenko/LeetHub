class ParkingSystem {
    
    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        switch(carType) {
            case 1:
                --big;
                return big >= 0;
            case 2:
                --medium;
                return medium >= 0;
            case 3:
                --small;
                return small >= 0;
            default: return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */