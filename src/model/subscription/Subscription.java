package Practice.InsuranceCompany.Design.src.model.subscription;


import Practice.InsuranceCompany.Design.src.model.customer.Customer;
import Practice.InsuranceCompany.Design.src.enums.UnderwritingStatus;
import Practice.InsuranceCompany.Design.src.model.insurance.Insurance;
import Practice.InsuranceCompany.Design.src.enums.InsuranceType;
import Practice.InsuranceCompany.Design.src.model.customer.DiseaseHistory;
import Practice.InsuranceCompany.Design.src.model.customer.OwnedBuildingInfo;
import Practice.InsuranceCompany.Design.src.model.customer.OwnedCarInfo;

public class Subscription {

	private String customerID;
	private String dateCreated;
	private String insuranceAgentID;
	private String insuranceID;
	private int insurancePeriod;
	private int premium;
	private String subscriptionID;
	private UnderwritingStatus underwritingStatus;

	public Subscription(){

	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getInsuranceAgentID() {
		return insuranceAgentID;
	}

	public void setInsuranceAgentID(String insuranceAgentID) {
		this.insuranceAgentID = insuranceAgentID;
	}

	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}

	public int getInsurancePeriod() {
		return insurancePeriod;
	}

	public void setInsurancePeriod(int insurancePeriod) {
		this.insurancePeriod = insurancePeriod;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public String getSubscriptionID() {
		return subscriptionID;
	}

	public void setSubscriptionID(String subscriptionID) {
		this.subscriptionID = subscriptionID;
	}

	public UnderwritingStatus getUnderwritingStatus() {
		return underwritingStatus;
	}

	public void setUnderwritingStatus(UnderwritingStatus underwritingStatus) {
		this.underwritingStatus = underwritingStatus;
	}

	public String getInsuranceID() {
		return insuranceID;
	}

	public void updateUnderwritingStatus(UnderwritingStatus underwritingStatus){
		this.underwritingStatus = underwritingStatus;
	}

	public void printInfo() {
		System.out.println("????????? ???????????? : " + this.dateCreated);
		System.out.println("?????? ??????????????? ID : " + this.insuranceAgentID);
		System.out.println("?????? ????????? ?????? ID : " + this.insuranceID);
		System.out.println("?????? ????????? ?????? ID : " + this.customerID);
		System.out.println("???????????? ?????? ?????? : " + this.underwritingStatus.getDetail());
	}

	/*** methods for Signup UW ***/
	private boolean checkAvailabilityOfUW(Customer customer, Insurance insurance) {
		// ????????? ????????? ??????
		if(insurance.getInsuranceType() == InsuranceType.car){
			OwnedCarInfo ownedCarInfo = customer.getOwnedCarInfo();
			return this.checkAvailabilityOfCarInsurance(insurance, ownedCarInfo);
		}
		// ?????? ????????? ??????
		else if(insurance.getInsuranceType() == InsuranceType.fire){
			OwnedBuildingInfo ownedBuildingInfo = customer.getOwnedBuildingInfo();
			return this.checkAvailabilityOfFireInsurance(insurance, ownedBuildingInfo);
		}
		// ?????? ????????? ??????
		else if(insurance.getInsuranceType() == InsuranceType.personalHealth){
			DiseaseHistory diseaseHistory = customer.getDiseaseHistory();
			return this.checkAvailabilityOfHealthInsurance(insurance, diseaseHistory);
		}
		else{
			System.out.println("????????? ?????? ????????? ???????????? ????????????.");
			return false;
		}
	}


	private boolean checkAvailabilityOfHealthInsurance(Insurance insurance, DiseaseHistory diseaseHistory) {
		// ?????????, ????????????
		DiseaseHistory availableDiseaseHistory = insurance.getAcquisitionPolicy().getDiseaseInfoPolicy();
		if(diseaseHistory.getSeverity().getLevelNum() <= availableDiseaseHistory.getSeverity().getLevelNum()
			&& diseaseHistory.getStrugglePeriod() <= availableDiseaseHistory.getStrugglePeriod()){
			System.out.println("?????? ????????? ????????? ???????????????.");
			return true;
		} else {
			System.out.println("?????? ????????? ???????????? ???????????????.");
			return false;
		}

	}

	private boolean checkAvailabilityOfFireInsurance(Insurance insurance, OwnedBuildingInfo ownedBuildingInfo) {
		// ?????? ??? ???, ???????????? ??????
		OwnedBuildingInfo availableBuildingInfo = insurance.getAcquisitionPolicy().getBuildingInfoPolicy();
		if(availableBuildingInfo.getFloorNumber() >= ownedBuildingInfo.getFloorNumber()
				&& availableBuildingInfo.getSpecializedBuilding() == ownedBuildingInfo.getSpecializedBuilding()){
			System.out.println("?????? ????????? ????????? ???????????????.");
			return true;
		} else {
			System.out.println("?????? ????????? ???????????? ???????????????.");
			return false;
		}
	}

	private boolean checkAvailabilityOfCarInsurance(Insurance insurance, OwnedCarInfo ownedCarInfo) {
		// ?????? ??????, ?????? ?????? ??????
		OwnedCarInfo availableCarInfo = insurance.getAcquisitionPolicy().getCarInfoPolicy();
		if(availableCarInfo.getAccidentNumber() >= ownedCarInfo.getAccidentNumber()
			&& availableCarInfo.getAvailableNumOfViolation() >= ownedCarInfo.getViolationHistory().size()){
			System.out.println("?????? ????????? ????????? ???????????????.");
			return true;
		} else{
			System.out.println("?????? ????????? ???????????? ???????????????.");
			return false;
		}
	}

}//end Subscription