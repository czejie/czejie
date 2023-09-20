package paper_review;
import org.w3c.dom.css.Counter;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static paper_review.WordsCut.*;
import static paper_review.txtOperation.*;
import static paper_review.CosineSimilarity.*;

public class main {
    public static void main(String[] args) throws IOException {
        if(args.length!=3){
            System.out.println("������������");
            return;
        }
        for(int i=0;i<3;i++){
            if(!args[i].endsWith("txt")){
                System.out.println("������ʽ����");
                return;
            }
        }
        String path1= "";
        String path2= "";
        String path3= "";
        //��ȡ�û�����ĵ�ַ
        path1=args[0];
        path2=args[1];
        path3=args[2];
        List<String> article1=Read(path1);
        List<String> article2=Read(path2);
        List<String> article3=new ArrayList<>();
        //�ִʡ��ϲ�
        article1=splitWords(article1.toString());
        article2=splitWords(article2.toString());
        article3=Merge(article1,article2);
        //ͳ�ƴ�Ƶ
        int[] n1 = Counter(article1,article3);
        int[] n2 = Counter(article2,article3);
        //������
        System.out.print("��ƪ���µ����ƶ�Ϊ��");
        System.out.println(String.format("%.2f", getSimilarity(n1,n2)));
        Write(path3,getSimilarity(n1,n2));
    }
}
