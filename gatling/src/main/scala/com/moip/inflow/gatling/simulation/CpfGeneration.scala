package com.moip.inflow.gatling.simulation
import scala.collection.mutable.ListBuffer

object CpfGeneration {

  var sum = 0

  def calculation(cpf: ListBuffer[Int] ,tam: Int): ListBuffer[Int] =  {
    {
      var i = tam
      sum = 0

      cpf.foreach{
        x => i -= 1

          var suma = (x * i)
          sum = sum + suma
      }
    }

    var digit = (11 - (sum % 11))

    if (digit < 10) {
      cpf += digit
    }

    else {
      cpf += 0
    }
    return cpf
  }
  def create(): String = {

    val r = scala.util.Random

    var cpf = new ListBuffer[Int]()

    for (i <- 1 to 9){
      cpf += r.nextInt(9)
    }

      var digit1 = calculation(cpf, 11)
      var digit2 = calculation(digit1, 12)
      var cpf_string = ""

      for {
        i <- digit2
      } cpf_string = cpf_string + i.toString
      cpf_string
  }
}
