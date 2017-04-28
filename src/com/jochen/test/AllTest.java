package com.jochen.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class AllTest {

	static float total_corpus = 3000.04f;// 本金
	static float total_profits = 0.0f;// 分期X月所得利润
	static float month_profits = 257.6f;// 每月应还本金(不含手续费)
	static float rate = 0.06f;// 利润率
	static int i = 1;

	static int cul_val = 0;

	static boolean worktime_color = false;
	static int count = 0; // 计数用

	public static void main(String[] args) {

		// 题目描述：一个正整数有可能可以被表示为n(n>=2)个连续正整数之和，如：
		// 15=1+2+3+4+5
		// 15=4+5+6
		// 15=7+8
		// nextNum();
		// 随机生成一个6位数
		// int num = RamdomNum(); System.out.println("num = "+num);
		// BigNum();// 大数加减乘除
		// Calcu(); //计算4位数内，除2，3，4...10余1,2,3...9
		// Sspit(); spit功能测试
		// total_profits = Sfenqi(total_corpus); //分期利息计算
		// showDemo();//从本地读取程序并显示
		// -----------------------------------------------
		// boolean crrent_color = workstime(8, 17, 6);
		// System.out.println("crrent_color = "+crrent_color);
		// if(crrent_color==false){
		// System.out.println("crrent_color = 蓝色");
		// }else{
		// System.out.println("crrent_color = 红色");
		// }
		// -----------------------------------------------
		//OutputToTxt();//将一个数组写入到TXT文件中

	}

	private static void OutputToTxt() {
		// TODO Auto-generated method stub
		
		int str[] = {100,101,102,103,104,105};
		//Integer i = new Integer(str);
		File file = new File("E:/Dest.txt");
		byte[] bytes = new byte[1024];
		
		if(!file.exists()){
			//检测文件不存在
			//file.mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			DataOutputStream output = new DataOutputStream(new FileOutputStream(file));
			
			for(int i=0;i<str.length;i++){
				output.writeInt(str[i]);
			}		
			output.close();
			
			DataInputStream intput = new DataInputStream(new FileInputStream(file));
			intput.read(bytes, 0, bytes.length);
			for(int i=str.length-1;i>0;i--){
				System.out.println(bytes[i*4+3]);
			}
			
			intput.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void showDemo() {
		// TODO Auto-generated method stub
		byte[] buf = new byte[10240];
		try {
			FileInputStream file = new FileInputStream("E:/TEXT.txt");

			int length = file.read(buf, 0, buf.length);
			String string = new String(buf, "gbk");
			String[] str = string.split("。");
			for (int i = 0; i < str.length; i++) {
				System.out.println(str[i]);
			}

			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void BigNum() {
		// TODO Auto-generated method stub
		BigInteger aa = new BigInteger("00000000000000000000001");
		BigInteger bb = new BigInteger("333333333333");
		BigInteger sub = aa.subtract(bb);// 大整数的减
		BigInteger add = aa.add(bb);// 大整数的加
		BigInteger mul = aa.multiply(bb);// 大整数的乘
		BigInteger div = aa.divide(bb);// 大整数的除
		System.out.println(sub.toString());
		System.out.println(add.toString());
		System.out.println(mul.toString());
		System.out.println(div.toString());
	}

	private static int RamdomNum() {
		int i = 0;
		Random rad = new Random();
		int num = 0;
		while (true) {
			num = rad.nextInt(1000000);
			if (num <= 999999 && num >= 100000) {
				break;
			}
			i++;
		}
		System.out.println("i=" + i);
		return num;
	}

	private static void nextNum() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in); // 使用Scanner类定义对象
		int b = in.nextInt(); // 接收整形数据
		int num = 0;
		boolean flag = false;

		for (int i = 1; i < b; i++) {
			int j = i;

			while (num < b) {
				num += j;
				j++;
			}
			if (num == b) {
				flag = true;
				System.out.print(b + "=");
				for (int k = i; k < j; k++) {

					if (k == (j - 1)) {
						System.out.println(k);
					} else {
						System.out.print(k + "+");
					}
				}

				num = 0;
			} else {
				num = 0;
			}

		}
		if (flag == false) {
			System.out.println("NONE");
		}
		in.close();
	}

	// 1.当前位置, 2.当天日期, 3.具体工作第几天
	private static boolean workstime(int pos, int crr, int worktime) {
		// TODO Auto-generated method stub

		// 判断早中班 T红F蓝，红早蓝中
		worktime_color = (worktime > 3) ? false : true;

		int comp = crrs(worktime, crr, pos);// 判断当天日期在1,2,3哪个位置返回用来比较的值

		System.out.println("comp = " + comp);

		if (comp < pos) {// 具体位置大于当前比较值
			worktime_color = !worktime_color;
			for (int y = comp + 1; y <= pos; y++) {
				if (y % 7 == 0) {
					count = count + 0;
				} else {
					count++;
				}
				if (count == 4) {
					count = 1;
					worktime_color = !worktime_color;
				}
			}
		} else if (comp == pos) { // 等于情况
			count = 0;
			return worktime_color;
		} else {// 小于情况
			worktime_color = !worktime_color;
			for (int y = comp - 1; y >= pos; y--) {
				if (y % 7 == 0) {
					count = count + 0;
				} else {
					count++;
				}
				if (count == 4) {
					count = 1;
					worktime_color = !worktime_color;
				}
			}
		}
		count = 0;
		return worktime_color;
	}

	private static int crrs(int worktime, int crr, int pos) {

		if (worktime % 3 == 0) {
			return (crr < pos) ? crr : crr - 2;
		} else if (worktime % 3 == 1) {
			return (crr < pos) ? crr + 2 : crr;
		} else {
			if (crr < pos) {
				return crr + 1;
			} else {
				return crr - 1;
			}
		}

	}

	//
	private static void Calcu() {

		int a1 = 0;

		int num1;

		Map mp = new HashMap();// 存放所有情况
		// int a[] = null;

		for (num1 = 1000; num1 <= 9999; num1++) {
			int flag = Calcu2(num1, 2);
			if (flag == 9) {
				mp.put("" + a1++, "" + num1);
			}
		}

		for (int y = 0; y < mp.size(); y++) {
			System.out.println("mp[" + y + "] = " + mp.get("" + y));

		}

	}

	private static int Calcu2(int num, int i) {

		if (i > 10) {

			return 0;
		} else if ((num % i) == (i - 1)) {

			return (1 + Calcu2(num, i + 1));
		} else {

			return 0;
		}
		// return false;

	}

	// 1，本金 2.利率 3.每月还款
	private static float Sfenqi(float corpus) {
		// TODO Auto-generated method stub

		float profits = 0.0f;

		if (corpus < 0.00001) {
			return 0;
		} else {
			profits = (float) (corpus * rate / 365 * 30);
		}
		System.out.println("profits " + i++ + " = " + profits);

		return (profits + Sfenqi(corpus - month_profits));
	}

	private static void Sspit() {
		// TODO Auto-generated method stub
		String info = "在迭代时，不可以通过集合对象的方法操作集合中的元素，因为会发生并发修改异常。Iterator方法有限。Listiterator可以实现增加，修改操作。改接口只能通过List集合的Listiterator方法获取";

		for (int i = 0; i < info.split("。").length; i++) {
			System.out.println("AllTest is :" + info.split("。")[i]);
		}
	}

}
