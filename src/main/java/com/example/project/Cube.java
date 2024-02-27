package com.example.project;

public class Cube {

	//A Cube in the correct format for the ultimate submission
	static String[][] myCube = 
				    {
				        {
				            "r", "r", "r", //front
				            "r", "r", "r",
				            "r", "r", "r",
				        },	{
				            "b", "b", "b", //top
				            "b", "b", "b",
				            "b", "b", "b",
				        },	{
				            "o", "o", "o", //back
				            "o", "o", "o",
				            "o", "o", "o",
				        },	{
				            "g", "g", "g", //bottom
				            "g", "g", "g",
				            "g", "g", "g",
				        },	{
				            "y", "y", "y", //right
				            "y", "y", "y",
				            "y", "y", "y",
				        },	{
				            "w", "w", "w", //left
				            "w", "w", "w",
				            "w", "w", "w",
				        },
				    };
	
						
	//A Cube with numbers to test rotation.
	static String[][] numCube = 
				    {
				        {
				            "r1", "r2", "r3",
				            "r4", "r5", "r6",
				            "r7", "r8", "r9",
				        },	{
				            "b1", "b2", "b3",
				            "b4", "b5", "b6",
				            "b7", "b8", "b9",
				        },	{
				            "o1", "o2", "o3",
				            "o4", "o5", "o6",
				            "o7", "o8", "o9",
				        },	{
				            "g1", "g2", "g3", 
				            "g4", "g5", "g6",
				            "g7", "g8", "g9",
				        },	{
				            "y1", "y2", "y3",
				            "y4", "y5", "y6",
				            "y7", "y8", "y9",
				        },	{
				            "w1", "w2", "w3",
				            "w4", "w5", "w6",
				            "w7", "w8", "w9",
				        },
				    };
	

	static void rotateFace(String[][] Cube, int face){
	        String Temp = null;
	        Temp = Cube[face][0];
	        Cube[face][0] = Cube[face][6];
	        Cube[face][6] = Cube[face][8];
	        Cube[face][8] = Cube[face][2];
	        Cube[face][2] = Temp;
	        Temp = Cube[face][1];
	        Cube[face][1] = Cube[face][3];
	        Cube[face][3] = Cube[face][7];
	        Cube[face][7] = Cube[face][5];
	        Cube[face][5] = Temp;

		/*
		 * 		1 -> 2 -> 3
		 * 		/\       \/
		 * 		4    5    6
		 * 		/\       \/
		 * 		7 <- 8 <- 9
		 * 
		 * 	 Clockwise Rotation
		 *
		 */

	} 

	static void printCube(String[][] theCube) {
		for (int x = 0; x < 6; x++){
	        	int z = -1;
	        	for (int y = 0; y < 3; y++){
		                z++;
		                System.out.print(theCube[x][z]);
		                System.out.print("|"); 
		                z++;
		                System.out.print(theCube[x][z]);
		                System.out.print("|");  
		                z++;
		                System.out.print(theCube[x][z]);
		                System.out.println("");    
	                
	            	}
	        	System.out.println("");    
		}
	}

	
	public static void main(final String[] args) {

		/*
		 * Uncomment the lines down below to begin testing the starter code.
		 */

		 printCube(myCube);

		 rotateFace(numCube, 0);

		 printCube(numCube);
	
	}

}

/*
 * How I want to attempt the cube assignment:
 * 
 * If I have a face movement, assign the movement of each face as u,d,l,r,b,f as moving
 * the faces on those sides. If that is successful, can move deeper to storage of the cube's
 * movements and finish the assignment well ish.
 * Given is the movement of just one face, must assgn the movement of that face onto 4 other
 * faces, using array manipulation and reassignment.
 */