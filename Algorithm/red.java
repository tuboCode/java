package demo;

import java.util.ArrayList;
import java.util.List;

public class red {

	//设置金额最大值和最小值
	private static final float max_money=200f;
	private static final float min_money=0.01f;
	private static final double time=2.1;
	
	/*
	 * 判断金额是否合法
	 */
	/*
	private boolean isRight(float money , int count){
		double avg = money/count;
		if(avg<min_money){
			return false;
		}else if(avg>max_money){
			return false;
		}
		return true;
	}
	*/
	private boolean isRight(float money, int count) {
		double avg = money / count;
		if (avg < min_money) {
			return false;
		} else if (avg > max_money) {
			return false;
		}
		return true;
	}
	/*
	 *随机产生红包 
	 */
		private float redRandom(float money ,float minx,float maxs,int count){
		if(count==1) {
			return (float) (Math.round(money*100))/100;
		}
		if(minx == maxs){
			return minx;
		}
		float mins = maxs>money? money:maxs;
		float one = ((float) Math.random()*(mins-minx)+minx);
		one = (float)(Math.round(one*100))/100;
		float moneyother = money-one;
		if(isRight(moneyother,count-1)){
			return one;
		}else{
			float avg =moneyother/(count-1);
			if(avg<min_money){
				return redRandom(money, minx, one, count);
			}else if(avg>max_money){
				return redRandom(money, one, maxs, count);
			}
		}
		return one;
	}
	
	/*
	 * 实现红包随机分配
	 */
		
	public List<Float> splitRed(float money , int count){
		if(!isRight(money,count)){
			return null;
		}
		List<Float> list = new ArrayList<Float>();
		float max = (float)(money*time/count);
		max = max>max_money?max_money:max;
		for(int i=0 ;i<count;i++){
			float one = redRandom(money,min_money,max,count-i);
			list.add(one);
			money-=one;
		}
		return list;
	}
		
		/*
		public List<Float> splitRedPackets(float money, int count) {
			if (!isRight(money, count)) {
				return null;
			}
			List<Float> list = new ArrayList<Float>();
			float max = (float) (money * time / count);

			max = max > max_money ? max_money : max;
			for (int i = 0; i < count; i++) {
				float one = redRandom(money, min_money, max, count - i);
				list.add(one);
				money -= one;
			}
			return list;
		}
		*/
	public static void main(String[] args) {

		red re = new red();
		System.out.println(re.splitRed(200, 2));
	}
}
