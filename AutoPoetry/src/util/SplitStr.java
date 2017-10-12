package util;
import java.util.ArrayList;

/*
 * 完成分词功能
 * 1.给予一段字符串，通过字符串消除分隔符
 * 2.对进行分割后的字符串，按字数进行分词
 * 
 * 
 * splitStr函数通过调用divideWord，实现分词
 *
 */
public class SplitStr {

	/*
	 * 消除分隔符
	 */
	public static ArrayList<String> splitStr(String str) {
		//消除分隔符
		String replace = str.replaceAll("？|。|，|,|、|！", "-");
		
		//利用arraylist进行每一句的循环，并将循环所得的没个词，附加在arraylist上
		ArrayList<String> arrLi = new ArrayList<String>();
		for (String retval : replace.split("-")) {
			// 将每个单词保存到arraylist中
			arrLi.addAll(divideWord(retval));			
		}
		
		//divideWord 的test
		/*System.out.println(arrLi);*/
		
		//savePre test
		
		return(arrLi);

	}

	/*分割单词
	 * 按照每句词的长度，进行简单分类 count=2,分为2 count=3,分为1，2 count=4,分为2，2 count=5,分为2，2，1
	 * count=6,分为2，2，2 count=7,分为2，2，3 count=8,分为2，2，2，2
	 */
	public static ArrayList<String> divideWord(String poetry) {
		ArrayList<String> al = new ArrayList<String>();
		int count = poetry.length();
		if (count != 0) {
			switch (count) {
			case 1:
				al.add(poetry);
				break;
			case 2:
				al.add(poetry);
				break;
			case 3:
				{al.add(poetry.substring(0, 1));
				al.add(poetry.substring(1, 3));}
				break;
			case 4:
				{al.add(poetry.substring(0, 2));
				al.add(poetry.substring(2, 4));}
				break;
			case 5:
				{al.add(poetry.substring(0, 2));
				al.add(poetry.substring(2, 4));
				al.add(poetry.substring(4, 5));}
				break;
			case 6:
				{al.add(poetry.substring(0, 2));
				al.add(poetry.substring(2, 4));
				al.add(poetry.substring(4, 6));}
				break;
			case 7:
				{al.add(poetry.substring(0, 2));
				al.add(poetry.substring(2, 4));
				al.add(poetry.substring(4, 7));}
				break;
			case 8:
			{al.add(poetry.substring(0, 2));
			al.add(poetry.substring(2, 4));
			al.add(poetry.substring(4, 6));
			al.add(poetry.substring(6, 8));}
			break;
			default:
				break;
			}
		}
		return al;
	}
}

