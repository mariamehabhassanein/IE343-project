# IE343-project
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
		int p=3;

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
this is what i wrote there are some commented lines because there were errors that i couldn't figure out but i tried as much as i can
the code prints the distances and when i set p it reports distances after the input p so we can determine the distances
i couldn't figure out how to add the the array lists because it keeps giving me an error and I can't figure the connection 
the sode i wrote is not complete and needs some copmletion but for the question i can add some of the results that i get after running the program
1)1067.8969429977963  first 3 lines are the distances after p p is set to 3 facility is 5
1490.1717719218375
1825.2832688505468
[365.7097784470703, 767.5589059623029, 1067.8969429977963, 1490.1717719218375, 1825.2832688505468] distance array
7327300 execution time

2)881.5109520146658 first 2 lines are the distances after p p is set to 3 facility is 4
1107.6211096753912
[241.55877664533907, 614.315208618505, 881.5109520146658, 1107.6211096753912] distance array
9724700 execution time

3)1080.7584674946681 first line is the distances after p p is set to 3 facility is 3
[295.6355832563478, 731.0730778722454, 1080.7584674946681] distance array
6512800 execution time

4)347.68840694097383 first 3 lines are the distances after p p is set to 1 facility is 3
681.3398360260057
1108.4935743534536
[347.68840694097383, 681.3398360260057, 1108.4935743534536] distance array 
6754500 execution time

5)262.5551188603006 first 5 lines are the distances after p p is set to 1 facility is 5
641.7836574798437
897.6573924214974
1376.0545066638406
1625.8739975282579
[262.5551188603006, 641.7836574798437, 897.6573924214974, 1376.0545066638406, 1625.8739975282579] distance array
11728600 execution time





