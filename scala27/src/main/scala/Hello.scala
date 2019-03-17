import util.control.Breaks._
object Hello {
  def main(args: Array[String]): Unit = {
    //println("hello\\world")
//    val name = "ApacheCN"
//    val age  = 1
//    val url  = "www.atguigu.com"
//    val sal = 200.3333D;
//    println("name=" + name + " age=" + age + " url=" + url)
//    printf("name=%s, age=%d, url=%s ,sal=%.2f \n", name, age, url,sal)
//    println(s"name=${name + "abc"}, age=${age + 2}, url=$url")

    //var | val 变量名 [: 变量类型] = 变量值

//    var xxx :Int = 1;//int xxx = 1;
//    xxx = 2;
//
//    val yyy = 1;//
//    yyy = 3;


//    var num1 : Int = 10
//    println("num1" + num1)
//    var char1 : Char = 'a'
//    println("char1的code= " + char1.toInt)
//    println("char1的code= " + num1+"")
//      val num1: Int = 10 * 3.5.toInt + 6 * 1.5.toInt
//      val num2: Int = (10 * 3.5 + 6 * 1.5).toInt
//      println(num1 + " " + num2)

//    var xx = 1
//    xx +=1
//    println(xx)
//    var yy = 7
//    var zz = 100
//    var xx = if(yy >5){
//      zz += 100
//      444
//    }else{
//
//    }
//    print(xx)

//    for(i <- 1 until 3) {
//      print(i + " ")
//    }
//    println()

//    for(i <- 1 to 3 if i != 2) {
    //      print(i + " ")
    //    }
//    println()

//    for(i <- 1 to 3; j = 4 - i) {
//      print(j + " ")
//    }
//    for(){
//      j = 4-i;
//    }

//    for{i <- 1 to 3
//        j <- 1 to 3} {
//      println(" i =" + i + " j = " + j)
//    }
//    for(){
//      for(){
//
//      }
//    }

//    val res = for(i <- 1 to 10) yield {
//
//      i+1
//    }
//    println(res)
//

//    for(i <- Range(1,10,3)){
//      println(i)
//    }

//    for(i <- 1 to 10 if i %3 !=0) {
//      print(i + " ")
//    }
//    var xx = 5
//    breakable(while (xx<20){
    //      println("xx")
    //      xx +=1;
    //      if(xx ==10){
    //        break()
    //      }
    //    })
//
//    println("ok~~~")

//    for (i <- 1 to 10 if (i != 2 && i != 3)) {
//      println("i=" + i)
//    }

//    def test (n: Int,m:Int){
//      if (n > 2) {
//        test (n - 1,1)
//      }
//      println("n=" + n) //
//    }
//    println(test(1))
//    def test(n:Int=2)={
//      if(n>0){
//        n
//      }
//    }

//      lazy val res = sum(10, 20)
//      println("-----------------")
//      //println("res=" + res) //在要使用res 前，才执行
//
//      try {
//        val r = 10 / 0
//      } catch {
//        case ex: ArithmeticException=> println("捕获了除数为零的算数异常")
//        case ex: Exception => println("捕获了异常")
//      } finally {
//        // 最终要执行的代码
//        println("scala finally...")
//      }

    var cat = new Cat("huahua",2,4)
    println(cat.name)
    cat.age = 3//age_$eq(a){age = a}
    cat.say()

  }

    def sum(n1 : Int, n2 : Int): Int = {
      println("sum() 执行了..")
      return  n1 + n2
    }
}

class Cat(inName:String,inAge:Int){

  var name :String = inName
  var age = inAge
  def this(a:String,b:Int,c:Int){
    this(a,b);
    println("ok~~~")
  }

  def say(){
    println("miaomiaomiao")
  }
}


//class Person {
//  var name : String = _
//  var age : Int = _
//  def showInfo(): Unit = {
//    println("学生信息如下：")
//    println("名字：" + this.name)
//  }
//}
//
//class Student extends Person {
//  def studying(): Unit = {
//    println(this.name + "学习 scala中....")
//  }
//}

//  public static void main(String[] args){
//    System.out.print("hello");
//  }
