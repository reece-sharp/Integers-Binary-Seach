import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    public static PApplet pApplet;

    // listSize can either be same or = to highestNum

    // these bing doubles allow for 9 to be a value when lsit size is 3 and highetsNum is 10
    // otherwise, section woudl just equal teh int 3 or doubel 3.0 (bc int/int = int w/ .0)
    // if section is just 3, then (int)3*0.99 woudl equal 2 meaning teh higehst possible number woudl only be 8
        // only relvent to the for loop in the draw method
    double listSize = 3; // only use interger value for now
    double highestNum = 100; // actuall higest possible number is this -1
    int targetV = (int)(Math.random()*highestNum); // a number between 0 & highest number -1 (if HN = 20, optiosn = 0, 1, 2, ... 18, 19)
    private ArrayList<Integer> arrL;
    boolean nArr = true; // this is a new array
    boolean newRan = false; // false bc i just want to start with tha random target created on line 11
    // if i wanted i coudl make it true and then just declare it above and then woudl initlize it inside teh if(newRan) statment --. if i did that must make chnage in set up code too

    boolean printS = true;
    char keyP = 'z'; // this varible keeps track of what key was pressed and is used when priniting "new arry created" etc.

    public Main(){ // need to inatiate the variable in thsi consturcter
        pApplet = this;
    }
    public static void main(String[] args){
        PApplet.main("Main"); // the name of our class
    }

    public void settings(){
        size(10, 10); /* setting up a canvas */
    }

    public void setup() { // TO DO; CREATE IMST FOR TEH X AND Y VALES
        /*arrL = new ArrayList<>();

        // is the highest number is 100 and there are ten values in list,
        // i want first valuse to be random from 0 to 10 (excluding 10)
        int section = highestNum/listSize; // if follows ^^, then this woudl equal 10
        // this is a random value between 0 and section; if ^^ ran between 0 & 10

        for(int i =0; i < listSize; i++){
            // first param = the index  --> we are adding new valeus at each index
            // 2nd param = random value
                // firts take random value between 0 & section (whcih is teh higehst valeu/number of values in list)
                // then add section tiem teh index value
            // ex --> higehst value = 100 & list size = 4
                //section=25
                // so for i=0, @ index0, it woudl add in a random value from 0 to 25 (exluding 25)
                // at i=1, it woudl first find a new random value from 0 to 25 then add 25 to that number
                    // this ensures that teh numbers stay in assending order
            arrL.add(i, (int)(Math.random()*section) + i*section); // the foirst element is 0
        }


        if(binarySearch(targetV) == -1){ // this means its not in teh arrayList
            System.out.println(); // just a blank line
            System.out.println("Target Value " + targetV+" was not found in the ArrayList " +arrL +" :(");
        }else{
            System.out.println();
            System.out.println("Target Value " + targetV+" was found in the ArrayList " +arrL +" at index "+ binarySearch(targetV)+ ":)" );
        }
        /* saving these b/c it is another way to print out the wanted information
            System.out.println("Target Value: " + targetV); // prints out target
            System.out.println("Target @ Index: " +binarySearch(targetV)); // prints oit index of target
            System.out.println("Random ArrayList: " + arrL);
        */
    } // if the code is in setup, it only happens once --> if its in draw, it happedn each time next==true

    // THIS METHOD IS CURRENTLY UNNECESSARY
    public void draw() { // has all teh panle objects in it
        if(printS){
            if(newRan){ // get a new random target value is i press key t or n
                targetV = (int)(Math.random()*highestNum);
                newRan = false;
            }
            if (nArr) { // if press
                arrL = new ArrayList<>();

                // is the highest number is 100 and there are ten values in list,
                // i want first valuse to be random from 0 to 10 (excluding 10)
                double section = highestNum/listSize; // if follows ^^, then this woudl equal 10
                // this is a random value between 0 and section; if ^^ ran between 0 & 10

                for(int i =0; i < listSize; i++){
                    // first param = the index  --> we are adding new valeus at each index
                    // 2nd param = random value
                    // firts take random value between 0 & section (whcih is teh higehst valeu/number of values in list)
                    // then add section tiem teh index value
                    // ex --> higehst value = 100 & list size = 4
                    //section=25
                    // so for i=0, @ index0, it woudl add in a random value from 0 to 25 (exluding 25)
                    // at i=1, it woudl first find a new random value from 0 to 25 then add 25 to that number
                    // this ensures that teh numbers stay in assending order
                    arrL.add(i, (int)(Math.random()*section) + i*(int)section); // the foirst element is 0
                }
                nArr = !nArr; // toggle flag so now its falsue untill key pressed again
            }

            // PRINITING TO CONSOLE
            System.out.println(); // just a blank line
            if(keyP == 'a'){
                System.out.println("NEW ARRAY CREATED");
            }else if(keyP == 't'){
                System.out.println("NEW TARGET CREATED");
            }else if (keyP =='n'){
                System.out.println("NEW TARGET & ARRAY CREATED");
            }
            if(binarySearch(targetV) == -1){ // this means its not in teh arrayList
                System.out.println("Random ArrayList: " + arrL);
                System.out.println("Target Value: " + targetV);
                System.out.println("NOT FOUND");
            }else{
                System.out.println("Random ArrayList: " + arrL);
                System.out.println("Target Value: " + targetV);
                System.out.println("FOUND @ INDEX: "+ binarySearch(targetV));
            }
        /* saving these b/c it is another way to print out the wanted information
            System.out.println("Target Value " + targetV+" was found in the ArrayList " +arrL +" at index "+ binarySearch(targetV)+ ":)" );
            System.out.println("Target Value " + targetV+" was not found in the ArrayList " +arrL +" :(");
        */

            printS = !printS; // set ist false so doenst continousl print
        }

    }

    private int binarySearch(int target){
        int bottom = 0;
        int top = arrL.size()-1;

        while (bottom <=top){

            int center = (bottom+top)/2;
            int cenV = arrL.get(center); // teh color value of teh center block

            if(cenV == target){
                return center;
            }else if (cenV < target){ // move up
                bottom = center +1;
            }else{ // if the center value is higher than tagret --> move down and get rid of top half
                top = center -1;
            }
        }

        return -1;
    }

    public void keyPressed(){

        if(key=='a'){// new array same taget

            keyP = 'a';
            nArr=!nArr;
            printS = !printS;// makes it so draw will run
        }
        if(key=='t'){// same array new target
            keyP = 't';
            newRan=!newRan;
            printS = !printS; // make it so draw will run
        }
        if (key == 'n') { // new array and new target
            keyP = 'n';
            nArr=!nArr; // next is
            newRan=!newRan;
            printS = !printS; // make it so will run draw
        }
    }

}
