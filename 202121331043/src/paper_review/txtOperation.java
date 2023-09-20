package paper_review;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static paper_review.WordsCut.*;

public class txtOperation {
    public static List<String> Read(String path) throws IOException {
        List<String> article = new ArrayList<String>();
        try {
            //打开path路径的文件
            File read = new File(path);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(read));
            BufferedReader r = new BufferedReader(reader);
            String line = r.readLine();
            //循环读取每一行的文字并加入到表中
            while (line != null) {
                article.add(line);
                line = r.readLine();
            }
        } catch (IOException e) {
            System.out.println("文件打开失败，请检查文件路径是否正确");
        }
        return article;
    }



    public static void Write(String path,float result) throws IOException {
        FileWriter write=new FileWriter(path);
        //将结果写入到指定的文件中
        write.write("两篇文章的相似度为：");
        write.write(String.format("%.2f", result));
        write.flush();
        write.close();
    }

    public static int[] Counter(List<String> split_article,List<String> merge){
        int number[]=new int[merge.size()];
        //统计文章中各个词的频率
        for(int i=0;i< merge.size();i++){
            number[i]=Collections.frequency(split_article, merge.get(i));
        }
        return number;
    }


}
