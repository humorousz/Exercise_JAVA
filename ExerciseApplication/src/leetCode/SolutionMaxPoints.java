package leetCode;

/**
 * Created by zhangzhiquan on 2017/7/12.
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * https://www.nowcoder.com/practice/bfc691e0100441cdb8ec153f32540be2?tpId=46&tqId=29032&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 */

public class SolutionMaxPoints {

    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0)
            return 0;
        if(points.length < 2)
            return 1;
        int max = 2;
        int tmp ;
        int num ;
        for(int i = 0;i < points.length;i++){
            num = 0;
            tmp = 1; //此时一个点
            for(int j = i+1;j < points.length;j++){
                int ABX = points[i].x - points[j].x;
                int ABY = points[i].y - points[j].y;
                if(ABX == 0 && ABY == 0){
                    num ++;
                }else {
                    tmp ++; //此时两个点
                    for(int k = j+1;k<points.length;k++){
                        int BCX = points[j].x - points[k].x;
                        int BCY = points[j].y - points[k].y;
                        if(ABX * BCY == ABY * BCX){ //巧妙的比较斜率方法，方式除以0
                            tmp ++; //此时第三个点
                        }
                    }
                }
                if(max < (tmp + num)){
                    max = tmp + num;
                }
                tmp = 1; //还原
            }
        }
        return max ;
    }

    public static void main(String[] args){
        Point p = new Point(0,0);
        Point p2 = new Point(0,1);
        Point[] points = new Point[]{p,p2};
        SolutionMaxPoints solutionMaxPoints = new SolutionMaxPoints();
        System.out.println(solutionMaxPoints.maxPoints(points));
    }

    static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
}