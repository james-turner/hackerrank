package TradeDesk

object TradeDeskJsonParser extends App {

  val example1=
    """
      |{
      | "a" : "hi"
      |}
      |""".stripMargin

  val badexample1=
    """
      |{
      | "a " : "hi"
      |}
      |""".stripMargin
  val example2 = """
      |--------------------------------------------------
      |{
      | "a" : "hi",
      | "b" : { "c": "hello" }
      |}
      |--------------------------------------------------
      |{
      | "a" : ["x","y",1.5]
      |}
      |--------------------------------------------------
      |{
      | "a" : 123,
      | "b" : { "c" : [1,2,3] , "d" : null },
      | "e" : "hello",
      | "f" : false
      |}
      |""".stripMargin


  """
    |{ "k": }
    |""".stripMargin


  def validateSchema(s: String): Boolean = {

    def inner(pos: Int, stack: List[Char]): Boolean = {
      if(pos >= s.length) stack.isEmpty
      if(s(pos) == '{') {
        inner(pos+1, s(pos) +: stack)
      }
      else if(s(pos) == '}' && stack(0)!= '{') false
      else if(s(pos) == '}' && stack(0)== '{') {
        inner(pos+1, stack.tail)
      }
      else if(s(pos) == '"' && stack.head != '"') {
        // open quote situation
        inner(pos+1, s(pos) +: stack)
      }
      else if(s(pos) == '"' && stack.head == '"') {
        // close quote situation
        // need to know are we in a key situation
        // top of stack should look like {
        inner(pos + 1, ':' +: stack.tail)
      } else if(s(pos) == ':' && stack.head == '"') {
        // in key context
        inner(pos+1, stack)
      } else if(s(pos) == ':' && stack.head != ':') false
      else if(s(pos) == ':' && stack.head == ':') {
        inner(pos+1, stack.tail)
      }
      else if(s(pos) == '"') {
        inner(pos+1, stack)
      } else {
        false
      }

    }

//    inner(0)

    false
  }

  assert(validateSchema(example1))
  assert(!validateSchema(badexample1))



}
