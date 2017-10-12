package method;

import java.util.ArrayList;

import util.SplitStr;


public class CiPai {
		public static ArrayList<String> YuJiaAo(){
			
			//渔家傲词牌格式
			/*上片：
			中仄中平平仄仄（韵），中平中仄平平仄（韵）。
			中仄中平平仄仄（韵），平中仄（韵），中平中仄平平仄（韵）。
			下片：
			中仄中平平仄仄（韵），中平中仄平平仄（韵）。
			中仄中平平仄仄（韵），平中仄（韵），中平中仄平平仄（韵）。*/
			String ciPai="中仄中平平仄仄，中平中仄平平仄。中仄中平平仄仄，平中仄，中平中仄平平仄。中仄中平平仄仄，中平中仄平平仄。中仄中平平仄仄，平中仄，中平中仄平平仄。".replaceAll(" |\r|\n|　|  ", "");
			ArrayList<String> splitStr = SplitStr.splitStr(ciPai);
			return splitStr;
		}
		
		
		public static ArrayList<String> HuanXiSha(){
			//浣溪沙词牌格式
			/*中仄中平中仄平（韵），
			中平中仄仄平平（韵），
			中平中仄仄平平（韵）。
			中仄中平平仄仄（句），
			中平中仄仄平平（韵）。
			中平中仄仄平平（韵）。*/
			String ciPai="中仄中平中仄平，中平中仄仄平平，中平中仄仄平平。中仄中平平仄仄，中平中仄仄平平。中平中仄仄平平。".replaceAll(" |\r|\n|　|  ", "");
			ArrayList<String> splitStr = SplitStr.splitStr(ciPai);
			return splitStr;
		}

		public static String getYuJiaAo(){
			String yuJiaAo="中仄中平平仄仄，中平中仄平平仄。中仄中平平仄仄，平中仄，中平中仄平平仄。中仄中平平仄仄，中平中仄平平仄。中仄中平平仄仄，平中仄，中平中仄平平仄。".replaceAll(" |\r|\n|　|  ", "");
			return yuJiaAo;
		}
		public static String getHuanXiSha(){
			String huanXiSha="中仄中平中仄平，中平中仄仄平平，中平中仄仄平平。中仄中平平仄仄，中平中仄仄平平。中平中仄仄平平。".replaceAll(" |\r|\n|　|  ", "");
			return huanXiSha;
		}


		public static String getFormat(String ciPai) {
			if(ciPai.equals("浣溪沙")){
				return getHuanXiSha();
			}else if(ciPai.equals("渔家傲")){
				return getYuJiaAo();
			}
			return null;
		}
		
		public static ArrayList<String> getCiPaiList(String ciPai) {
			if(ciPai.equals("浣溪沙")){
				return HuanXiSha();
			}else if(ciPai.equals("渔家傲")){
				return YuJiaAo();
			}
			return null;
		}
}
