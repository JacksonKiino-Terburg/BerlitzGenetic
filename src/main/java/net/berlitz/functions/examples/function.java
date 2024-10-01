package net.berlitz.functions.examples;

public interface function {
     public Object call(Object... args);
     public String getName();
     public default int fitnessMaximize(int Chromosome)
     {
          return ((Integer) call(Chromosome));
     }

     public default int fitnessMinimize(int Chromosome)
     {
          return -((Integer) call(Chromosome));
     }
}
