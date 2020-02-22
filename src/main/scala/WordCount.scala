import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment}

object WordCount {
  def main(args: Array[String]): Unit = {
    //创建环境
    val env:ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    //读取文件
    val input ="F:\\date\\1.txt"

    //有限数据集
    val dataset=env.readTextFile(input)
    import org.apache.flink.api.scala._
    val aggDs = dataset.flatMap(_.split("")).map((_,1)).groupBy(0).sum(1)
    aggDs.print()
  }
}
