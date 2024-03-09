//Nate Adams
//3/4/24

//worked with Madison for the assignment

/*
 * Overall Feedback:
 * 	This is looking great! Everything seems to be working and in order.
 * 	It doesn't appear to me that there was an attempt at extra credit (besides squidward)
 * 	but otherwise pretty much everything appears to be functioning. The only thing that will 
 * 	drop some points will be the lack of solution code. There was an attempt but it doesn't quite work.
 * 	Overall well done!
 * 
 */

//import statements
package com.example.project;

import java.util.Scanner;

import java.util.ArrayList;

public class Cube {

    //I beseech thee, a prism molded to perfection,
	//crafted in accordance with the meticulous standards fit 
	//for the paramount of submission.

	//Thank you ser
    static String[][] Cube = 
                    {
                        {
                            "r", "r", "r",
                            "r", "r", "r",
                            "r", "r", "r",
                        },	{
                            "b", "b", "b",
                            "b", "b", "b",
                            "b", "b", "b",
                        },	{
                            "o", "o", "o",
                            "o", "o", "o",
                            "o", "o", "o",
                        },	{
                            "g", "g", "g", 
                            "g", "g", "g",
                            "g", "g", "g",
                        },	{
                            "y", "y", "y",
                            "y", "y", "y",
                            "y", "y", "y",
                        },	{
                            "w", "w", "w",
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
        
    //rotates counterclockwise
    static void f_rotation(String[][] Cube, int face){
            String temp = null;

            //top corners rotation
            temp = Cube[face][0];
            Cube[face][0] = Cube[face][6];
            Cube[face][6] = Cube[face][8];
            Cube[face][8] = Cube[face][2];
            Cube[face][2] = temp;

            //top insides rotations
            temp = Cube[face][1];
            Cube[face][1] = Cube[face][3];
            Cube[face][3] = Cube[face][7];
            Cube[face][7] = Cube[face][5];
            Cube[face][5] = temp;

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
            //edge rotations
            temp = Cube[face - 3][2];
            Cube[face - 3][2] = Cube[face + 2][2];
            Cube[face + 2][2] = Cube[face - 1][2];
            Cube[face - 1][2] = Cube[face + 1][2];
            Cube[face + 1][2] = temp;

            temp = Cube[face - 3][1];
            Cube[face - 3][1] = Cube[face + 2][1];
            Cube[face + 2][1] = Cube[face - 1][1];
            Cube[face - 1][1] = Cube[face + 1][1];
            Cube[face + 1][1] = temp;

            temp = Cube[face - 3][0];
            Cube[face - 3][0] = Cube[face + 2][0];
            Cube[face + 2][0] = Cube[face - 1][0];
            Cube[face - 1][0] = Cube[face + 1][0];
            Cube[face + 1][0] = temp;
    } 

    static void u_rotation(String [][] Cube, int face){
        String temp = null;  

        //top corners
        temp = Cube[face - 3][0];
        Cube[face - 3][0] = Cube[face - 3][2];
        Cube[face - 3][2] = Cube[face - 3][8];
        Cube[face - 3][8] = Cube[face - 3][6];
        Cube[face - 3][6] = temp;

        //top insides
        temp = Cube[face - 3][1];
        Cube[face - 3][1] = Cube[face - 3][5];
        Cube[face - 3][5] = Cube[face - 3][7];
        Cube[face - 3][7] = Cube[face - 3][3];
        Cube[face - 3][3] = temp;

        //edge rotations
        temp = Cube[face][0];
        Cube[face][0] = Cube[face + 1][2];
        Cube[face + 1][2] = Cube[face - 2][0];
        Cube[face - 2][0] = Cube[face + 2][6];
        Cube[face + 2][6] = temp;

        temp = Cube[face][1];
        Cube[face][1] = Cube[face + 1][5];
        Cube[face + 1][5] = Cube[face - 2][1];
        Cube[face - 2][1] = Cube[face + 2][3];
        Cube[face + 2][3] = temp;

        temp = Cube[face][2];
        Cube[face][2] = Cube[face + 1][8];
        Cube[face + 1][8] = Cube[face - 2][2];
        Cube[face - 2][2] = Cube[face + 2][0];
        Cube[face + 2][0] = temp;

    }

    static void r_rotation(String [][] Cube, int face){
        String temp = null;

        //side rotation
        temp = Cube[face + 1][0];
        Cube[face + 1][0] = Cube[face + 1][6];
        Cube[face + 1][6] = Cube[face + 1][8];
        Cube[face + 1][8] = Cube[face + 1][2];
        Cube[face + 1][2] = temp;

        //sides insides rotation
        temp = Cube[face + 1][1];
        Cube[face + 1][1] = Cube[face + 1][3];
        Cube[face + 1][3] = Cube[face + 1][7];
        Cube[face + 1][7] = Cube[face + 1][5];
        Cube[face + 1][5] = temp;

        //edge rotations
        temp = Cube[face][2];
        Cube[face][2] = Cube[face - 1][2];
        Cube[face - 1][2] = Cube[face - 2][6];
        Cube[face - 2][6] = Cube[face - 3][6];
        Cube[face - 3][6] = temp;
        
        temp = Cube[face][5];
        Cube[face][5] = Cube[face - 1][5];
        Cube[face - 1][5] = Cube[face - 2][3];
        Cube[face - 2][3] = Cube[face - 3][3];
        Cube[face - 3][3] = temp;

        temp = Cube[face][8];
        Cube[face][8] = Cube[face - 1][8];
        Cube[face - 1][8] = Cube[face - 2][0];
        Cube[face - 2][0] = Cube[face - 3][0];
        Cube[face - 3][0] = temp;
    }

    static void b_rotation(String [][] Cube, int face){
        String temp = null;

        //back corners
        temp = Cube[face - 2][0];
        Cube[face - 2][0] = Cube[face - 2][6];
        Cube[face - 2][6] = Cube[face - 2][8];
        Cube[face - 2][8] = Cube[face - 2][2];
        Cube[face - 2][2] = temp;	
        
        //back insides
        temp = Cube[face - 2][1];
        Cube[face - 2][1] = Cube[face - 2][3];
        Cube[face - 2][3] = Cube[face - 2][7];
        Cube[face - 2][7] = Cube[face - 2][5];
        Cube[face - 2][5] = temp;

        //edge rotation
        temp = Cube[face + 1][6];
        Cube[face + 1][6] = Cube[face - 1][6];
        Cube[face - 1][6] = Cube[face + 2][6];
        Cube[face + 2][6] = Cube[face - 3][6];
        Cube[face - 3][6] = temp;

        temp = Cube[face + 1][7];
        Cube[face + 1][7] = Cube[face - 1][7];
        Cube[face - 1][7] = Cube[face + 2][7];
        Cube[face + 2][7] = Cube[face - 3][7];
        Cube[face - 3][7] = temp;

        temp = Cube[face + 1][8];
        Cube[face + 1][8] = Cube[face - 1][8];
        Cube[face - 1][8] = Cube[face + 2][8];
        Cube[face + 2][8] = Cube[face - 3][8];
        Cube[face - 3][8] = temp;
    }
    
    static void l_rotation(String [][] Cube, int face){
        String temp = null;

        //side corners
        temp = Cube[face + 2][0];
        Cube[face + 2][0] = Cube[face + 2][6];
        Cube[face + 2][6] = Cube[face + 2][8];
        Cube[face + 2][8] = Cube[face + 2][2];
        Cube[face + 2][2] = temp;

        //side insides
        temp = Cube[face + 2][1];
        Cube[face + 2][1] = Cube[face + 2][3];
        Cube[face + 2][3] = Cube[face + 2][7];
        Cube[face + 2][7] = Cube[face + 2][5];
        Cube[face + 2][5] = temp;

        //edge rotations
        temp = Cube[face - 3][8];
        Cube[face - 3][8] = Cube[face - 2][8];
        Cube[face - 2][8] = Cube[face - 1][0];
        Cube[face - 1][0] = Cube[face][0];
        Cube[face][0] = temp;

        temp = Cube[face - 3][5];
        Cube[face - 3][5] = Cube[face - 2][5];
        Cube[face - 2][5] = Cube[face - 1][3];
        Cube[face - 1][3] = Cube[face][3];
        Cube[face][3] = temp;

        temp = Cube[face - 3][2];
        Cube[face - 3][2] = Cube[face - 2][2];
        Cube[face - 2][2] = Cube[face - 1][6];
        Cube[face - 1][6] = Cube[face][6];
        Cube[face][6] = temp;
    }

    static void d_rotation(String [][] Cube, int face){
        String temp = null;

        //bottom corners
        temp = Cube[face - 1][0];
        Cube[face - 1][0] = Cube[face - 1][6];
        Cube[face - 1][6] = Cube[face - 1][8];
        Cube[face - 1][8] = Cube[face - 1][2];
        Cube[face - 1][2] = temp;

        //edge rotation 
        temp = Cube[face][6];
        Cube[face][6] = Cube[face + 2][8];
        Cube[face + 2][8] = Cube[face - 2][6];
        Cube[face - 2][6] = Cube[face + 1][0];
        Cube[face + 1][0] = temp;

        temp = Cube[face][7];
        Cube[face][7] = Cube[face + 2][5];
        Cube[face + 2][5] = Cube[face - 2][7];
        Cube[face - 2][7] = Cube[face + 1][3];
        Cube[face + 1][3] = temp;

        temp = Cube[face][8];
        Cube[face][8] = Cube[face + 2][2];
        Cube[face + 2][2] = Cube[face - 2][8];
        Cube[face - 2][8] = Cube[face + 1][6];
        Cube[face + 1][6] = temp;
    }

	/*
	 *
	 * 	I will mention that it wouldn't necessarily be more efficient but it would be faster (for you)
	 * 	to simply run the regular rotations three times in a row to accomplish the prime rotations.
	 * 	Then r_prime_rotation() could just be r_rotation(); r_rotation(); r_rotation();
	 * 	Probably would have save you around 200 ish lines of code as well.
	 * 
	 */

    static void r_prime_rotation(String [][] Cube, int face){
        String temp = null;

        //side corners
        temp = Cube[face + 1][0];
        Cube[face + 1][0] = Cube[face + 1][2];
        Cube[face + 1][2] = Cube[face + 1][8];
        Cube[face + 1][8] = Cube[face + 1][6];
        Cube[face + 1][6] = temp;

        //side insides rotation
        temp = Cube[face + 1][1];
        Cube[face + 1][1] = Cube[face + 1][5];
        Cube[face + 1][5] = Cube[face + 1][7];
        Cube[face + 1][7] = Cube[face + 1][3];
        Cube[face + 1][3] = temp;

        //edge rotations
        temp = Cube[face - 3][0];
        Cube[face - 3][0] = Cube[face - 2][0];
        Cube[face - 2][0] = Cube[face - 1][8];
        Cube[face - 1][8] = Cube[face][8];
        Cube[face][8] = temp;

        temp = Cube[face - 3][3];
        Cube[face - 3][3] = Cube[face - 2][3];
        Cube[face - 2][3] = Cube[face - 1][5];
        Cube[face - 1][5] = Cube[face][5];
        Cube[face][5] = temp;

        temp = Cube[face - 3][6];
        Cube[face - 3][6] = Cube[face - 2][6];
        Cube[face - 2][6] = Cube[face - 1][2];
        Cube[face - 1][2] = Cube[face][2];
        Cube[face][2] = temp;
    }

    static void f_prime_rotation(String[][] Cube, int face){
        String temp = null;

        //face = 2 (green)
        temp = Cube[face][0];
        Cube[face][0] = Cube[face][2];
        Cube[face][2] = Cube[face][8];
        Cube[face][8] = Cube[face][6];
        Cube[face][6] = temp;

        temp = Cube[face][1];
        Cube[face][1] = Cube[face][5];
        Cube[face][5] = Cube[face][7];
        Cube[face][7] = Cube[face][3];
        Cube[face][3] = temp;

    /*
        * 		3 -> 6 -> 9
        * 		/\       \/
        * 		2    5    8
        * 		/\       \/
        * 		1 <- 4 <- 7
        * 
        * 	 counter clockwise Rotation
        *
        */

        //edge rotations
        temp = Cube[face - 3][2];
        Cube[face - 3][2] = Cube[face + 1][2];
        Cube[face + 1][2] = Cube[face -1][2];
        Cube[face - 1][2] = Cube[face + 2][2];
        Cube[face + 2][2] = temp;

        temp = Cube[face - 3][1];
        Cube[face - 3][1] = Cube[face + 1][1];
        Cube[face + 1][1] = Cube[face - 1][1];
        Cube[face - 1][1] = Cube[face + 2][1];
        Cube[face + 2][1] = temp;

        temp = Cube[face - 3][0];
        Cube[face - 3][0] = Cube[face + 1][0];
        Cube[face + 1][0] = Cube[face - 1][0];
        Cube[face  - 1][0] = Cube[face + 2][0];
        Cube[face + 2][0] = temp;
    }
    
    static void u_prime_rotation(String[][] Cube, int face){
        String temp = null;

        //top corners
        temp = Cube[face - 3][0];
        Cube[face - 3][0] = Cube[face - 3][6];
        Cube[face - 3][6] = Cube[face - 3][8];
        Cube[face - 3][8] = Cube[face - 3][2];
        Cube[face - 3][2] = temp;

        //top insides
        temp = Cube[face - 3][1];
        Cube[face - 3][1] = Cube[face - 3][3];
        Cube[face - 3][3] = Cube[face - 3][7];
        Cube[face - 3][7] = Cube[face - 3][5];
        Cube[face - 3][5] = temp;

        //edge rotation
        temp = Cube[face][0];
        Cube[face][0] = Cube[face + 2][6];
        Cube[face + 2][6] = Cube[face - 2][0];
        Cube[face - 2][0] = Cube[face + 1][2];
        Cube[face + 1][2] = temp;

        temp = Cube[face][1];
        Cube[face][1] = Cube[face + 2][3];
        Cube[face + 2][3] = Cube[face - 2][1];
        Cube[face - 2][1] = Cube[face + 1][5];
        Cube[face + 1][5] = temp;

        temp = Cube[face][2];
        Cube[face][2] = Cube[face + 2][0];
        Cube[face + 2][0] = Cube[face - 2][2];
        Cube[face - 2][2] = Cube[face + 1][8];
        Cube[face + 1][8] = temp;
    }

    static void d_prime_rotation(String [][] Cube, int face){
        String temp = null;

        //bottom corners
        temp = Cube[face - 1][0];
        Cube[face - 1][0] = Cube[face - 1][2];
        Cube[face - 1][2] = Cube[face - 1][8];
        Cube[face - 1][8] = Cube[face - 1][6];
        Cube[face - 1][6] = temp;

        //bottom insides
        temp = Cube[face - 1][1];
        Cube[face - 1][1] = Cube[face - 1][5];
        Cube[face - 1][5] = Cube[face - 1][7];
        Cube[face - 1][7] = Cube[face - 1][3];
        Cube[face - 1][3] = temp;

        //edge rotations
        temp = Cube[face + 1][0];
        Cube[face + 1][0] = Cube[face - 2][6];
        Cube[face - 2][6] = Cube[face + 2][8];
        Cube[face + 2][8] = Cube[face][6];
        Cube[face][6] = temp;

        temp = Cube[face + 1][3];
        Cube[face + 1][3] = Cube[face - 2][7];
        Cube[face - 2][7] = Cube[face + 2][5];
        Cube[face + 2][5] = Cube[face][7];
        Cube[face][7] = temp;

        temp = Cube[face + 1][6];
        Cube[face + 1][6] = Cube[face - 2][8];
        Cube[face - 2][8] = Cube[face + 2][2];
        Cube[face + 2][2] = Cube[face][8];
        Cube[face][8] = temp;
    }

    static void b_prime_rotation(String [][] Cube, int face){
        String temp = null;

        //back corners
        temp = Cube[face - 2][0];
        Cube[face - 2][0] = Cube[face - 2][2];
        Cube[face - 2][2] = Cube[face - 2][8];
        Cube[face - 2][8] = Cube[face - 2][6];
        Cube[face - 2][6] = temp;

        //back insides
        temp = Cube[face - 2][1];
        Cube[face - 2][1] = Cube[face - 2][5];
        Cube[face - 2][5] = Cube[face - 2][7];
        Cube[face - 2][7] = Cube[face - 2][3];
        Cube[face - 2][3] = temp;

        //edge rotations
        temp = Cube[face + 2][6];
        Cube[face + 2][6] = Cube[face - 1][6];
        Cube[face - 1][6] = Cube[face + 1][6];
        Cube[face + 1][6] = Cube[face - 3][6];
        Cube[face - 3][6] = temp;

        temp = Cube[face + 2][7];
        Cube[face + 2][7] = Cube[face - 1][7];
        Cube[face - 1][7] = Cube[face + 1][7];
        Cube[face + 1][7] = Cube[face - 3][7];
        Cube[face - 3][7] = temp;

        temp = Cube[face + 2][8];
        Cube[face + 2][8] = Cube[face - 1][8];
        Cube[face - 1][8] = Cube[face + 1][8];
        Cube[face + 1][8] = Cube[face - 3][8];
        Cube[face - 3][8] = temp;
    }

    static void l_prime_rotation(String [][] Cube, int face){
        String temp = null;

        //side corners
        temp = Cube[face + 2][0];
        Cube[face + 2][0] = Cube[face + 2][2];
        Cube[face + 2][2] = Cube[face + 2][8];
        Cube[face + 2][8] = Cube[face + 2][6];
        Cube[face + 2][6] = temp;

        //side insides
        temp = Cube[face + 2][1];
        Cube[face + 2][1] = Cube[face + 2][5];
        Cube[face + 2][5] = Cube[face + 2][7];
        Cube[face + 2][7] = Cube[face + 2][3];
        Cube[face + 2][3] = temp;

        //edge rotations
        temp = Cube[face - 1][0];
        Cube[face - 1][0] = Cube[face - 2][8];
        Cube[face - 2][8] = Cube[face - 3][8];
        Cube[face - 3][8] = Cube[face][0];
        Cube[face][0] = temp;

        temp = Cube[face - 1][3];
        Cube[face - 1][3] = Cube[face - 2][5];
        Cube[face - 2][5] = Cube[face - 3][5];
        Cube[face - 3][5] = Cube[face][3];
        Cube[face][3] = temp;

        temp = Cube[face - 1][6];
        Cube[face - 1][6] = Cube[face - 2][2];
        Cube[face - 2][2] = Cube[face - 3][2];
        Cube[face - 3][2] = Cube[face][6];
        Cube[face][6] = temp;
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

    public static void moveCube(String direction, String[][] numCube){
        //assuming 3 (green) is front
        switch(direction){
            case "U":
                u_rotation(numCube, 3);
                break;
            case "D":
                d_rotation(numCube, 3);
                break;
            case "F":
                f_rotation(numCube, 3);
                break;
            case "B":
                b_rotation(numCube, 3);
                break;
            case "L":
                l_rotation(numCube, 3);
                break;
            case "R":
                r_rotation(numCube, 3);
                break;
            case "U'":
                u_prime_rotation(numCube, 3);
                break;
            case "D'":
                d_prime_rotation(numCube, 3);
                break;
            case "F'":
                f_prime_rotation(numCube, 3);
                break;
            case "B'":
                b_prime_rotation(numCube, 3);
                break;
            case "L'":
                l_prime_rotation(numCube, 3);
                break;
            case "R'":
                r_prime_rotation(numCube, 3);
                break;
        }
    }
    static String[][] Squidward ={
					{"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣠⣤⣤⣄⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"},
					{"⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠤⠖⠊⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠙⠲⢤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"},
					{"⠀⠀⠀⠀⠀⠀⠀⡤⠊⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀"},
					{"⠀⠀⠀⠀⠀⠀⡜⠀⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢢⠀⠀⠀⠀⠀⢳⠀⠀⠀⠀⠀⠀⠀⠀"},
					{"⠀⠀⠀⠀⠀⣸⠁⠀⠀⠀⠀⠀⠀⠀⠱⡀⠀⠀⠀⠀⠀⠀⠀⡀⠈⠀⡀⠀⠀⠀⠈⡇⠀⠀⠀⠀⠀⠀⠀"},
					{"⠀⠀⠀⠀⠀⡏⠀⠀⠀⠀⠀⠀⠀⠀⡰⠁⠀⠀⠀⠀⠀⠀⠀⠘⡆⡜⠁⠀⠀⠀⠀⢧⡀⠀⠀⠀⠀⠀⠀"},
					{"⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠸⡀⠀⠀⠀⠀⠀⣀⣤⡂⠀⠇⠱⠀⡀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀"},
					{"⠀⠀⠀⠀⠀⢇⠀⠀⠀⠀⠀⠀⠀⠀⠈⢄⡀⢠⣟⢭⣥⣤⠽⡆⠀⡶⣊⣉⣲⣤⢀⡞⠀⠀⠀⠀⠀⠀⠀"},
					{"⠀⠀⠀⠀⠀⠘⣆⠀⠀⠀⠀⠀⠀⡀⠀⠐⠂⠘⠄⣈⣙⡡⡴⠀⠀⠙⣄⠙⣛⠜⠘⣆⠀⠀⠀⠀⠀⠀⠀"},
					{"⠀⠀⠀⠀⠀⠀⠈⢦⡀⠀⠀⠀⢸⠁⠀⠀⠀⠀⠀⠀⠄⠊⠀⠀⠀⠀⡸⠛⠀⠀⠀⢸⠆⠀⠀⠀⠀⠀⠀"},
					{"⠀⠀⠀⠀⠀⠀⠀⠀⠈⠓⠦⢄⣘⣄⠀⠀⠀⠀⠀⠀⠀⡠⠀⠀⠀⠀⣇⡀⠀⠀⣠⠎⠀⠀⠀⠀⠀⠀⠀"},
					{"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⠁⠈⡟⠒⠲⣄⠀⠀⡰⠇⠖⢄⠀⠀⡹⡇⢀⠎⠁⠀⠀⠀⠀⠀⠀⠀⠀"},
					{"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡇⠀⠀⡇⠀⠀⠹⠀⡞⠀⠀⢀⠤⣍⠭⡀⢱⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"},
					{"⠀⠀⠀⠀⠀⠀⢀⣀⣀⣠⠞⠀⠀⢠⡇⠀⠀⠀⠀⠁⠀⢴⠥⠤⠦⠦⡼⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"},
					{"⣀⣤⣴⣶⣿⣿⡟⠁⠀⠋⠀⠀⠀⢸⠁⠀⠀⠀⠀⠀⠀⠀⠑⣠⢤⠐⠁⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"},
					{"⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⢸⡀⠀⠀⠀⠀⠀⠀⠀⠀⠬⠥⣄⠀⠀⠈⠲⡄⠀⠀⠀⠀⠀⠀⠀⠀"},
					{"⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠙⠦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠈⢳⠀⠀⢀⣿⡀⠀⠀⠀⠀⠀⠀⠀"},
					{"⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠒⠦⠤⢤⣄⣀⣠⠤⢿⣶⣶⣿⣿⣿⣶⣤⡀⠀⠀⠀⠀"},
					{"⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡼⠁⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣄⠀⠀⠀"},
					{"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣤⣤⣀⣀⣀⣀⣀⣀⣀⣤⣤⣤⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀"},
	};

	//This is easily worth an extra 0.5 a point for sure. 
    public static void main(final String[] args) {

		//I never do it in my examples, but make sure in the future you close your scanner when you're done.
        Scanner user_input = new Scanner(System.in);

		ArrayList <String> moves = new ArrayList<String>();
		//It appears you never actually use this.

        System.out.println("Insert Upper case letter or letter with ' for Prime or q for quit");
        System.out.println();
		Boolean quit = true;
        while(quit){
            System.out.println("Please enter the move you would like to perform: ");
            String input = user_input.nextLine();

			/*
			 * 
			 * It would be a good idea to modify the input in some way to make it fit your 
			 * requirements. For example using input.toUpperCase() so that you could accept 
			 * lowercase commands.
			 * 
			 */

            moveCube(input.substring(0), Cube);
            
            //prints solution to each possibility

			/*
			 * 
			 * This isn't quite a true solution. It's the solution to the lates move yes but not to the cube.
			 * If I make three U moves in a row it will still say U' is the solution. Even though U would be the soln.
			 * 
			 */

            switch(input){
                case "U":
                    System.out.println("Solution: U'");
					moves.add("U");
                    break;
                case "D":
                    System.out.println("Solution: D'");
					moves.add("D");
                    break;
                case "R":	
                    System.out.println("Solution: R'");
					moves.add("R");
                    break;
                case "L":
                    System.out.println("Solution: L'");
					moves.add("L");
                    break;
                case "F":
                    System.out.println("Solution: F'");
					moves.add("F");
                    break;
                case "B":
                    System.out.println("Solution: B'");
					moves.add("B");
                    break;
                case "U'":
                    System.out.println("Solution: U");
					moves.add("U'");
                    break;
                case "D'":
                    System.out.println("Solution: D");
					moves.add("D'");
                    break;
                case "R'":
                    System.out.println("Solution: R");
					moves.add("R'");
                    break;
                case "L'":
                    System.out.println("Solution: L");
					moves.add("L'");
                    break;
                case "F'":
                    System.out.println("Solution: F");
					moves.add("F'");
                    break;
                case "B'":
                    System.out.println("Solution: B");
					moves.add("B'");
                    break;
				case "q":

					// this is more of a style critique, but wouldn't quit be true when you want to quit?
					// try to consider how a statement "reads" when naming variables.
					quit = false;
					//litterally cause im bored, I apologize... but squidward :)
					for (String[] row : Squidward) {
						for (String element : row) {
							System.out.print(element);
						}
						System.out.println();
					}
					//hail squidward
					break;
                default:
                    System.out.println("That is not a valid move please choose from: ");
                    System.out.println("U D R L F B U' D' R' L' F' B' or q");
            }
            //print(numCube);
            System.out.println("--------------------------------");
            printCube(Cube);
            System.out.println("--------------------------------");
        }
		/*for (int i = moves.size() - 1; i>=0; i--){
		 */
		}

    }

//nice ammount of lines I got here 😏

//Not bad, fairly compact considering the approach.
