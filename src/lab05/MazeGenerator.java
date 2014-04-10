/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab05;

import java.awt.Point;
import java.util.LinkedList;

public class MazeGenerator implements MazeListener {

    Maze maze;
    double intt;
    int newx;
    int newy;
    double intt1;
    int xbound = 30;
    int ybound = 50;
    LinkedList<Point> ll = new LinkedList();
    LinkedList<Point> Fl = new LinkedList();
    

    public MazeGenerator() {
        // a 30 rows x 50 columns maze
        maze = new Maze(xbound, ybound);

        // register object of class Main to the maze
        maze.addMazeListener(this);

        // an example how to call "showPath"'
        // the list I generate here is not a valid path, but just some
        // arbitrary values
        // this will generate some red boxes in your display.

    }

    public void MazeClicked(int row, int col) 
    {
       
       System.out.println("You clicked " + row + " " + col+". " + maze.getMazeData(row, col));
       /*if (maze.getMazeData(row, col)==7 || maze.getMazeData(row, col)==13 || maze.getMazeData(row, col)==14 || maze.getMazeData(row, col)==11){
           System.out.println("YAY!");
       }*/
      FindPath(row, col);
      maze.showPath(ll.iterator());
      ll.clear();
      Fl.clear();
    }
    
    public void FindPath(int y, int x)
    {   
       
            ll.addFirst(new Point(y, x));
            
            if(((maze.getMazeData(y,x)>>5)&1)==1)
            {
                System.out.println("Solved.");
            }
            else if(((maze.getMazeData(y,x)&1)==0)&&(ll.contains(new Point(y-1,x))==false)&&((Fl.contains(new Point(y-1,x))==false)))
            {
                
                FindPath(y-1, x);
                
            }
            else if((((maze.getMazeData(y,x)>>1)&1)==0)&&(ll.contains(new Point(y,x-1))==false)&&((Fl.contains(new Point(y,x-1))==false)))
            {
                
                FindPath(y, x-1);
                
            }
            else if((((maze.getMazeData(y,x)>>2)&1)==0)&&(ll.contains(new Point(y+1,x))==false)&&((Fl.contains(new Point(y+1,x))==false)))
            {
                
                FindPath(y+1, x);
                
            }
            else if((((maze.getMazeData(y,x)>>3)&1)==0)&&(ll.contains(new Point(y,x+1))==false)&&((Fl.contains(new Point(y,x+1))==false)))
            {
                
                FindPath(y, x+1);
                
            }
            
            else
            {
                ll.removeFirst();
                Fl.addFirst(new Point(y,x));
                                    
                   intt = (ll.getFirst().getX());
                   newy = (int)intt;
                   intt1 = (ll.getFirst().getY());
                   newx = (int)intt1;
                   
                   if(ll.size()>1){
                    ll.removeFirst(); 
                }
                   
                FindPath(newy, newx);
            }
              
                //System.exit(0);
            
        
    }
    

    public static void main(String[] args)
    {
        new MazeGenerator();
    }
   

}