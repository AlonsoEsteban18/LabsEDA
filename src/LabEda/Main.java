package LabEda;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StopwatchCPU;
import edu.princeton.cs.algs4.DoublingRatio;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static List<Integer> generarLista(int n){
        List<Integer> lista = new ArrayList<>();
        boolean[] usado = new boolean[n*4];
        while(lista.size()<n){
            int num = StdRandom.uniform(0,n*4);
            if(!usado[num]){
                usado[num] = true;
                lista.add(num);
            }
        }
        return lista;
    }
    public static void main(String[] args){

        int[] tamanios = {32, 64, 128, 256, 512, 1024};
        for(int n : tamanios){
            StdRandom.setSeed(12345+n);
            Out out = new Out("datos_"+n+".csv");
            for(int i=0; i<100; i++){
               List<Integer> lista = generarLista(n);
               int k = StdRandom.uniformInt(1, (n/4) + 1);
                List<Integer> copia1 = new ArrayList<>(lista);
                List<Integer> copia2 = new ArrayList<>(lista);
                List<Integer> copia3 = new ArrayList<>(lista);

                StopwatchCPU t1 = new StopwatchCPU();
                for(int r=0;r<10000;r++){
                    Result.cuentaPares(n, copia1 , k);
                }
                double tiempo1 = t1.elapsedTime();

                StopwatchCPU t2 = new StopwatchCPU();
                for(int r=0;r<10000;r++){
                    Result.cuentaPares2(n, copia2, k);
                }
                double tiempo2 = t2.elapsedTime();

                StopwatchCPU t3 = new StopwatchCPU();
                for(int r=0;r<10000;r++){
                Result.cuentaPares3(n, copia3, k);
                }
                double tiempo3 = t3.elapsedTime();

                out.println(tiempo1 + "," + tiempo2+ "," + tiempo3);
            }
            out.close();
        }
        System.out.println("Experimento Finalizado");
    }

    }

