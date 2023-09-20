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
            System.out.println("参数个数有误");
            return;
        }
        for(int i=0;i<3;i++){
            if(!args[i].endsWith("txt")){
                System.out.println("参数格式有误");
                return;
            }
        }
        String path1= "";
        String path2= "";
        String path3= "";
        //获取用户输入的地址
        path1=args[0];
        path2=args[1];
        path3=args[2];
        List<String> article1=Read(path1);
        List<String> article2=Read(path2);
        List<String> article3=new ArrayList<>();
        //分词、合并
        article1=splitWords(article1.toString());
        article2=splitWords(article2.toString());
        article3=Merge(article1,article2);
        //统计词频
        int[] n1 = Counter(article1,article3);
        int[] n2 = Counter(article2,article3);
        //输出结果
        System.out.print("两篇文章的相似度为：");
        System.out.println(String.format("%.2f", getSimilarity(n1,n2)));
        Write(path3,getSimilarity(n1,n2));
    }
}
