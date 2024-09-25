package fitness.vo;

//아이디(pk), 이름, 성별, 키, 몸무게, 표준체중, BMI, BMI 결과

public class Fitness {
	private int id;
	private String name;
	private String gender;
	private double height;
	private double weight;
	private double stdWeight;
	private double bmi;
	private String bmiResult;
	
	public Fitness(){}

	public Fitness(int id, String name, String gender, double height, double weight) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		
		calcStdWeight();
		calcBMI();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
		calcStdWeight();
		calcBMI();
	}

	public double getBmi() {
		return bmi;
	}

	public String getBmiResult() {
		return bmiResult;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
		calcStdWeight();
		calcBMI();
	}

	public double getStdWeight() {
		return stdWeight;
	}

	private void calcStdWeight(){
		double temp = height / 100; // m로 환산된 키
		 
	    //남자인지 여자인지 판단해서 표준체중을 다르게 계산해야 함
	    if(gender.equals("남")) { // 기본자료형만 ==을 비교, 객체참조형은 equals만 가지고 해야함
	  	  stdWeight = temp * temp * 22;
	    } else {
	  	  stdWeight = temp * temp * 21;
	    }
	    
	}
	private void calcBMI() {
		double temp = height / 100; // m로 환산된 키
		bmi = weight / (temp * temp);
		calcBmiResult();
	    
	}

	private void calcBmiResult() {
		 if (bmi >= 35) {
			 bmiResult = "고도비만";
			}else if (bmi >=30){
				bmiResult = "중도비만";
			}else if (bmi >=25){
				bmiResult = "경도비만";
			}else if (bmi >=23){
				bmiResult = "과체중";
			}else if (bmi >=18.5){
				bmiResult = "정상";
			}else {
				bmiResult = "저체중";
			}
		
	}
  
	public void output() {
		System.out.printf("%2d %s %s %.2fcm %.2fkg 표준체중 : %.2f BMI : %.2f %s%n",
				id, name, gender, height, weight, stdWeight, bmi, bmiResult); // %n 줄나눈기
	}

	
}
