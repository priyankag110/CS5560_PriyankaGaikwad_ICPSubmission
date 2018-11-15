

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by Mayanka on 09-Sep-15.
 */
object SparkWordCount {

  def main(args: Array[String]) {

    System.setProperty("hadoop.home.dir","C:\\Users\\Shawn\\Downloads\\winutils");

    val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")

    val sc=new SparkContext(sparkConf)

    //val input=sc.textFile("input")
    val inputf = sc.wholeTextFiles(path="data",minPartitions=10)

    inputf.map(abs=>{
      abs._1
      abs._2    })

    val wc=inputf.flatMap(f=>{f._2.split(" ")}).map(word => { word.replaceAll("\\."," ")}).map(word=>(word,1)).cache()

    val output=wc.reduceByKey(_+_)

    output.saveAsTextFile("output")

    val o=output.collect()
    var c=0
    var s:String="Words:Count \n"
    o.foreach{case(word,count)=>{

      s+=word+" : "+count+"\n"
      c+= count
    }}
    print("Total words: " + c + "\n")
  }

}
