package paper_review;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static paper_review.WordsCut.*;

public class txtOperation {
    public static List<String> Read(String path) throws IOException {
        List<String> article = new ArrayList<String>();
        try {
            //��path·�����ļ�
            File read = new File(path);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(read));
            BufferedReader r = new BufferedReader(reader);
            String line = r.readLine();
            //ѭ����ȡÿһ�е����ֲ����뵽����
            while (line != null) {
                article.add(line);
                line = r.readLine();
            }
        } catch (IOException e) {
            System.out.println("�ļ���ʧ�ܣ������ļ�·���Ƿ���ȷ");
        }
        return article;
    }



    public static void Write(String path,float result) throws IOException {
        FileWriter write=new FileWriter(path);
        //�����д�뵽ָ�����ļ���
        write.write("��ƪ���µ����ƶ�Ϊ��");
        write.write(String.format("%.2f", result));
        write.flush();
        write.close();
    }

    public static int[] Counter(List<String> split_article,List<String> merge){
        int number[]=new int[merge.size()];
        //ͳ�������и����ʵ�Ƶ��
        for(int i=0;i< merge.size();i++){
            number[i]=Collections.frequency(split_article, merge.get(i));
        }
        return number;
    }


}
