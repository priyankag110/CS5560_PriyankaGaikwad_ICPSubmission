package openie

import java.io.{BufferedWriter, File, FileWriter, PrintWriter}

import org.apache.spark.{SparkConf, SparkContext}

object SparkPOSCount {

  def main(args: Array[String]) {

    System.setProperty("hadoop.home.dir","C:\\Users\\Shawn\\Downloads\\winutils")

    val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]").set("spark.executor.memory", "4g").set("spark.driver.memory", "2g")

    val sc=new SparkContext(sparkConf)
    val inputf = sc.wholeTextFiles(path="C:\\Users\\Shawn\\Documents\\GitHub\\CS5560_PriyankaGaikwad_Lab\\Lab 1\\Retrive_abstract\\new_data_alzimers\\projectdata",minPartitions=2)
    val file = new File("finalData/nouns&verbs.txt")
    val bw = new BufferedWriter(new FileWriter(file))
    //val inputf = sc.wholeTextFiles("data", 100)
    val input = inputf.map(abs => {
      abs._1
      abs._2
    }).cache()

    // val input=sc.textFile("input", 10)

    val wc=input.flatMap(abstracts=> {abstracts.split("\n")}).map(singleAbs => {
      CoreNLP.returnSentences(singleAbs)
    }).map(sentences => {
      CoreNLP.returnPOS(sentences)
    }).flatMap(wordPOSLines => {
      wordPOSLines.split("\n")
    }).map(wordPOSPair => {
      wordPOSPair.split("\t")
    }).map(wordPOS => (wordPOS(1), 1)).cache()

    val output = wc.reduceByKey(_+_)

    output.saveAsTextFile("output")

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

