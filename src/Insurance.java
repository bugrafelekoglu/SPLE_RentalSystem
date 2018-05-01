public class Insurance {

    private String policy;
    private int insurancePrice;

    public Insurance(String policy, int insurancePrice){
        this.policy = policy;
        this.insurancePrice = insurancePrice;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public int getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(int insurancePrice) {
        this.insurancePrice = insurancePrice;
    }


}
