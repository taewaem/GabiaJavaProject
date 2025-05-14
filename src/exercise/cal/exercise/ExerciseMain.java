package cal.exercise;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ExerciseMain {
	
	//아래 2줄은 운동의 이름과 분당 소모 칼로리를 넣는 변수
	public static String exerName="";
	public static double exerKcal;
	
	//public static double exer="";
	
	public static void main(String[] args) 
	{

		int min;
		//가져올 운동의 이름 배열
		
		//운동의 이름과 소비 칼로리를 선언해 둔 클래스의 List
		List<Exercise> exerList = new ArrayList<Exercise>();
		
		//리스트에 운동 데이터 추가
		exerList.add(new Exercise("달리기", 8.6));
		exerList.add(new Exercise("걷기", 2.4));
		exerList.add(new Exercise("계단오르내리기", 8));
		exerList.add(new Exercise("줄넘기", 10));
		exerList.add(new Exercise("댄스", 5));
		exerList.add(new Exercise("자전거타기", 4.7));
		exerList.add(new Exercise("윗몸일으키기", 4));
		exerList.add(new Exercise("팔굽혀펴기", 7));
		exerList.add(new Exercise("스쿼트", 8));
		exerList.add(new Exercise("수영", 7));
		
		String[] exerNameList = new String[exerList.size()];
		//리스트의 길이만큼, String 배열의 공간을 확보
		
		//String배열의 처음부터 끝까지
		for (int i = 0; i < exerNameList.length; i++) 
		{
			exerNameList[i]=exerList.get(i).getExerName();//리스트의 요소에서 이름을 가져와 넣기
		}
		
		//정보 확인용 콘솔 출력
		for (Exercise exercise : exerList) 
		{
			System.out.println(exercise);
		}
		
		//변수방에 유저가 선택한 운동의 이름 넣기
		exerName = (String)JOptionPane.showInputDialog(null, "운동", "운동 선택", JOptionPane.DEFAULT_OPTION, null ,exerNameList, exerNameList[0]);
		
		if (exerName==null)//해시코드가 0라면,(취소를 눌렀다는 뜻)
		{
			exerName=exerNameList[0];//기본값(달리기)으로 초기화
		}
		
		//운동 클래스 배열에서, 유저가 선택한 운동의 이름과 같은 객체 찾기
		for (Exercise exercise : exerList) 
		{
			if (exercise.getExerName().equals(exerName))//찾았다면,
			{
				exerKcal=exercise.getExerKcal();//칼로리를 찾고 exerKcal에 대입
				break;
			}
		}
		
		try//에러확인
		{
			min = Integer.parseInt(JOptionPane.showInputDialog(null,"운동시간 (분) 입력",""));
		} 
		
		catch (Exception e)//입력한 값이 정수형이 아닐경우 에러처리
		{
			JOptionPane.showMessageDialog(null, "운동시간은 정수로 입력해 주세요!","에러",JOptionPane.ERROR_MESSAGE);
			min=0;
			
			return;//반환
		}
		
		
		JOptionPane.showMessageDialog(null, "운동이름: "+exerName+"\n"+"총 소비 칼로리: "+(exerKcal*min)+"Kcal","당신의 운동정보",JOptionPane.PLAIN_MESSAGE);
		
	}

}
