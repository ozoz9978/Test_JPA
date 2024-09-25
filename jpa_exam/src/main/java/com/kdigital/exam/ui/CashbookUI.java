package com.kdigital.exam.ui;

import java.util.List;
import java.util.Scanner;

import com.kdigital.exam.entity.Cashbook;
import com.kdigital.exam.entity.ItemType;
import com.kdigital.exam.entity.TotalAmount;
import com.kdigital.exam.service.CashbookService;
import com.kdigital.exam.service.CashbookServiceImpl;

public class CashbookUI {
	Scanner keyin = new Scanner(System.in);
	CashbookService service = new CashbookServiceImpl();
	
	public CashbookUI() {
		String choice;
		
		while(true) {
			menu();
			choice = keyin.next();
			
			switch(choice) {
			case "1" : create();   break;
			case "2" : retrieve(); break;  // 년도(4) + 월(2)
//			case "3" : delete();   break;
			case "4" : statistics(); break;
			case "0" : 
				System.out.println("## 프로그램을 종료합니다.");
				return;
			}
		}
	} // 생성자 끝
	
	/**
	 * 지출 내역 입력
	 */
	private void create() {
		System.out.println("\n<< 지출 내역 입력 >>");
		
		int number, amount; 	// 항목번호 입력
		String detail, note;
		ItemType type = null;
		
		System.out.println("1 (식비), / 2 (문화예술) / 3(미용(의복)) / 4 (교통비) / 5 (경조사비) / 6 (금융(저축 등)) / 7 (기타)");
		System.out.print("## 항목번호: "); 
		number = keyin.nextInt();
		
		switch(number) {
		case 1 : type = ItemType.식비; 		break;
		case 2 : type = ItemType.문화예술; 	break;
		case 3 : type = ItemType.미용; 		break;
		case 4 : type = ItemType.교통; 		break;
		case 5 : type = ItemType.경조사; 	break;
		case 6 : type = ItemType.금융; 		break;
		case 7 : type = ItemType.기타; 		break;
		}
		
		keyin.nextLine();   // 버퍼 비우기
		
		System.out.print("## 자세한 내역: "); 
		detail = keyin.nextLine();

		System.out.print("## 금액: "); 
		amount = keyin.nextInt();
		
		keyin.nextLine();
		System.out.print("## 메모할 내용: "); 
		note = keyin.nextLine();

		Cashbook cashbook = new Cashbook(type, detail, amount, note); 
		
		boolean result = service.insert(cashbook);
		if(result) {
			System.out.println("1개의 항목이 저장되었습니다.");	
		} else {
			System.out.println("## 저장 실패");
		}
	}

	// 월별 지출 보기
	private void retrieve() {
		System.out.println("\n<< 월별 지출 보기 >>");
		
		String date = makeDate();
	
		List<Cashbook> list = service.selectData(date);
		
		if(list.size() == 0) {
			System.out.println("## 조회된 날짜의 데이터가 없습니다.");
			return;
		}
		
		System.out.println("## 조회된 데이터의 개수 : " + list.size());
		
		// 출력
		list.forEach((data) -> System.out.println(data));
	}

	/**
	 * 지출 통계 보기
	 */
	private void statistics() {
		System.out.println("\n<< 지출 통계 보기 >>");
		
		String date = makeDate();
	
		List<TotalAmount> list = service.statistics(date);
		
		if(list.size() == 0) {
			System.out.println("## 조회된 날짜의 데이터가 없습니다.");
			return;
		}
		
		int total = 0;
		
		// 총 지출 합계 구함
		for(TotalAmount book : list) {
			total += book.getTotal();
		}
		
		for(TotalAmount book : list) {
			System.out.print(book);
			System.out.printf("  비율 : %.2f%% %n", (book.getTotal()/(double)total) * 100);
		}
		System.out.printf(" ** 총 지출 합계: %,d원 %n", total);
		System.out.println();
	}
	
	private String makeDate() {
		String year, month, date = null;
		
		keyin.nextLine();
		
		System.out.print("## 년도를 4자리로 입력 : ");
		year = keyin.nextLine();
		
		try {
			if(year.length() != 4) {
				throw new Exception("## 데이터가 잘못 입력되었습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		System.out.print("## 월을 2자리로 입력 : ");
		month = keyin.nextLine();
		
		try {
			if(month.length() != 2) {
				throw new Exception("## 데이터가 잘못 입력되었습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		date = year + "-" + month;
		return date;
	}
	
	
	/**
	 * 메뉴를 화면에 출력
	 */
	private void menu() {
		System.out.println("== [ 지출 관리 ] ==");
		System.out.println(" 1) 지출 내역 입력");
		System.out.println(" 2) 지출 내역 조회");
		System.out.println(" 3) 내역 삭제");
		System.out.println(" 4) 지출 통계보기");
		System.out.println(" 0) 종  료");
		System.out.println("-----------------------");
		System.out.print  ("    선택 > ");
	}
}
