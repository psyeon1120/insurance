package Practice.InsuranceCompany.Design.src.model.contract;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contract {

	private String contractID;
	private String customerID;
	private String insuranceID;
	private String joinDate;
	private int contractPeriod;
	private int premium;
	private String activityDate;
	private String insuranceAgentID;

	public String getContractID() {
		return contractID;
	}
	public void setContractID(String contractID) {
		this.contractID = contractID;
	}
	public int getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(int contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}
	public String getInsuranceAgentID() {
		return insuranceAgentID;
	}
	public void setInsuranceAgentID(String insuranceAgentID) {
		this.insuranceAgentID = insuranceAgentID;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
	public int getPremium() {
		return premium;
	}
	public void setPremium(int premium) {
		this.premium = premium;
	}

	public Contract(){

	}

	public Contract(String contractID, String customerID, String insuranceID, int contractPeriod, int premium, String insuranceAgentID) {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date today=new Date();
		String todayS=format.format(today);
		this.contractID = contractID;
		this.customerID = customerID;
		this.insuranceID = insuranceID;
		this.contractPeriod = contractPeriod;
		this.joinDate = todayS;
		this.premium = premium;
		this.activityDate = todayS;
		this.insuranceAgentID = insuranceAgentID;
	}

	// 추가
	public String getContractInfo(){
		return "계약 고유번호: " +  contractID+" 고객 고유번호: "+customerID+" 보험 고유번호:  "+insuranceID+" 월 보험료: "+ premium +"가입 일자:  "+joinDate+" 계약 기간:  "+ contractPeriod +"계약 유지활동 수행 일자:  "+ activityDate;
	}

	// 추가
//	public boolean isMaintenanceTarget(){
//		try {
//			DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
//			Date today=new Date();
//			Date date=format.parse(joinDate);
//			return date.compareTo(today) <= 31;
//		} catch (ParseException e) {
//			throw new RuntimeException(e);
//		}
//	}
}//end Contract