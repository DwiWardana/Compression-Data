package com.parsect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

public class bcd {

    public static void usage(){
        System.out.println("Usage: bcd [options]");
        System.out.println("\nOptions:");
        System.out.println("\t-f: File/document to compress");
        System.out.println("\t-o: Output name after compressing");
        System.out.println("\t-h: Print this help information");
        System.exit(1);
    }
    private static String[] parserArg(String args[]){
        String file = "",outputFile = "";
        for (var i=0; i < args.length; i++){
            if (args[i].contentEquals("-f")){
                file = args[i+1];
                i++;
            } else if (args[i].contentEquals("-o")){
                outputFile = args[i+1];
                i++;
            } else{
                System.out.println("Error: Unkown Options "+args[i]);
                System.exit(1);
            }
        }
        return new String[] {file, outputFile};
    }
    public static byte[] shellSort(byte[] data){
        int n = data.length;
        for (int gap = n/2; gap > 0; gap /= 2){
            for (int i = gap; i < n; i += 1){
                int temp = data[i];

                int j;
                for (j = i; j >= gap && data[j - gap] > temp; j -= gap)
                    data[j] = data[j - gap];
                data[j] = (byte) temp;
            }
        }
        return data;
    }

    public static int[] byte2int(byte[] data){
        try {
            int[] newData = {data.length};
            System.out.println(Arrays.toString(data));
            for (int x = 0; x < data.length; x++) {
                newData[x] = ((int) Byte.toUnsignedInt(data[x]));
            }
            System.out.println(newData.length);
            return newData;
        } catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            Dictionary n = new Hashtable();
;
            String HEADER = "PRSCT";
            String CHUNK = "";
            System.out.print("Start program!\n");
            long starttime = System.currentTimeMillis();
            String file = "", output = "";
            if (args.length < 4) {
                usage();
            } else {
                String[] arg = parserArg(args);
                file = arg[0];
                output = arg[1];
            }
            byte[] data = fileprocess.readingFile(file);
            System.out.println("Succeed read file");
            System.out.println(data[0]+", "+data[data.length-1]);

            fileprocess.writeFile(data,output);

            System.out.println("Start Sorting data!");
            byte[] sortedData = shellSort(data);
            System.out.println(sortedData[0]+", "+sortedData[sortedData.length-1]);

            int[] intData = byte2int(sortedData);
            System.out.println("========");
            System.out.println(intData[0]);
            System.out.println((System.currentTimeMillis()-starttime)/1000+"S");
        } catch (Exception e){
            System.out.println("Error: "+e);
            System.exit(1);
        }
    }
}
