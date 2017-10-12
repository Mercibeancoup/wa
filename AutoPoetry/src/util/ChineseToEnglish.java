package util;
import net.sourceforge.pinyin4j.PinyinHelper;  
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;  
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;  
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;  
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;  
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;  
  
public class ChineseToEnglish {
	/* public static void main(String[] args) {  
	        System.out.println(getPingYin("鄢新疆傻傻的原来绿"
	        		+ ""));  
	        
	        
	        System.out.println(getPinYinShengMu("是只吃"));
	        System.out.println(getPinYinTone("鄢新疆傻傻的原来绿"));
	        System.out.println(getPinYinLastYunMu("裁剪冰绡"));
	        System.out.println(getPinYinTone("裁剪冰绡"));
	        System.out.println(getPinYinPingZe("裁剪冰绡"));
	    } */
	 
    // 将汉字转换为全拼  
    public static String getPingYin(String src) {  
  
        char[] t1 = null;  
        t1 = src.toCharArray();  
        String[] t2 = new String[t1.length];  
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();  
          
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        t3.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);  
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);  
        String t4 = "";  
        int t0 = t1.length;  
        try {  
            for (int i = 0; i < t0; i++) {  
                // 判断是否为汉字字符  
                if (java.lang.Character.toString(t1[i]).matches(  
                        "[\\u4E00-\\u9FA5]+")) {  
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);  
                    t4 += t2[0];  
                } else  
                    t4 += java.lang.Character.toString(t1[i]);  
            }  
            // System.out.println(t4);  
            return t4;  
        } catch (BadHanyuPinyinOutputFormatCombination e1) {  
            e1.printStackTrace();  
        }  
        return t4;  
    } 
    
    //获取拼音，不带音调
    public static String getPingYinNoTone(String src) {  
    	  
        char[] t1 = null;  
        t1 = src.toCharArray();  
        String[] t2 = new String[t1.length];  
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();  
          
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);  
        String t4 = "";  
        int t0 = t1.length;  
        try {  
            for (int i = 0; i < t0; i++) {  
                // 判断是否为汉字字符  
                if (java.lang.Character.toString(t1[i]).matches(  
                        "[\\u4E00-\\u9FA5]+")) {  
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);  
                    t4 += t2[0];  
                } else  
                    t4 += java.lang.Character.toString(t1[i]);  
            }  
            // System.out.println(t4);  
            return t4;  
        } catch (BadHanyuPinyinOutputFormatCombination e1) {  
            e1.printStackTrace();  
        }  
        return t4;  
    } 
  
    
    //返回中文的声母
    public static String getPinYinShengMu(String str) {  
    	  
        String convert = "";  
        for (int j = 0; j < str.length(); j++) {  
            char word = str.charAt(j);  
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);  
            if (pinyinArray != null) {  
                //如果获取得每个字的字符串第二个字符为h时，加上h，否则直接加首字母 
                if(pinyinArray[0].charAt(1)=='h'){
                	convert +=pinyinArray[0].charAt(0);
                	convert +='h';
                }
                else
                	convert +=pinyinArray[0].charAt(0);
            } else {  
                convert += word;  
            }  
        }  
        return convert;  
    }
    
    //获取中文的声调
    public static String getPinYinTone(String str) {  
  	  
       String pinyin=getPingYin(str);
       String tone="";
       for(int i=0;i<pinyin.length();i++){
    	   char item=pinyin.charAt(i);
    	   if(item=='1'||item=='2'||item=='3'||item=='4'){
    		   tone+=item;
    	   }
       }
       return tone;
    }  
   
    //获取中文的平仄
    public static String getPinYinPingZe(String str) {
    	String PZ="";
    	String tone=getPinYinTone(str);
    	for(int i=0;i<tone.length();i++){
    		char oneTone=tone.charAt(i);
    		if(oneTone=='1'){
    			PZ+="平";
    		}else
    			PZ+="仄";
    	}
    	return PZ;
    }
    //获取中文字符的最后一个字的韵母   
    public static String getPinYinLastYunMu(String str) {
    	String lastYunMu="";
    	String lastWord=str.substring(str.length()-1, str.length());
    	String lastWordPinyin=getPingYinNoTone(lastWord);
    	//char lastWord=str.charAt(str.length()-1);

    	String shengMu=getPinYinShengMu(lastWord);
    	lastYunMu=lastWordPinyin.replaceAll(shengMu, "");
    	
    	return lastYunMu;
    			
    	
    }
    
    
}  