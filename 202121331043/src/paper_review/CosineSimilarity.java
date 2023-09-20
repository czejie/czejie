package paper_review;
public class CosineSimilarity {
    public static float getSimilarity(int[] number1,int[] number2){
        float square1=0,square2=0,product=0;
        for(int i=0;i<number1.length;i++){
            //两个向量的点乘
            product+=number1[i]*number2[i];
            //分别计算两个向量的平方和
            square1 += (float) Math.pow(number1[i], 2);
            square2 += (float) Math.pow(number2[i], 2);
        }
        //返回两个向量的余弦值
        return (float) (product / (Math.sqrt(square1) * Math.sqrt(square2)));
    }
}
