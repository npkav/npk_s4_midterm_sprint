// Nickolas Kavanagh
// Semester 4 Midterm Sprint
// 14/6/2025 - 22/06/2025

package org.example;

import java.util.ArrayList;
import java.util.List;


// my take on the undo/redo program was to use a stack to store array lists of states with pointers to navigate through the stack.
// generic type used to allow for any type of state to be stored in the stack, objects will be overwritten when new states are added after undo.

public class UndoRedo<T> {
    
    private List<T> stack; // stack list
    private int index; // current state index
    
    // initial state for the undo/redo stack
    public UndoRedo(T state) {
        stack = new ArrayList<>();
        stack.add(state);
        index = 0;
    }
    
    // add new state to stack
    public void save(T state) {
        // overwrite any states after current position when adding after undo
        while (stack.size() > index + 1) stack.remove(stack.size() - 1);
        stack.add(state);
        index++;
    }
    
    // back one step
    public boolean undo() {
        if (index > 0) {index--; return true;}
        else return false;
    }
    
    // forward one step
    public boolean redo() {
        if (index < stack.size() - 1) {index++; return true;}
        else return false;
    }
    
    // current state
    public T get() {return stack.get(index);}
    
    // test - print entire chain
    public void printChain() {
        for (int index = 0; index < stack.size(); index++) {
            if (index == this.index) System.out.print("[" + stack.get(index) + "]");
            else System.out.print(stack.get(index));
            
            if (index < stack.size() - 1) System.out.print(" -> ");
            else System.out.println();
        }
    }
}