/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;      
      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind]; 
  }
  public static String toKind(Token lol) {
    return tokenTable[lol.kind];
  }
  
  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    AND 		= 4, // Cambio Leonardo Farina
    ARRAY		= 5,
    CASE                = 6, // Cambio Leonardo Farina
    CHOOSE              = 7, // Cambio Leonardo Farina
    CONST		= 8,
    DO			= 9,
    ELIF		= 10,  
    ELSE		= 11,
    END			= 12,
    FOR                 = 13, //Agregamos FOR Stephanie Quiros
    FROM                = 14, //Agregamos FROM Stephanie Quiros
    FUNC		= 15,
    IF			= 16,
    IN			= 17,
    LEAVE		= 18, //Agregamos LEAVE Gerald
    LET			= 19,
    NOTHING		= 20, // Agregamos NOTHING   Leonardo Farina
    OF			= 21,
    PRIVATE             = 22, // Agregamos PRIVATE   David Suarez
    PROC		= 23,
    RECORD		= 24,
    RECURSIVE           = 25, // Agregamos RECURSIVE David Suarez
    REPEAT              = 26, //Agregamos REPEAT Stephanie Quiros
    THEN		= 27,
    TYPE		= 28,
    UNTIL               = 29, //Agregamos UNTIL Stephanie Quiros
    VAR			= 30,
    WHEN                = 31,
    WHILE		= 32,

      
  
    // punctuation...
    DOT			= 33,
    COLON		= 34,
    SEMICOLON           = 35,
    COMMA		= 36,
    BECOMES		= 37,
    IS			= 38,
    DOUBLEDOT           = 39, //Agregamos DOUBLEDOT Stephanie Quiros

    // brackets...
    LPAREN		= 40,
    RPAREN		= 41,
    LBRACKET            = 42,
    RBRACKET            = 43,
    LCURLY		= 44,
    RCURLY		= 45,

    // special tokens...
    EOT			= 46,
    ERROR		= 47;
          

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "and", // Cambio Leonardo Farina agragamos "and"
    "array",
    "case", // Cambio Leonardo Farina agragamos "case"
    "choose", // Cambio Leonardo Farina agragamos "nothing"
    "const",
    "do",
    "elif", // Cambio Gerald Zamora
    "else",
    "end",
    "for", //Agregamos for Stephanie Quiros
    "from", //Agregamos from Stephanie Quiros
    "func",
    "if",
    "in",
    "leave",
    "let",
    "nothing", // Cambio Leonardo Farina agragamos "nothing"
    "of",
    "private", // Cambio David Suarez agragamos "private"
    "proc",
    "record",
    "recursive", // Cambio David Suarez agragamos "recursive"
    "repeat", //Agregamos repeat Stephanie Quiros
    "then",
    "type",
    "until", //Agregamos until Stephanie Quiros
    "var",
    "when",
    "while",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "..", //Agregamos .. Stephanie Quiros
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"    
  };

  private final static int	firstReservedWord = Token.AND,  // Cambio Leonardo Farina                               
  				lastReservedWord  = Token.WHILE; 

}
