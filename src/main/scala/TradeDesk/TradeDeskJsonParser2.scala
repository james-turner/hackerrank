package TradeDesk

object TradeDeskJsonParser2 extends App {

//  val example1=
//    """
//      |{
//      | "a" : "hi"
//      |}
//      |""".stripMargin
//
//  val badexample1=
//    """
//      |{
//      | "a " : "hi"
//      |}
//      |""".stripMargin
//  val example2 = """
//      |--------------------------------------------------
//      |{
//      | "a" : "hi",
//      | "b" : { "c": "hello" }
//      |}
//      |--------------------------------------------------
//      |{
//      | "a" : ["x","y",1.5]
//      |}
//      |--------------------------------------------------
//      |{
//      | "a" : 123,
//      | "b" : { "c" : [1,2,3] , "d" : null },
//      | "e" : "hello",
//      | "f" : false
//      |}
//      |""".stripMargin
//
//
//  """
//    |{ "k": }
//    |""".stripMargin
//
//
//  def validateSchema(s: String): Boolean = {
//
//
//
//  }
//
  def lex(pos: Int, s: String, acc: List[String]): List[String] = {
    if(pos >= s.length) acc
    else {
      lex_string(pos,s) match {
        case (newpos, Some(token)) => lex(newpos, s, acc :+ token)
        case _ =>
          lex_boolean(pos, s) match {
            case (newpos, Some(token)) => lex(newpos, s, acc :+ token)
            case _ =>
              lex_number(pos, s) match {
                case (newpos, Some(token)) => lex(newpos, s, acc :+ token)
                case _ =>
                  if(s(pos)==' ') lex(pos+1, s, acc)
                  else if(s(pos) == '[' || s(pos) == ']' || s(pos) == '{' || s(pos) == '}' || s(pos) == ',' || s(pos) == ':') lex(pos+1, s, acc :+ s(pos).toString)
                  else throw new Exception(s"Unexpected character '${s(pos)}' at position ${pos}")
              }
          }
      }
    }
  }

  def lex_boolean(pos: Int, s: String): (Int,Option[String]) = {
    if(s.slice(pos, pos+4) == "true") (pos+4, Some("true"))
    else if(s.slice(pos, pos+5) == "false") (pos+5, Some("false"))
    else (pos, None)
  }
  def lex_string(pos: Int, s: String): (Int,Option[String]) = {
    if(s(pos)=='"'){
      // read until close quote
      // return
      def inner(pos: Int): Int = {
        if(pos >= s.length) throw new Exception("Unterminated string literal")
        if(s(pos)=='"') pos
        else inner(pos+1)
      }
      val terminatedStringPos = inner(pos + 1)
      (terminatedStringPos+1,Some(s.slice(pos,terminatedStringPos+1)))
    } else {
      (pos,None)
    }
  }

  def lex_number(pos: Int, s: String): (Int,Option[String]) = {
    if(s(pos).toInt < 47 || s(pos) > 58) (pos, None)
    else {
      def inner(pos: Int): Int = {
        if(s(pos).toInt < 47 || s(pos) > 58) pos
        else inner(pos+1)
      }
      val nextPos = inner(pos)
      (nextPos, Some(s.slice(pos, nextPos)))
    }
  }


  def parse(tokens: List[String]): List[String] = {
    tokens match {
//      case head :: tail if head == "{" => parse_object(tail)
      case Nil => Nil
      case head :: tail if head == "[" => parse_array(tail)
      case _ :: tail => tail
    }
  }

  def parse_array(tokens: List[String]): List[String] = {
    tokens match {
      case head :: tail if head == "]" => parse(tail)
      case _ => {
        parse(tokens) match {
          case head :: tail if head == "]" => parse(tail)
          case head :: tail if head == "," => parse_array(tail)
          case _ => throw new Exception("Bad array")
        }

      }
    }
  }

//  println(lex(0, "[true]", List()))
//  val tokens = lex(0, "{\"a\":[\"hello\",1, true]}", List())
  val tokens = lex(0, "[[3]]", List())
  parse(tokens)
}
