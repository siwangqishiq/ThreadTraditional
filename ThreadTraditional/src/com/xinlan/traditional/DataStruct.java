package com.xinlan.traditional;

public class DataStruct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	public static int maxSequence(int a[]){
		int thisSum=0,maxSum=0;
		for(int i=0;i<a.length;i++){
			thisSum+=a[i];
			if(thisSum>maxSum){
				maxSum = thisSum;
			}else if(thisSum<0){
				thisSum = 0;
			}
			
		}//end for
		return maxSum;
	}
}
