package Practice.InsuranceCompany.Design.src.model.accident;


import Practice.InsuranceCompany.Design.src.etcEnum.Level;

import java.util.ArrayList;
import java.util.Optional;

public abstract class AccidentListImpl implements AccidentList {

	public ArrayList<Accident> accidentList;

	public AccidentListImpl(){
		this.accidentList = new ArrayList<>();
	}

	@Override
	public boolean add(Accident accident){
		this.accidentList.add(accident);
		return true;
	}

	@Override
	public boolean delete(String accidentID){
		for(Accident accident : this.accidentList) {
			if (accident.getAccidentID().equals(accidentID))
				return this.accidentList.remove(accident);
		}
		return false;
	}

	@Override
	public Accident getByAccidentId(String accidentID){
		for(Accident accident : this.accidentList) {
			if (accident.getAccidentID().equals(accidentID))
				return accident;
		}
		return null;
	}
	@Override
	public Accident getByCustomerId(String customerID){
		for(Accident accident : this.accidentList) {
			if (accident.getCustomerID().equals(customerID))
				return accident;
		}
		return null;
	}

	@Override
	public boolean updateAccidentScale(String accidentID, Level accidentScale){
		for(Accident accident : this.accidentList) {
			if (accident.getAccidentID().equals(accidentID)){
				accident.setAccidentScale(accidentScale);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateDoingHarm(String accidentID, boolean doingHarm){
		for(Accident accident : this.accidentList) {
			if (accident.getAccidentID().equals(accidentID)){
				accident.setDoingHarm(doingHarm);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateExemptionInfo(String accidentID, ExemptionInfo exemptionInfo){
		for(Accident accident : this.accidentList) {
			if (accident.getAccidentID().equals(accidentID)){
				accident.setExemptionInfo(exemptionInfo);
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Accident> getAllList() {
		return this.accidentList;
	}

	@Override
	public Optional<Accident> getOptionalAccidentByCustomerId(String customerID) {
		return Optional.empty();
	}
}//end AccidentListImpl