package paper_review;
//import com.hankcs.hanlp.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WordsCut {
//    public static List<String> splitWords(String s1){
//        Stream<String> s2=HanLP.segment(s1).stream().map(str->str.word);
//        //ȥ���ı��ڵı�����
//        return s2.filter(s->!"`~!@#$^&*()=|{}':;',\\[\\].<>/?~��@#������&*��������|{}��������������'�������� "
//                .contains(s)).toList();
//    }
	public static List<String> splitWords(String s1) {  
	    List<String> words = new ArrayList<>();  
	    for (String word : s1.split("\\s+")) {  
	        if (!"`~!@#$^&*()=|{}':;',\\[\\].<>/?~��@#������&*��������|{}��������������'�������� ".contains(word)) {  
	            words.add(word);  
	        }  
	    }  
	    return words;  
	}

    public static List<String> Merge(List<String> s1, List<String> s2){
        List<String> str1=new ArrayList<>();
        List<String> str2=new ArrayList<>();
        //�ϲ�������
        str1.addAll(s1);
        str1.addAll(s2);
        //ɾȥ�����ظ��ķִ�
        str2=str1.stream().distinct().collect(Collectors.toList());
        return str2;
    }
}
