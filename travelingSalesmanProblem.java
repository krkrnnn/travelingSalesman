//巡回セールスマン問題
import java.util.*;
public class travelingSalesmanProblem{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int touwnnumber = 0;//都市数
	double distance = 0;//移動した距離の合計
	int michinum = 1;//道の総数
	double mindistance = Double.MAX_VALUE; //最小の距離
	int townnumber = sc.nextInt();
	double[][] town = new double[townnumber][2];//都市の座標の情報を入れる配列
	for(int i = 0; i < townnumber; i++){
	    town[i][0] = sc.nextDouble();
	    town[i][1] = sc.nextDouble();
	}

	//全ての道順の総数を数える
	for(int i = 1; i <= townnumber; i++){
	    michinum = michinum*i;
	}
	//それぞれの都市間の情報を持っている配列
	double[][] michiinfo = new double[townnumber][townnumber];
    
	//都市間の距離を計算してみる
	for(int i = 0; i < townnumber; i++){
	    for(int j = 0; j < townnumber; j++){
		double dis = (town[i][0]-town[j][0])*(town[i][0]-town[j][0]) + (town[i][1]-town[j][1])*(town[i][1]-town[j][1]);
		michiinfo[i][j] = Math.sqrt(dis);
		//System.out.println(michiinfo[i][j]);
	    }
	}

	//これだと全ての道順を重複して足している
	for(int i = 0; i< townnumber; i++){
	    for(int j = i+1; j < townnumber; j++){
		for(int k = j+1; k < townnumber; k++){
		    for(int l = k+1; l < townnumber; l++){
			for(int m = l+1; m < townnumber; m++){
			    distance =  michiinfo[i][j]+ michiinfo[j][k] + michiinfo[k][l] + michiinfo[l][m] + michiinfo[m][i];
			    if(distance < mindistance && distance != 0){
				mindistance = distance;
			    }
			}
		    }
		}
	    }
	}
	System.out.println(mindistance);
    }
}
