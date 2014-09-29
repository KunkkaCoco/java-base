package algorithm.hero;

import java.util.Scanner;

/*
 * 结果封装类，保存计算结果（没办法，java只支持传值参）
 */
public class Max {
	public int start=0 ,end=0;
	public double total=0;
	/**
	 * 入口
	 */
	public static void main(String[] args) {
		//double []num={-1,2,4,0,6,-1,-10,-7,-0.1,-9,-2,100,-0.6,-19,0,110};
		//输入数据
		System.out.print("Please input the Array size:>");
		Scanner in =new Scanner(System.in);
		int N =in.nextInt();
		double []num =new double[N];
		System.out.print("Please input the Numbers:>");
		for(int i=0;i<N;i++)
			num[i] =in.nextDouble();
		//回显输入
		System.out.print("Your Numbers:> ");
		for(int i=0;i<N;i++)
			System.out.print(num[i]+" ");
		System.out.println();
		//定义结果集
		Max result=new Max();
		run(num, result);	//运行计算
		//打印结果
		System.out.println("The MAX Product= "+result.total+" ~~~~~index range 【 "+result.start+" -> "+result.end+" 】");
	}
	
	/*因为是连续乘积，所以可以穷举 所有的计算组合，组合数量也不大；
	 * 然后，筛选 乘积最大的组合
	 * 备注：主要分析：按<=-1,-1~0,0,0~1,>=1切割分组，当这几种分组穿插组合之后，要考虑的情况实在有点复杂，所以选择穷举，简单方便；
	 * 如果数字很多，可以考虑先按上述分组，合并部分可合并项，例如>=1的可以合并为一项，单个分组为偶数个<=-1可合并为一项等等，然后再穷举
	 */
	private static void run(double[] num, Max result) {
		System.out.println("开始穷举。。。。。。。。。。。。。。。。。。。。。");
		for(int i=0;i<num.length;i++){	//遍历所有穷举点
			double n =num[i];
			System.out.println("###########    "+n+" -> index = "+i+"    ##########");	//打印穷举点
			if(n==0)	continue;		//遇到0终止当前穷举，并以下一项为基准点开始新穷举，因为0乘以任何数都为0
			for(int j=i+1;j<num.length;j++){
				if(num[j]==0)	break;	//遇到0，中断组合
				n*=num[j];				//计算当前组合的乘积
				System.out.println("product : "+n+"    index range： 【"+i+" -> "+j+"】  ");	//打印穷举组合
				if(result.total<n){		//当前穷举组合比已知组合乘积都大，则重置最大穷举组合为当前组合
					result.start =i;
					result.end =j;
					result.total =n;
				}
			}
			System.out.println();
		}
	}

}
