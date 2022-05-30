package Practice.InsuranceCompany.Design.src.policyholder;


import Practice.InsuranceCompany.Design.src.etcEnum.Level;

import java.util.Scanner;

/**
 * @author macbook
 * @version 1.0
 * @created 21-5-2022 ���� 11:03:48
 */
public class DiseaseHistory {

	private String name;
	private Level severity;
	private int strugglePeriod;

	public DiseaseHistory(){

	}

	public Level getSeverity(){ return this.severity; }
	public int getStrugglePeriod(){ return this.strugglePeriod; }

	public void setDiseaseHistoryForAcquisitionPolicy(Scanner scanner){
		System.out.println("질환명 : ");
		this.name = scanner.next();

		System.out.println("질환의 중즘도(고/중/저) : ");
		String input = scanner.next();
		if(input.equals("고")) this.severity = Level.high;
		else if(input.equals("중")) this.severity = Level.high;
		else if(input.equals("저")) this.severity = Level.low;
		else System.out.println("잘못된 중증도입니다.");

		System.out.println("투병 기간(단위:개월) : ");
		this.strugglePeriod = scanner.nextInt();
	}

	public void finalize() throws Throwable {

	}
}//end DeseaseHistory