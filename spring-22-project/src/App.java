import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

import medianProblem.*;
public class App {
	public static void main(String[] args){
		long startTime = System.nanoTime();
		Operators operator = new Operators();
		double[][] facs_coordinates = operator.createDistanceMatrix(5,2);
		double[][] points_coordinates = operator.createDistanceMatrix(20,2);
		Facility[] facs = new Facility[5];
		Point[] points = new Point [20];
		for (int i=0; i<facs.length;i++){
			Facility f1 = new Facility(i, facs_coordinates[i][0], facs_coordinates[i][1], 20*Math.random()+50);
			facs[i] = f1;
		}
		for (int i=0; i<points.length;i++){
			Point p1 = new Point (i, points_coordinates[i][0], points_coordinates[i][1], 2*Math.random()+1);
			points[i] = p1;
		}
		double[][] distanceMatrix = operator.distanceMatrix(facs, points);
		ArrayList<Facility> openedFacilities = new ArrayList<>();
		ArrayList<Point> unassignedFacilities = new ArrayList<>();
		ArrayList<ArrayList<Point>> assignmentList = new ArrayList<>();
		int p=1;

		while(openedFacilities.size()!= p) { 
			double [] dist= new double [facs.length];
			int[] index=new int [unassignedFacilities.size()];
			int[][] mindist= operator.findMinIndex(distanceMatrix); // to find the minimum distance 
			double totaldis=0;
			for(int i=0;i<facs.length;i++) {
				for(int j=0;j<points.length;j++) {
					totaldis+=distanceMatrix[i][j]; // adds the ditance so i can have my total distances
				}
				dist[i]=totaldis;
			}
			Arrays.sort(dist);
			double mindistance=dist[0];
			for(int i=0;i<points.length;i++) {
				//unassignedFacilities.add(i,dist[i]); // supposed to add all distances to unassigned
			}

			if(!openedFacilities.contains(mindistance)) {
				for(int i=0;i<openedFacilities.size();i++) {
					unassignedFacilities.remove(mindistance); // supposed to remove the minimum distance from unassigned
					//openedFacilities.add(mindistance);  // and place it in opened but there is a problem with add

				}

			}
			for(int i=p;i<=dist.length;i++) {
				System.out.println(dist[i-1]); // reports the distances 
			}


			System.out.println(Arrays.toString(dist)); // reports all distances
			long endTime   = System.nanoTime();
			long totalTime = endTime - startTime;
			System.out.println(totalTime);

			break;
		}

	}

}









