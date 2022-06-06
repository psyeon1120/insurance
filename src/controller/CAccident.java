package Practice.InsuranceCompany.Design.src.controller;

import Practice.InsuranceCompany.Design.src.dao.AccidentDao;
import Practice.InsuranceCompany.Design.src.model.accident.Accident;
import Practice.InsuranceCompany.Design.src.model.accident.AccidentListImpl;
import Practice.InsuranceCompany.Design.src.model.accident.ExemptionInfo;
import Practice.InsuranceCompany.Design.src.model.insurance.WarrantyInfo;

public class CAccident {
    private AccidentDao accidentDao;

    public CAccident(){
        this.accidentDao = new AccidentDao();
    }

    public AccidentListImpl getAllAccidentList() {
        return this.accidentDao.retrieveAll();
    }

    public AccidentListImpl getAccidentList() {
        return this.accidentDao.retrieve();
    }


    public boolean create(Accident accident){ return this.accidentDao.create(accident); }

    public Accident getByAccidentID (String accidentID) {
        return this.accidentDao.retrieveById(accidentID);
    }

    public boolean addAccident(Accident accident) {
        return this.accidentDao.create(accident);
    }

    public boolean updateExemptionInfoID(String accidentID, Accident accident) {
        return this.accidentDao.update(accidentID,accident);
    }

    public boolean update(String accidentID, Accident accident) {
        return this.accidentDao.update(accidentID,accident);
    }
//  public boolean deleteAccidentById(String accidentID) {
    //       return this.accidentDao.delete(accidentID);
    //   }

    public int getMaxID() { return this.accidentDao.retrieveMaxID(); }

}
