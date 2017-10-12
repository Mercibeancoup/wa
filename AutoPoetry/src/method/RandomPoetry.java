package method;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import util.ChineseToEnglish;
import util.DButil;
import util.SplitStr;

public class RandomPoetry {
	public static void main(String[] args) throws SQLException, UnsupportedEncodingException, IOException {
		// 创建控制台扫描对象
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你要查询的关键字：");
		String search = sc.nextLine().trim();
		System.out.println("请输入你想生成的词牌（浣溪沙、渔家傲）：");
		String ciPai = sc.nextLine().trim();
		//查询的宋词进行分词
		ArrayList<String> bigArr = songPoemsFormat(search);
		//得到随机生成的宋词
		ArrayList<String> selfPoetry= getSelfPoetry(bigArr,ciPai);
		//将宋词转换成之前的格式
		String randomPoetry=formatSelfPoetry(selfPoetry,ciPai);
		System.out.println(randomPoetry);
		sc.close();
	}
	private static String formatSelfPoetry(ArrayList<String> selfPoetry,String ciPai) {
		ArrayList<String> a = new ArrayList<String>();
		String s = "";
		for (Iterator<String> iterator = selfPoetry.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			s += string;
		}
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			a.add(String.valueOf(charArray[i]));
		}
		String ciPaiName = CiPai.getFormat(ciPai);
		// 逗号
		String[] douhaoindex = searchAllIndex(ciPaiName, "，").split("-");
		for (int i = 0; i < douhaoindex.length; i++) {
			a.add(Integer.valueOf(douhaoindex[i]), "，");
		}
		// 句号
		String[] juhaoindex = searchAllIndex(ciPaiName, "。").split("-");
		for (int i = 0; i < juhaoindex.length; i++) {
			a.add(Integer.valueOf(juhaoindex[i]), "。");
		}
		if (ciPaiName.contains("？")) {
			// 问号
			String[] wenhaoindex = searchAllIndex(ciPaiName, "？").split("-");
			for (int i = 0; i < wenhaoindex.length; i++) {
				a.add(Integer.valueOf(wenhaoindex[i]), "？");
			}
		}
		
		if (ciPaiName.contains("、")) {
			// 顿号
			String[] dunhaoindex = searchAllIndex(ciPaiName, "、").split("-");
			for (int i = 0; i < dunhaoindex.length; i++) {
				a.add(Integer.valueOf(dunhaoindex[i]), "、");
			}
		}
		
		if (ciPaiName.contains("！")) {
			// 感叹号
			String[] gantanhaoindex = searchAllIndex(ciPaiName, "！").split("-");
			for (int i = 0; i < gantanhaoindex.length; i++) {
				a.add(Integer.valueOf(gantanhaoindex[i]), "！");
			}
		}
		

		String b = "";
		for (Iterator<String> iterator = a.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			b += string;
		}
		
		return b;

	}
	// 得到标点符号出现的索引
	private static String searchAllIndex(String ciPai, String punctuation) {
		int a = ciPai.indexOf(punctuation);// *第一个出现的索引位置
		String b = "";
		while (a != -1) {
			b += a + "-";
			a = ciPai.indexOf(punctuation, a + 1);// *从这个索引往后开始第一个出现的位置
		}
		if (b.length() > 0) {
			return b.substring(0, b.length() - 1);
		}
		return b;
	}
	//得到随机生成的相应格式的宋词
	private static ArrayList<String> getSelfPoetry(ArrayList<String> bigArr,String ciPai) {
		ArrayList<String> ciPaiName = CiPai.getCiPaiList(ciPai);
		ArrayList<String> selfPoety = new ArrayList<String>();
		for (int i = 0; i < ciPaiName.size(); i++) {
			String string = ciPaiName.get(i);
			int length = string.length();
			if (string.contains("中")) {
				int indexOf = string.indexOf("中");
				switch (length) {
				case 1:
					while (true) {
						int randomNumber = new Random().nextInt(bigArr.size());
						if (bigArr.get(randomNumber).length() == length) {
							selfPoety.add(bigArr.get(randomNumber));
							bigArr.remove(randomNumber);
							break;
						}

					}
					break;
				case 2:
					if (indexOf == 0) {
						while (true) {
							int randomNumber = new Random().nextInt(bigArr.size());
							if (bigArr.get(randomNumber).length() == length
									&&(ChineseToEnglish.getPinYinPingZe(bigArr.get(randomNumber)).substring(1)).equals(string.substring(1))) {
								selfPoety.add(bigArr.get(randomNumber));
								bigArr.remove(randomNumber);
								break;
							}
						}
					} else {
						while (true) {
							int randomNumber = new Random().nextInt(bigArr.size());
							if (bigArr.get(randomNumber).length() == length
									&& (ChineseToEnglish.getPinYinPingZe(bigArr.get(randomNumber)).substring(0, 1)).equals(string.substring(0, 1))) {
								selfPoety.add(bigArr.get(randomNumber));
								bigArr.remove(randomNumber);
								break;
							}
						}
					}
					break;
				case 3:
					if (indexOf == 0) {
						while (true) {
							int randomNumber = new Random().nextInt(bigArr.size());
							if (bigArr.get(randomNumber).length() == length
									&& (ChineseToEnglish.getPinYinPingZe(bigArr.get(randomNumber)).substring(1)).equals(string.substring(1))) {
								selfPoety.add(bigArr.get(randomNumber));
								bigArr.remove(randomNumber);
								break;
							}
						}
					} else if (indexOf == 1) {
						while (true) {
							int randomNumber = new Random().nextInt(bigArr.size());
							if (bigArr.get(randomNumber).length() == length
									&& (ChineseToEnglish.getPinYinPingZe(bigArr.get(randomNumber)).substring(0, 1)).equals(string.substring(0, 1))
									&& (ChineseToEnglish.getPinYinPingZe(bigArr.get(randomNumber)).substring(1)).equals(string.substring(1))) {
								selfPoety.add(bigArr.get(randomNumber));
								bigArr.remove(randomNumber);
								break;
							}
						}
					}else{
						while (true) {
							int randomNumber = new Random().nextInt(bigArr.size());
							if (bigArr.get(randomNumber).length() == length
									&& (ChineseToEnglish.getPinYinPingZe(bigArr.get(randomNumber)).substring(0)).equals(string
											.substring(0))) {
								selfPoety.add(bigArr.get(randomNumber));
								bigArr.remove(randomNumber);
								break;
							}
						}
					}
					break;
				default:
					break;
				}

			} else {
				while (true) {
					int randomNumber = new Random().nextInt(bigArr.size());
					if (bigArr.get(randomNumber).length() == length
							&&  ChineseToEnglish.getPinYinPingZe(bigArr.get(randomNumber)).equals(string)) {
						selfPoety.add(bigArr.get(randomNumber));
						bigArr.remove(randomNumber);
						break;
					}
				}
			}
		}
		return selfPoety;
	}
	//对查询到的宋词进行分词
	private static ArrayList<String> songPoemsFormat(String search) throws SQLException {
		ArrayList<String>  bigArr=new ArrayList<String>();
		// 创建数据库连接
		Connection con = DButil.getCon();
		// SQL语句运行前这个对象是语句是可以被数据库解释
		Statement st = con.createStatement();
		String sql =  "SELECT * FROM basicpoetry WHERE content LIKE '%" + search
				+ "%'";
		// 执行SQL语句
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()){
			
			String content = rs.getString("content");
				
			ArrayList<String> divideWord = SplitStr.splitStr(content);
			
			bigArr.addAll(divideWord);
			
		}
		return bigArr;
	}	
}