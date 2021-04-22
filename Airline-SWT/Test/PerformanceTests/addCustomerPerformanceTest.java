package PerformanceTests;

import source.addCustomer;

public class addCustomerPerformanceTest {

   //@Benchmark
   //@Fork(value =1, warmups =2)
   //@BenchmarkMode(Mode.Throughput)
   public void init(){
      addCustomer.getVisibility();
   }

  // public static void main(String[] args) throws Exception {
      //org.openjdk.jmh.Main.main(args);
  // }

}