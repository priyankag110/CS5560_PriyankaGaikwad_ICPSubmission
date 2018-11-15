package openie

import java.io.{BufferedWriter, File, FileWriter, PrintWriter}

import org.apache.spark.{SparkConf, SparkContext}

object SparkPOSCount {

  def main(args: Array[String]) {

    System.setProperty("hadoop.home.dir","C:\\Users\\Shawn\\Downloads\\winutils")

    val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]").set("spark.executor.memory", "4g").set("spark.driver.memory", "2g")

    val sc=new SparkContext(sparkConf)
    val inputf = sc.wholeTextFiles(path="data",minPartitions=30)
    //val file = new File("finalData/nouns&verbs.txt")
    //val bw = new BufferedWriter(new FileWriter(file))
    //val inputf = sc.wholeTextFiles("data", 100)


    // val input=sc.textFile("input", 10)

    val output = inputf.map(line =>  CoreNLP.getPOS(line._2)).flatMap(list => list).map(word => (word._2,1)).reduceByKey(_+_)

    output.saveAsTextFile("output/POS")


    val o=output.collect()

    var nouns = 0
    var verbs = 0

    o.foreach{case(word,count)=> {

      if(word.contains("NN")) {
        nouns += count
      }
      else if(word.contains("VB")) {
        verbs += count
      }

    }}

    val outputFile = new PrintWriter(new File("finalData/count.txt"))
    outputFile.write("Total Nouns: " + nouns + "\nTotal Verbs: " + verbs)
    outputFile.close()


  }

}



