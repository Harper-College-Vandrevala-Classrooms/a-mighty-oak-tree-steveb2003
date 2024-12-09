package com.csc;
import java.util.Scanner;
import java.util.ArrayList;
import com.csc.Squirrel;


public class OakTree {
  public static ArrayList<String> position_name = new ArrayList<>(); //stores name of each branch added
  public static ArrayList<Integer> position_status = new ArrayList<>(); //stores information if each branch is vacant or occupied (1 or 0)
  public static Scanner in = new Scanner(System.in);
  public static Squirrel squirrel;
  public static void main(String[] args) {
    position_name.add("L"); //initial positions are the 2 branches
    position_name.add("R");

    position_status.add(1); //0 means not occupied, 1 means occupied
    position_status.add(0);
    
    System.out.println("Please enter name of squirrel. ");
    String entry = in.next();
    squirrel = new Squirrel(entry);
    boolean running = true;
    while(running)
    {
      System.out.println("Please enter 'add_left' to add new left branch. \nPlease enter 'add_right' to add right branch. \nPlease enter 'move_left' to move squirrel left. \nPlease enter 'move_right' to move squirrel right. \nPlease enter 'move_back' to move squirrel back. \nPlease enter 'view_position' to view squirrel position. \nPlease enter 'exit' to exit program.");
      String choice = in.next();
      switch(choice)
      {
        case "add_left":
          add_left();
          break;
        case "add_right":
          add_right();
          break;
        case "move_left":
          move_left();
          break;
        case "move_right":
          move_right();
          break;
        case "move_back":
          move_back();
          break;
        case "view_position":
          view_position();
          break;
        case "exit":
          running = false;
          break;
    
      }
      
      
    }
    in.close();
  }
  public static void add_left()
  {
    System.out.print("Please enter name of the position to add a left branch to. Type in the relative position as a sequence of L's and R's (ex. left, left, right is written as LLR. ): ");
    String L_position = in.next();
    if (position_name.contains(L_position))
    {
      String L_position_new = L_position + "L"; //new position where squirrel will move
      position_name.add(L_position_new);
      position_status.add(0); //add corresponding status spot for the new position
      System.out.println("Left Branch added");
    }
    else 
    {
      System.out.println("Previous branches needed to create this branch do not exist yet.");
    }
  }

  public static void add_right()
  {
    System.out.print("Please enter name of the position to add a right branch to. Type in the relative position as a sequence of L's and R's (ex. left, left, right is written as LLR. ) ");
    String R_position = in.next();
    if (position_name.contains(R_position))
    {
      String R_position_new = R_position + "R"; //new position where squirrel will move
      position_name.add(R_position_new);
      position_status.add(0); //add corresponding status spot for the new position
      System.out.println("Right Branch added");
    }
    else 
    {
      System.out.println("Previous branches needed to create this branch do not exist yet.");
    }
  }

  public static void move_left()
  {
    int index_L = 0;
    int current_position_L=0;
    while (index_L < position_status.size())
    {
      if (position_status.get(index_L) != 1)
      {
        index_L++;
        continue;
      }
      else 
      {
        current_position_L = index_L; //curent position of squirrel
        break;
      }
    }
    String destination_name_L = position_name.get(current_position_L) + "L";
    if (position_name.contains(destination_name_L))
    {
      int index_destination_L = position_name.indexOf(destination_name_L);
      position_status.set(current_position_L,0); //make current position vacant
      position_status.set(index_destination_L,1); //make new position occupied
      System.out.println(squirrel.getName()+ " moved left");
    }
    else
    {
      System.out.println("This branch has not been added yet");
    }
  }

  public static void move_right()
  {
    int index_R = 0;
    int current_position_R=0;
    while (index_R < position_status.size())
    {
      if (position_status.get(index_R) != 1)
      {
        index_R++;
        continue;
      }
      else 
      {
        current_position_R = index_R; //curent position of squirrel
        break;
      }
    }
    String destination_name_R = position_name.get(current_position_R) + "R";
    if (position_name.contains(destination_name_R))
    {
      int index_destination_R = position_name.indexOf(destination_name_R);
      position_status.set(current_position_R,0); //make current position vacant
      position_status.set(index_destination_R,1); //make new position occupied
      System.out.println(squirrel.getName()+ " moved right");
    }
    else
    {
      System.out.println("This branch has not been added yet");
    }
  }

  public static void move_back()
  {
    int index_back=0;
    int current_node=0;
    while (index_back < position_status.size())
    {
      if (position_status.get(index_back)!=1)
      {
        index_back++;
        continue;
      }
      else
      {
        current_node = index_back; //curent position of squirrel
        break;
      }
    }
    String current_node_name = position_name.get(current_node);
    String new_node_name = current_node_name.substring(0,current_node_name.length()-1);
    if (position_name.contains(new_node_name))
    {
      int new_node_index = position_name.indexOf(new_node_name);
      position_status.set(current_node,0); //make current position vacant
      position_status.set(new_node_index,1); //make new position occupied
      System.out.println(" Moved back");
    }
  }

  public static void view_position()
  {
    int final_position = position_status.indexOf(1);
    String final_position_name = position_name.get(final_position);
    System.out.println(squirrel.getName() + " is currently at " + final_position_name );
  }
}
