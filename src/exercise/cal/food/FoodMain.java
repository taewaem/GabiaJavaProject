package cal.food;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FoodMain {
	
	//아래 2줄은 음식의 이름과 1인분 섭취 칼로리를 넣는 변수
	public static String foodName="";
	public static double foodKcal;

	public static void main(String[] args) 
	{
		int serving;
		
		//운동의 이름과 소비 칼로리를 선언해 둔 클래스의 List
		List<Food> foodList = new ArrayList<Food>();
		
		//List에 데이터 입력
		foodList.add(new Food("후라이드치킨", 600));
		foodList.add(new Food("양념치킨", 700));
		foodList.add(new Food("패퍼로니피자", 300));
		foodList.add(new Food("불고기피자", 320));
		foodList.add(new Food("씨푸드피자", 270));
		foodList.add(new Food("하와이안피자", 230));
		foodList.add(new Food("소고기버거", 250));
		foodList.add(new Food("소고기치즈버거", 350));
		foodList.add(new Food("치킨버거", 500));
		foodList.add(new Food("새우버거", 500));
		
		//List의 size만큼 String[]의 공간을 확보
		String[] foodNameList = new String[foodList.size()];
		
		for (int i = 0; i < foodNameList.length; i++) 
		{
			foodNameList[i]=foodList.get(i).getFoodName();
		}
		
		//정보 확인용 콘솔 출력
		for (Food food : foodList) 
		{
			System.out.println(food);
		}
		
		//변수방에 유저가 선택한 운동의 이름 넣기
		foodName = (String)JOptionPane.showInputDialog(null, "식사", "식단 선택", JOptionPane.DEFAULT_OPTION, null ,foodNameList, foodNameList[0]);
		
		if (foodName==null)//cancel 버튼을 눌렀을 때, 
		{
			foodName=foodNameList[0];//기본값을 입력한다.
		}
		
		//음식 클래스 배열에서, 유저가 선택한 음식의 이름과 같은 객체 찾기
		for (Food food : foodList) 
		{
			if (food.getFoodName().equals(foodName))//찾았다면,
			{
				foodKcal=food.getFoodKcal();//칼로리를 찾고 foodKcal에 대입
				break;
			}
		}
		
		try//에러체크
		{
			serving = Integer.parseInt(JOptionPane.showInputDialog(null,"몇인분 드셨나요?",""));
		} 
		
		catch (Exception e)//입력한 값이 정수형이 아닐경우 에러처리
		{
			JOptionPane.showMessageDialog(null, "식사량은 숫자로 입력해 주세요!","에러",JOptionPane.ERROR_MESSAGE);
			serving=0;
			
			return;//반환
		}
		
		DecimalFormat formatter = new DecimalFormat("###,###.##");//자릿수를 위한 DecimalFormat
		
		double eatKcal=(foodKcal)*serving;//표시할 총 섭취 칼로리 = ?인분 * 해당 음식의 1인분 칼로리
		JOptionPane.showMessageDialog(null, 
									  "음식이름: "+foodName+"\n"+"총 섭취 칼로리: "+formatter.format(eatKcal)+"Kcal",
									  "당신의 식단정보",
									  JOptionPane.PLAIN_MESSAGE);
		
	}

}
